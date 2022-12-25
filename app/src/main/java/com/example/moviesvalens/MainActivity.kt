package com.example.moviesvalens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesvalens.R.layout.activity_main
import com.example.moviesvalens.models.movies
import com.example.moviesvalens.models.responses
import com.example.moviesvalens.services.apimovie
import com.example.moviesvalens.services.apiservices
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        btnIntent = findViewById(R.id.info)

        btnIntent.setOnClickListener(this)
// baris ke 21-28 prroses perpindahan ke activity selanjutnya dengan menggunakan fungsi intent //
        rv_movies_list.layoutManager = LinearLayoutManager(this) // layout manager samadengan linear layout manager //
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies: List<movies> ->  // function get datas meminta data movie //
            rv_movies_list.adapter = adapter(movies)
        // menampilkan data list yang di dapat dari file movies.kt   //
        }
    }
// baris ke 30-33 menggunakan recylerview//
    private fun getMovieData(callback: (List<movies>) -> Unit) { // function get movie data mengambil data movie dari file movie.kt yang sudah terhubung oleh API //
        val apiService = apiservices.getInstance().create(apimovie::class.java) // variable api service fget instance //
        apiService.getMovieList().enqueue(object : Callback<responses> { // api service meminta movie list yang memakai enqueue untuk penambahan di posisi Rear. jika sudah mempunyai elemen, maka nilai Rear harus bertambah 1, lalu call back //
            override fun onFailure(call: Call<responses>, t: Throwable) {
            //  //
            }

            override fun onResponse(call: Call<responses>, response: Response<responses>) {
                return callback(response.body()!!.movies) //funtion on response meng call file responses , lalu return callback file movies.kt //
            }

        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.info -> kotlin.run { //  //
                val  intentBiasa = Intent(this@MainActivity, moreinfo::class.java) // menginisialisasikan variable intent biasa samadengan intent  //
                startActivity(intentBiasa)
            }
        }
    }
}
// view model//