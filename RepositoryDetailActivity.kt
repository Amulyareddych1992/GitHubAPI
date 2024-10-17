package com.example.githubrepo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubrepo.databinding.ActivityRepositoryDetailBinding
import com.example.githubrepo.model.Repository

class RepositoryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryDetailBinding

    companion object {
        private const val EXTRA_REPOSITORY = "repository"

        fun newIntent(context: Context, repository: Repository): Intent {
            val intent = Intent(context, RepositoryDetailActivity::class.java)
            intent.putExtra(EXTRA_REPOSITORY, repository)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository: Repository = intent.getParcelableExtra(EXTRA_REPOSITORY)!!

        binding.repoName.text = repository.name
        binding.repoDescription.text = repository.description
        binding.repoLanguage.text = repository.language ?: "N/A"
        binding.repoStars.text = "Stars: ${repository.stars}"
        binding.repoForks.text = "Forks: ${repository.forks}"
    }
}
