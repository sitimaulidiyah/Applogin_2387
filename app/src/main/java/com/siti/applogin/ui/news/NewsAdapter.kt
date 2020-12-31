package com.siti.applogin.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.siti.applogin.ui.base.BassAdapter
import com.siti.applogin.R
import com.siti.applogin.data.model.News
import com.siti.applogin.databinding.ItemNewsBinding

class NewsAdapter(val context: Context) : BassAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.gambar).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}