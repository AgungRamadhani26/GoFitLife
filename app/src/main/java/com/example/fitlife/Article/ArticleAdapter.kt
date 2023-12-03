package com.example.fitlife.Article

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.CardArticleBinding
import com.google.android.material.imageview.ShapeableImageView

class ArticleAdapter (private val articleList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        // val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_article, parent, false)
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardArticleBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleAdapter.ArticleViewHolder, position: Int) {
        val item = articleList[position]
        holder.articleImage.setImageResource(item.thumbnail)
        holder.articleHeadline.text = item.headline
        holder.articleExcerpt.text = item.excerpt
    }

    class ArticleViewHolder(private val binding: CardArticleBinding) : RecyclerView.ViewHolder(binding.root){
        val articleImage: ShapeableImageView = binding.thumbnail
        val articleHeadline: TextView = binding.headline
        val articleExcerpt: TextView = binding.excerpt
    }

    override fun getItemCount(): Int {
        return  articleList.size
    }
}