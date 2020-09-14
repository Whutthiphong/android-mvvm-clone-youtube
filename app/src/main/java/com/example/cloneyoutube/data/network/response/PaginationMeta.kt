package com.example.cloneyoutube.data.network.response

data class PaginationMeta(
    val currentPage: Int,
    val currentPageSize: Int,
    val totalPages: Int,
    val totalRecords: Int
)