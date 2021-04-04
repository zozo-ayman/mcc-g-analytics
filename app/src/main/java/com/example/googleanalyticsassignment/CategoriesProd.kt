package com.example.googleanalyticsassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import com.example.googleanalyticsassignment.Adapter.ProdAdapter
import com.example.googleanalyticsassignment.Modle.Prod
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*
import kotlin.collections.ArrayList


class CategoriesProd : AppCompatActivity() {


    var data: ArrayList<Prod>? = null
    private lateinit var listProd: ListView
    private lateinit var mfirebaseAnalytics: FirebaseAnalytics
    private  lateinit var tvcategory:TextView

    var beginTime: Long = 0
    var finishTime: Long = 0
    var toTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beginTime = Calendar.getInstance().timeInMillis
        mfirebaseAnalytics = FirebaseAnalytics.getInstance(this)


        trackScreen("CategoryProductsActivity")


        setContentView(R.layout.activity_categories_prod)



        val categoryName = intent.getStringExtra("categoryName")
        tvcategory = findViewById(R.id.tvCatName)
        tvcategory.text = categoryName

        listProd = findViewById(R.id.productsListView)

        data = ArrayList<Prod>()
        if (categoryName.equals("Food")) {
            data!!.add(
                Prod(
                    "Donats",
                    R.drawable.food1,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )

            )



            data!!.add(
                Prod(
                    "Rise",
                    R.drawable.food2,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )



            data!!.add(
                Prod(
                    "Burgar",
                    R.drawable.food3,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )


            data!!.add(
                Prod(
                    "Pizaa",
                    R.drawable.food4,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )




        } else if (categoryName.equals("Clothes")) {
            data!!.add(
                Prod(
                    "Jaket",
                    R.drawable.c2,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )



            data!!.add(
                Prod(
                    "Kids",
                    R.drawable.c3,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )

            data!!.add(
                Prod(
                    "Man",
                    R.drawable.c4,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )

            data!!.add(
                Prod(
                    "Women",
                    R.drawable.c1,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )






        } else if (categoryName.equals("Electronic")) {


            data!!.add(
                Prod(
                    "Laptop hp",
                    R.drawable.lap_hp,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )


            data!!.add(
                Prod(
                    "Iphone X",
                    R.drawable.ipho_x,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )

            data!!.add(
                Prod(
                    "Smart tv",
                    R.drawable.smart_tv,
                    " we sell only healthy, organic food, all of which is grown here at the farm. because we take a pride in the quality of all our products, we do not use any chemicals or pesticides as well as selling a large selection of fruits and vegetables, we also sell a lot of dairy products. our animals are fed on the natural healthy diet.\n"         )
                )

        }

        listProd.adapter=ProdAdapter(this, data!! )

        listProd.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->


                finishTime = Calendar.getInstance().timeInMillis
                toTime = finishTime - beginTime

                val name = data!![position].name
                val discriptions = data!![position].description
                val image = data!![position].img


                val intent = Intent(this, ProdDetails::class.java)
                intent.putExtra("productName", name)
                intent.putExtra("productDiscription", discriptions)
                intent.putExtra("productImage", image)

                contentSelected(name)
                startActivity(intent)
            }


    }

    fun trackScreen(screenName:String){
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenName)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        mfirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW,bundle)
    }


    fun contentSelected(name:String){
        var bundle = Bundle()
        bundle.putString("categoryClick",name)
        mfirebaseAnalytics.logEvent("categoryClick",bundle)
    }

}