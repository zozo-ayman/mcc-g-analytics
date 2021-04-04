package com.example.googleanalyticsassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.googleanalyticsassignment.Modle.Prod
import com.example.googleanalyticsassignment.R

class ProdAdapter(private val context: Context, var data: ArrayList<Prod>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView = inflater.inflate(R.layout.prod_item, parent, false)

        val tvPName = itemView.findViewById(R.id.tvPName) as TextView
        tvPName.text = data[position].name

        val tvPDescription = itemView.findViewById(R.id.tvPDescription) as TextView
        tvPDescription.text = data[position].description

        val prodImg = itemView.findViewById(R.id.prodImg) as ImageView
        prodImg.setImageResource(data[position].img)
        return itemView
    }
}