package com.example.moviesvalens.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize // menggunakan plugin parcelize agar semua properti yang diserialisasi dideklarasikan dalam konstruktor utama. Plugin mengeluarkan peringatan di setiap properti dengan kolom pendukung yang dideklarasikan dalam isi class. //
data class movies(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("release_date")
    val release : String?

) : Parcelable{ // parcelable digunakan untuk mengirim objek berasamaan dengan intent//
    constructor() : this("", "", "", "")  // constructor bernilai this yang menampilkan value dari id, title, poster serta realese bertipe string  //
}
// baris 10-20 menginisialisasikan beberapa variable diantaranya id, title, poster, dan realese bertipe string  //

// Model //