package com.martinm.sharedocks

import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.preference.PreferenceFragmentCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.concurrent.CountDownLatch

object Utils {
    const val RECEIVER_REQUEST_ID_ACTIVITY_TRANSITION = 0
    const val RECEIVER_REQUEST_ID_STOP_TRACKING = 1

    private val mApi = ShareApiHandler
    private lateinit var mTextPopup: PopupWindow
    var isMapLoading = false
    var stopLoadRequest = false
    var favoritesPopup: PopupWindow? = null

    private fun containsId(list: MutableList<ShareStation>, id: String): ShareStation? {
        list.forEach {
            if (it.id == id) {
                return it
            }
        }
        return null
    }

    private fun addStation(list: MutableList<ShareStation>, station: ShareStation) {
        if (containsId(list, station.id) == null) {
            list.add(station)
        }
    }

    private fun removeStation(list: MutableList<ShareStation>, station: ShareStation) {
        val listStation: ShareStation? = containsId(list, station.id)
        if (listStation != null) {
            list.remove(listStation)
        }
    }

    fun loadUserDocks() {
        LogicHandler.userDocks.clear()
        ConfigurationHandler.stationIdListFromStorageString().forEach {
            if (mApi.docks[it] != null) {
                addStation(LogicHandler.userDocks, mApi.docks[it]!!)
            }
        }
    }

    fun toggleUserDock(station: ShareStation) {
        if (containsId(LogicHandler.userDocks, station.id) == null) {
            addStation(LogicHandler.userDocks, station)
        } else {
            removeStation(LogicHandler.userDocks, station)
        }
    }

    fun getButtonStringForId(context: Context, id: String): String {
        return if (containsId(LogicHandler.userDocks, id) != null) {
            context.getString(R.string.popup_button_remove)
        } else {
            context.getString(R.string.popup_button_add)
        }
    }

    fun safeLoadDockLocations(context: Context) {
        try {
            mApi.loadDockLocations()
        } catch (e: Exception) {
            Handler(context.mainLooper).post {
                Toast.makeText(
                    context,
                    context.getString(R.string.toast_error_network),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun safeUpdateDockStatus(context: Context) {
        try {
            mApi.updateDockStatus()
        } catch (e: Exception) {
            Handler(context.mainLooper).post {
                Toast.makeText(
                    context,
                    context.getString(R.string.toast_error_network),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun isStationStatusChanged(
        userStations: MutableList<ShareStation>,
        currentUnavailableIds: MutableList<String>,
        newChanges: MutableMap<String, Boolean>
    ): Boolean {
        var isChanged = false
        userStations.forEach {
            if (!it.isActive || it.availableDocks == 0) {
                if (!currentUnavailableIds.contains(it.id)) {
                    isChanged = true
                    currentUnavailableIds.add(it.id)
                    newChanges[it.id] = false
                }
            } else {
                if (currentUnavailableIds.contains(it.id)) {
                    isChanged = true
                    currentUnavailableIds.remove(it.id)
                    newChanges[it.id] = true
                }
            }
        }
        return isChanged
    }

    fun buildTrackingTTS(context: Context, stationId: String, isAvailable: Boolean): String {
        if (mApi.docks[stationId] == null) {
            return ""
        }

        val stationTTS = mApi.docks[stationId]!!.name.replace(
            "/",
            context.getString(R.string.tts_replace_intersection)
        )

        if (isAvailable) {
            return context.getString(R.string.tts_update_available, stationTTS)
        }

        return context.getString(R.string.tts_update_full, stationTTS)
    }

    fun setupFavoritesButtonCallback(context: AppCompatActivity, map: GoogleMap) {
        context.findViewById<ImageButton>(R.id.button_favorites).setOnClickListener {
            FavoritesHandler.loadFavoritesPage(context, map)
        }
    }

    fun setupSettingsButtonCallback(context: AppCompatActivity) {
        context.findViewById<ImageButton>(R.id.button_settings).setOnClickListener {
            if (this::mTextPopup.isInitialized) {
                mTextPopup.dismiss()
            }
            context.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            context.title = context.getString(R.string.actionbar_title_settings)
            context.supportFragmentManager
                .beginTransaction()
                .replace(R.id.map, BackgroundOverlayFragment())
                .replace(R.id.settings_background_fragment, SettingsFragment())
                .commit()
        }
        context.findViewById<ImageButton>(R.id.button_settings)
            .setColorFilter(context.getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY)
    }

    fun showNoCitySelectedPopup(context: AppCompatActivity) {
        val popupView =
            (context.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.text_popup, context.findViewById(R.id.map), false)
        mTextPopup = PopupWindow(
            popupView,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        while (!context.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            Thread.sleep(100)
        }
        context.runOnUiThread {
            mTextPopup.showAtLocation(
                context.findViewById(R.id.map),
                Gravity.CENTER,
                0, 0
            )
        }
    }

    fun centerMap(map: GoogleMap, zoom: Float) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ShareStation.userLocation, zoom))
    }

    fun setupMap(context: AppCompatActivity, map: GoogleMap, markers: MutableList<Marker>) {
        var latch = CountDownLatch(1)
        isMapLoading = true

        context.runOnUiThread {
            markers.forEach {
                it.remove()
            }
            latch.countDown()
        }
        latch.await()
        markers.clear()
        latch = CountDownLatch(1)

        safeLoadDockLocations(context)
        safeUpdateDockStatus(context)
        loadUserDocks()
        mApi.sortableDocks.sort()

        context.runOnUiThread {
            context.findViewById<ImageButton>(R.id.button_favorites).visibility = View.VISIBLE
            mApi.sortableDocks.forEach {
                val marker = map.addMarker(MarkerOptions().position(it.location))
                marker.tag = it
                markers.add(marker)
            }
            latch.countDown()
        }
        if (ConfigurationHandler.getColorOnMarkers()) {
            // Sync with the initialization of the markers
            latch.await()
            markers.forEach {
                if (stopLoadRequest) {
                    return@forEach
                }
                context.runOnUiThread {
                    it.setIcon(
                        BitmapDescriptorFactory.defaultMarker(
                            (it.tag as ShareStation).hue
                        )
                    )
                }
                // Unblock UI thread to allow for responsiveness
                Thread.sleep(ConfigurationHandler.getUIResponsiveness().toLong())
            }
        }
        stopLoadRequest = false
        isMapLoading = false
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.settings_definition, rootKey)
        }
    }

    class BackgroundOverlayFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.settings_background_fragment, container, false)
        }
    }
}