package com.example.googleanalyticsassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.googleanalyticsassignment.Modle.Categories
import com.example.googleanalyticsassignment.R


class CategAdapter(private val context: Context, var data: ArrayList<Categories>) : BaseAdapter() {

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
        val itemView = inflater.inflate(R.layout.categories_item, parent, false)


        val tvCName = itemView.findViewById(R.id.tvCName) as TextView
        tvCName.text = data[position].name

        val categImg = itemView.findViewById(R.id.categImg) as ImageView
        categImg.setImageResource(data[position].img)


        return itemView
    }

}