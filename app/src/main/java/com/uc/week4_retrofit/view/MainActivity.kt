package com.uc.week4_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.week4_retrofit.adapter.NowPlayingAdapter
import com.uc.week4_retrofit.databinding.ActivityMainBinding
import com.uc.week4_retrofit.helper.Const
import com.uc.week4_retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var adapter: NowPlayingAdapter
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel.getNowPlaying(Const.API_KEY, "en-US", 1)

        viewModel.nowplaying.observe(this, Observer{ response ->
            bind.rvMain.layoutManager = LinearLayoutManager(this)
            adapter = NowPlayingAdapter(response)
            bind.rvMain.adapter = adapter
        })
    }
}