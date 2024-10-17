package com.example.githubrepo.model

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String,
    val description: String?,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("forks_count") val forks: Int,
    val language: String?
)
