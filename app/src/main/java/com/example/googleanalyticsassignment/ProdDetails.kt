package com.example.googleanalyticsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.analytics.FirebaseAnalytics


class ProdDetails : AppCompatActivity() {
    var imgProduct: ImageView? = null
    var productDisc: TextView? = null
    var productName: TextView? = null
    private  lateinit var tvprodu:TextView

    private lateinit var mfirebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prod_details)
        mfirebaseAnalytics = FirebaseAnalytics.getInstance(this)


        trackScreen("${ intent.getStringExtra("productName") } Details Activity")

         tvprodu= findViewById(R.id.tvProduName)
        tvprodu.text = intent.getStringExtra("productName")

        imgProduct = findViewById(R.id.DPImage)
        productDisc = findViewById(R.id.tvPDDiscription)
        productName = findViewById(R.id.tvPDName)
        productName!!.text = intent.getStringExtra("productName")
        productDisc!!.text = intent.getStringExtra("productDiscription")

        imgProduct!!.setImageResource(intent.getIntExtra("productImage", 0))
    }





    fun trackScreen(name:String){
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,name)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        mfirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW,bundle)
    }



}