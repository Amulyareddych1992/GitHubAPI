package com.example.githubrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.databinding.ItemRepositoryBinding
import com.example.githubrepo.model.Repository

class RepositoryAdapter(private val onClick: (Repository) -> Unit) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    private val repositories = mutableListOf<Repository>()

    fun addRepositories(newRepositories: List<Repository>) {
        repositories.addAll(newRepositories)
        notifyDataSetChanged()
    }

    fun clearData() {
        repositories.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = repositories[position]
        holder.bind(repository)
    }

    override fun getItemCount(): Int = repositories.size

    inner class RepositoryViewHolder(private val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            binding.repoName.text = repository.name
            binding.repoDescription.text = repository.description
            binding.repoLanguage.text = repository.language ?: "N/A"
            binding.repoStars.text = "Stars: ${repository.stars}"
            binding.repoForks.text = "Forks: ${repository.forks}"

            itemView.setOnClickListener { onClick(repository) }
        }
    }
}
