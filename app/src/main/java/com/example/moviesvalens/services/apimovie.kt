package com.example.moviesvalens.services

import com.example.moviesvalens.models.responses
import retrofit2.Call
import retrofit2.http.GET

interface apimovie {

    @GET("/3/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): Call<responses>
}
//  pada baris 9 merupakan method @GET dimana method ini mendapatkan data dari themoviedb, untuk mendapatkan data ini harus menuju ke laman themovie db lalu mengenerate api key agar bisa mengkases data film yang ada pada laman tersebut  //
// disini saya menggunakan retrofit yang berfungsi untuk mendapatkan data dari api berupa JSON, sehingga tidak perlu melooping data JSONnya. //