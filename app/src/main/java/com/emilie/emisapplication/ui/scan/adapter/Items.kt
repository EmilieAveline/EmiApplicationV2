package com.emilie.emisapplication.ui.scan.adapter
import android.bluetooth.BluetoothDevice

// Représente les données
data class Items (
    var name: String?,
    var mac: String?,
    var device: BluetoothDevice
) {
    override fun equals(other: Any?): Boolean {
        // On compare les MAC, pour ne pas ajouté deux fois le même device dans la liste.
        return other is Items && other.mac == this.mac
    }
}
