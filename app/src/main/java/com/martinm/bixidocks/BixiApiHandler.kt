package com.martinm.bixidocks

import com.google.android.gms.maps.model.LatLng
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.time.Instant

object BixiApiHandler {
    var docks = mutableMapOf<Int, BixiStation>()

    private fun getDocksInfoJson(): JSONArray {
        val url = URL("https://secure.bixi.com/data/stations.json")
        try {
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"
                inputStream.bufferedReader().use {
                    /*
                     * Note: There are "schemeSuspended" and "timestamp" as top level entries that
                     * we might or might not need in the future (winter?)
                     */
                    return JSONObject(it.readText()).getJSONArray("stations")
                }
            }
        } catch (e: Exception) {
            // TODO: handle exception when there's an issue getting the stations.json
            return JSONArray()
        }
    }

    private fun getBixiStationFromJson(obj: JSONObject): BixiStation {
        return BixiStation(
            location = LatLng(obj.getDouble("la"), obj.getDouble("lo")),
            id = obj.getInt("id"),
            availableBikes = obj.getInt("ba"),
            availableDocks = obj.getInt("da"),
            // Active if Blocked, Suspended, Maintenance are "false", and State is 1 (active)
            isActive = obj.getInt("st") == 1 &&
                    !obj.getBoolean("b") &&
                    !obj.getBoolean("su") &&
                    !obj.getBoolean("m"),
            lastUpdate = Instant.ofEpochMilli(obj.getLong("lu")),
            name = obj.getString("s")
            /*
             * Note: The following API entries aren't used for now
             * - "n" : ID for the station terminal (?)
             * - "lc" : Epoch of last connection to the server
             * - "bk" : Unused at the API level
             * - "bl" : Unused at the API level
             * - "dx" : Unavailable docks
             * - "bx" : Unavailable bikes
             */
        )
    }

    fun loadDockLocations() {
        var stations = getDocksInfoJson()
        for (i in 0 until stations.length()) {
            val station = getBixiStationFromJson(stations.getJSONObject(i))
            docks[station.id] = station
        }
    }
}