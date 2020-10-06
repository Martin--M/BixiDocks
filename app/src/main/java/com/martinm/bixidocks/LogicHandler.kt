package com.martinm.bixidocks

import android.content.Context
import android.location.Location

object LogicHandler {
    var userDocks = mutableListOf<BixiStation>()
    var closestStations = mutableListOf<BixiStation>()
    private var mBixi = BixiApiHandler

    private fun containsId(list: MutableList<BixiStation>, id: Int): BixiStation? {
        list.forEach {
            if (it.id == id) {
                return it
            }
        }
        return null
    }

    private fun addStation(list: MutableList<BixiStation>, station: BixiStation) {
        if (containsId(list, station.id) == null) {
            list.add(station)
        }
    }

    private fun removeStation(list: MutableList<BixiStation>, station: BixiStation) {
        val listStation: BixiStation? = containsId(list, station.id)
        if (listStation != null) {
            list.remove(listStation)
        }
    }

    fun toggleUserDock(station: BixiStation) {
        if (containsId(userDocks, station.id) == null) {
            addStation(userDocks, station.copy())
        } else {
            removeStation(userDocks, station)
        }
    }

    fun getButtonStringForId(context: Context, id: Int): String {
        val res = context.resources
        return if (containsId(userDocks, id) != null) {
            res.getString(res.getIdentifier("popup_button_remove", "string", context.packageName))
        } else {
            res.getString(res.getIdentifier("popup_button_add", "string", context.packageName))
        }
    }

    fun isReorderingNeeded(newLocation: Location): Boolean {
        val results: FloatArray = floatArrayOf(1F)
        Location.distanceBetween(
            newLocation.latitude, newLocation.longitude,
            BixiStation.userLocation.latitude, BixiStation.userLocation.longitude, results
        )
        // We only reorder stations if the user has moved more than 100m
        if (results[0] <= 100) {
            return false
        }
        return true
    }

    fun isUserCloseToStation(): Boolean {
        val results: FloatArray = floatArrayOf(1F)
        if (mBixi.sortableDocks.size < 10) {
            return false
        }
        for (i in 0 until 10) {
            Location.distanceBetween(
                mBixi.sortableDocks[i].location.latitude, mBixi.sortableDocks[i].location.longitude,
                BixiStation.userLocation.latitude, BixiStation.userLocation.longitude, results
            )
            // Closer than 3m to the station, assume user is taking a bike
            if (results[0] <= 3) {
                return true
            }
        }
        return false
    }
}