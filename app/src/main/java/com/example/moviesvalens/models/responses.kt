package com.example.moviesvalens.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class responses(
    @SerializedName("results")
    val movies : List<movies>
    // mendefinisikan variable movies yang berisi list yang akan diimpor dari movies.kt//

) : Parcelable {
    constructor() : this(mutableListOf()) // constructor bernilai this mutablelistof   //
}