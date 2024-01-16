package com.emilie.emisapplication.ui.scan.adapter

import android.bluetooth.BluetoothClass
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emilie.emisapplication.R

class Adapteur(private val deviceList: MutableList<Items>, private val onClick: ((selectedDevice: Items) -> Unit)? = null) : RecyclerView.Adapter<Adapteur.ViewHolder>() {

    // Comment s'affiche ma vue
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun showItem(device: Items, onClick: ((selectedDevice: Items) -> Unit)? = null) {
            itemView.findViewById<TextView>(R.id.nom).text = device.name
            itemView.findViewById<TextView>(R.id.adresse).text = device.mac

            if(onClick != null) {
                itemView.setOnClickListener {
                    onClick(device)
                }
            }
        }
    }

    // Retourne une « vue » / « layout » pour chaque élément de la liste
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    // Connect la vue ET la données
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.showItem(deviceList[position], onClick)
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

}