package com.example.fitlife.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitlife.Article.Article
import com.example.fitlife.Article.ArticleAdapter
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentDrinkBinding
import com.example.fitlife.databinding.FragmentGlobeBinding

class GlobeFragment : Fragment() {
    private lateinit var articleArrayList: ArrayList<Article>
    private lateinit var binding: FragmentGlobeBinding
    private lateinit var articleAdapter: ArticleAdapter
    private var articleHeadlines: Array<String> = resources.getStringArray(R.array.articleHeadline)
    private var articleExcerpts: Array<String> = resources.getStringArray(R.array.articleExcerpt)
    private var articleThumbnails: IntArray = resources.getIntArray(R.array.articleThumbnail)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentGlobeBinding.inflate(inflater, container, false)
        val view = binding.root

        // recycler view
        articleArrayList = arrayListOf<Article>()
        binding.rvArticle.setHasFixedSize(true)
        binding.rvArticle.layoutManager = LinearLayoutManager(context)
            // get article data
        getArticleData()
            // set article adapter
        articleAdapter = ArticleAdapter(articleArrayList)
        binding.rvArticle.adapter = articleAdapter

        return view
    }

    private fun getArticleData() {
        for (i in articleHeadlines.indices) {
            val article = Article(articleThumbnails[i], articleHeadlines[i], articleExcerpts[i], "")
            articleArrayList.add(article)
        }
    }
}