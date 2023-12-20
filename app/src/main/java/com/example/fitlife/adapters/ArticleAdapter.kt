package com.example.fitlife.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.databinding.CardArticleBinding
import com.example.fitlife.models.News
import com.squareup.picasso.Picasso

class ArticleAdapter (private val newsList: ArrayList<News>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(val binding: CardArticleBinding): RecyclerView. ViewHolder(binding.root)

    private lateinit var onItemClick: OnItemClick

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    interface OnItemClick {
        fun onItemClicked(data: News)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        // val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_article, parent, false)
        val binding = CardArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        with(holder) {
            with(newsList[position]) {
                Picasso.get().load(this.image.small).fit().centerCrop().into(holder.binding.thumbnail)
                binding.headline.text = cutTitle(this.title)
                binding.excerpt.text = this.contentSnippet
            }
        }
        holder.itemView.setOnClickListener{
            onItemClick.onItemClicked(newsList[holder.adapterPosition])
        }
    }

    private fun cutTitle(title: String): String {
        return when {
            title.length > 70 -> title.substring(0..60) + "..."
            else -> title
        }
    }
}