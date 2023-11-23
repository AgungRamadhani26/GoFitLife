package com.example.fitlife.Article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ArticleAdapter (private val articleList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_article, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleAdapter.ArticleViewHolder, position: Int) {
        val item =articleList[position]
    }

    class ArticleViewHolder(itemView: View) {
        val articleImage: ShapeableImageView = itemView.findViewById(R.id.thumbnail)
    }

    override fun getItemCount(): Int {
        return  articleList.size
    }
}