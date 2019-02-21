package com.devrangokalp.candost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelenIntent=intent

        if (gelenIntent!=null){

            tvDetayAdi.text=gelenIntent.getStringExtra("adi:")
            imgDetayResim.setImageResource(gelenIntent.getIntExtra("resim:",R.drawable.ani_cat_five))
        }
    }
}
