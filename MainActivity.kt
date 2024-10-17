package com.example.githubrepo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubrepo.api.GitHubApiService
import com.example.githubrepo.databinding.ActivityMainBinding
import com.example.githubrepo.model.Repository
import com.example.githubrepo.pagination.EndlessRecyclerViewScrollListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RepositoryAdapter
    private lateinit var apiService: GitHubApiService
    private var currentPage = 1
    private var languageFilter: String? = null
    private var username = "google" // Default user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupApiService()

        fetchRepositories(currentPage)

        // Handle filtering
        binding.filterButton.setOnClickListener {
            languageFilter = binding.languageFilter.text.toString()
            adapter.clearData()
            currentPage = 1
            fetchRepositories(currentPage)
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RepositoryAdapter { repository -> openRepositoryDetail(repository) }
        binding.recyclerView.adapter = adapter

        // Implement pagination
        binding.recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                fetchRepositories(page)
            }
        })
    }

    private fun setupApiService() {
        apiService = GitHubApiService.create()
    }

    private fun fetchRepositories(page: Int) {
        apiService.getUserRepositories(username, page).enqueue(object : Callback<List<Repository>> {
            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                if (response.isSuccessful && response.body() != null) {
                    val filteredRepos = if (languageFilter.isNullOrEmpty()) {
                        response.body()!!
                    } else {
                        response.body()!!.filter { it.language.equals(languageFilter, ignoreCase = true) }
                    }
                    adapter.addRepositories(filteredRepos)
                } else {
                    showError("Error fetching repositories")
                }
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                showError("Network error")
            }
        })
    }

    private fun openRepositoryDetail(repository: Repository) {
        val intent = RepositoryDetailActivity.newIntent(this, repository)
        startActivity(intent)
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
