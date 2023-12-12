package com.example.fitlife.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitlife.models.Article
import com.example.fitlife.adapters.ArticleAdapter
import com.example.fitlife.R
import com.example.fitlife.api.ApiInterface
import com.example.fitlife.api.ApiUtilities
import com.example.fitlife.databinding.FragmentGlobeBinding
import com.example.fitlife.repository.NewsRepository
import com.example.fitlife.viewModel.NewsViewModel
import com.example.fitlife.viewModel.NewsViewModelFactory

class GlobeFragment : Fragment() {
    private lateinit var articleArrayList: ArrayList<Article>
    private lateinit var binding: FragmentGlobeBinding
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articleHeadlines: Array<String>
    private lateinit var articleExcerpts: Array<String>
    private lateinit var articleThumbnails: List<Int>
    private lateinit var newsViewModel:NewsViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // inflate
        binding = FragmentGlobeBinding.inflate(inflater, container, false)
        val view = binding.root

        // get Array
        articleHeadlines = resources.getStringArray(R.array.articleHeadline)
        articleExcerpts = resources.getStringArray(R.array.articleExcerpt)
        articleThumbnails = listOf(
            R.drawable.artikel1,
            R.drawable.artikel2,
            R.drawable.artikel3,
        )

        // recycler view
//        articleArrayList = arrayListOf<Article>()
//        binding.rvArticle.setHasFixedSize(true)
//        binding.rvArticle.layoutManager = LinearLayoutManager(context)
            // get article data
//        getArticleData()
            // set article adapter
//        articleAdapter = ArticleAdapter(articleArrayList)
//        binding.rvArticle.adapter = articleAdapter

        // Menambahkan OnTouchListener ke ConstraintLayout
        binding.scrollView.setOnTouchListener { _, event ->
            // Memeriksa apakah sentuhan terjadi di luar EditText dan RecyclerView
            if (event.action == MotionEvent.ACTION_DOWN) {
                val imm =
                    context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (binding.etSearch.isFocused) {
                    val outRectEditText = android.graphics.Rect()
                    binding.etSearch.getGlobalVisibleRect(outRectEditText)
                    if (!outRectEditText.contains(event.rawX.toInt(), event.rawY.toInt())) {
                        // Menutup keyboard karena sentuhan terjadi di luar EditText
                        imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
                        binding.etSearch.clearFocus()
                    }
                }
            }
            return@setOnTouchListener false
        }

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)

        val newsRepository = NewsRepository(apiInterface)

        newsViewModel = ViewModelProvider(this, NewsViewModelFactory(newsRepository)).get(
            NewsViewModel::class.java)

        newsViewModel.news.observe(viewLifecycleOwner, {
            Log.d("asd", "onCreate: ${it}")
        })

        return view
    }

    private fun hideKeyboard(view: View) {
        val imm = context?.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun getArticleData() {
        for (i in articleHeadlines.indices) {
//            val article = Article(articleThumbnails[i], articleHeadlines[i], articleExcerpts[i], "")
//            articleArrayList.add(article)
        }
    }
}