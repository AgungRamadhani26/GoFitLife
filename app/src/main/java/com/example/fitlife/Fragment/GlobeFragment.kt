package com.example.fitlife.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitlife.models.Article
import com.example.fitlife.adapters.ArticleAdapter
import com.example.fitlife.R
import com.example.fitlife.databinding.FragmentGlobeBinding

class GlobeFragment : Fragment() {
    private lateinit var articleArrayList: ArrayList<Article>
    private lateinit var binding: FragmentGlobeBinding
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articleHeadlines: Array<String>
    private lateinit var articleExcerpts: Array<String>
    private lateinit var articleThumbnails: IntArray
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentGlobeBinding.inflate(inflater, container, false)
        val view = binding.root

        // get Array
        articleHeadlines = resources.getStringArray(R.array.articleHeadline)
        articleExcerpts = resources.getStringArray(R.array.articleExcerpt)
        articleThumbnails = resources.getIntArray(R.array.articleThumbnail)
        Log.d("article", "onCreateView: $articleThumbnails")

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