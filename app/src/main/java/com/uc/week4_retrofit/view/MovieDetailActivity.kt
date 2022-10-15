package com.uc.week4_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.uc.week4_retrofit.adapter.CompanyAdapter
import com.uc.week4_retrofit.adapter.GenreAdapter
import com.uc.week4_retrofit.adapter.LanguageAdapter
import com.uc.week4_retrofit.databinding.ActivityMovieDetailBinding
import com.uc.week4_retrofit.helper.Const
import com.uc.week4_retrofit.model.Genre
import com.uc.week4_retrofit.model.ProductionCompany
import com.uc.week4_retrofit.model.SpokenLanguage
import com.uc.week4_retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMovieDetailBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var GenreModel: GenreAdapter
    private lateinit var CompanyModel: CompanyAdapter
    private lateinit var SpokeModel: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val movieId = intent.getIntExtra("movie.id", 0)
        Toast.makeText(applicationContext, "MOVIE ID: ${movieId}", Toast.LENGTH_SHORT).show()


        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetails(Const.API_KEY, movieId)
        viewModel.movieDetails.observe(this, { response ->
            bind.tvTitleMovieDetail.apply {
                text = response.title
            }
            if (response != null){
                bind.progressBar.visibility = View.INVISIBLE
            }


            bind.RVGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            GenreModel = GenreAdapter(response.genres as List<Genre>)
            bind.RVGenre.adapter = GenreModel

            bind.RVCompany.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            CompanyModel = CompanyAdapter(response.production_companies as List<ProductionCompany>)
            bind.RVCompany.adapter = CompanyModel

            bind.RVLanguage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            SpokeModel = LanguageAdapter(response.spoken_languages as List<SpokenLanguage>)
            bind.RVLanguage.adapter = SpokeModel

            bind.overview.apply {
                text = response.overview
            }
            Glide.with(applicationContext).load(Const.IMG_URL+response.backdrop_path).into(bind.imgPosterMovieDetail)

        })




    }
}