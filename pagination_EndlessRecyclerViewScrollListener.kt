package com.example.githubrepo.pagination

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewScrollListener(private val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        if (dy <= 0) return

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
            val page = totalItemCount / visibleItemCount + 1
            onLoadMore(page, totalItemCount)
        }
    }

    abstract fun onLoadMore(page: Int, totalItemsCount: Int)
}
