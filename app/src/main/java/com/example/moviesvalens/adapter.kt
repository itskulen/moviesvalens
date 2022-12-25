package com.example.moviesvalens

import android.text.Html.ImageGetter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesvalens.models.movies
import kotlinx.android.synthetic.main.movie_item.view.*

class adapter(
    private val movies: List<movies> // val movies samadengan list yang diambil dari file movies.kt //
) : RecyclerView.Adapter<adapter.MovieViewHolder>() {


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/" //mendeklarasikan variable image base yang berisi link menuju laman themovie database //
        fun bindMovie(movies: movies) {
            itemView.movie_title.text = movies.title
            itemView.movie_release_date.text = movies.release
            Glide.with(itemView).load(IMAGE_BASE + movies.poster).into(itemView.movie_poster) //glide digunakan untuk mendapatkan sumber dari themoviedatabase yang berupa  text dan gambar//
        }
    }
// bind movie digunakan untuk mendapatkan item movie berupa text movie.title dan movie realese dimana bertipe text yang nantinya akan menampilkan judul film serta tanggal rilis//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false) // layout inflater yang berfungsi untuk mengambil file xml, mendefinisikan tata letak menjadi objek view  //
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
// memposisikan data yang diambil dari file movie.kt //
    override fun getItemCount(): Int = movies.size  // get item count berisi mivie size bert //
}