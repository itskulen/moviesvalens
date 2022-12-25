package com.example.moviesvalens.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiservices {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/" // base url disertai link digunakan untuk mengambil sumber dari themoviedb //
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit{   // penggunaan retrofit yang digunakan untuk pertukaran data antara aplikasi android dengan server melalui REST API //
           if (retrofit == null){
               retrofit = Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
           }// membuat class khusus untuk terbuang ke alamat retrofit pada web service//
            return retrofit!! // perintah return retofrit mengembalikan retrofit //
        }
    }
}