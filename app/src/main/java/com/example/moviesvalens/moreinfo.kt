package com.example.moviesvalens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_moreinfo.*

class moreinfo : AppCompatActivity() {
    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moreinfo)  // menggunakan recyclerview sebagai layout  //
        btg_theme.addOnButtonCheckedListener { _, selectedBtnId, isChecked ->
            if (isChecked) {
                val theme = when (selectedBtnId) { // inisialisasi val theme samadengan selected btn id //
                    R.id.btnDefault -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM //  btn default akan merubah tampilan tema sesuai default sistem hp atau emulator  //
                    R.id.btnDark -> AppCompatDelegate.MODE_NIGHT_YES // btn dark akan merubah tampilan menjadi mode gelap   //
                    else -> AppCompatDelegate.MODE_NIGHT_NO
                }
                Log.d(TAG, "isChecked:$isChecked theme:$theme")
                //                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -- default
                //                AppCompatDelegate.MODE_NIGHT_YES -dark
                //                AppCompatDelegate.MODE_NIGHT_NO - light
                AppCompatDelegate.setDefaultNightMode(theme)
            }
        }
    }
}