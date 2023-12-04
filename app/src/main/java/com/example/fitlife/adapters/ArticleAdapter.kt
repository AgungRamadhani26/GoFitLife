package com.example.fitlife.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.CardArticleBinding
import com.example.fitlife.models.Article

class ArticleAdapter (private val articleList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(val binding: CardArticleBinding): RecyclerView. ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        // val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_article, parent, false)
        val binding = CardArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        with(holder) {
            with(articleList[position]) {
                binding.thumbnail.setImageResource(this.thumbnail)
                binding.headline.text = this.headline
                binding.excerpt.text = this.excerpt
            }
        }
    }
}