package com.example.googleanalyticsassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.example.googleanalyticsassignment.Adapter.CategAdapter
import com.example.googleanalyticsassignment.Modle.Categories
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics
    private lateinit var listCategory: ListView

    var beginTime: Long = 0
    var finishTime: Long = 0
    var toTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beginTime = Calendar.getInstance().timeInMillis
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)




        trackScreen("categoryActivity")


        listCategory = findViewById(R.id.list_category_item)
        var category = ArrayList<Categories>()

        category.add(Categories("Food", R.drawable.food5))
        category.add(Categories("Clothes", R.drawable.c1))
        category.add(Categories("Electronic", R.drawable.mack))


        listCategory.adapter = CategAdapter(this, category)

        listCategory.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->

                finishTime = Calendar.getInstance().timeInMillis
                toTime = finishTime - beginTime


                val catName: String = category[position].name
                val intent = Intent(this, CategoriesProd::class.java)
                intent.putExtra("categoryName", catName)


                contentSelected(catName)
                startActivity(intent)
            }
    }

    fun trackScreen(screenName:String){
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenName)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW,bundle)
    }


    fun contentSelected(name:String){
        var bundle = Bundle()
        bundle.putString("categoryClick",name)
        mFirebaseAnalytics.logEvent("categoryClick",bundle)
    }


}
