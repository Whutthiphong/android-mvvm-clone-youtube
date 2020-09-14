package com.example.cloneyoutube.data.network.response

data class Data(
    val last_update: String,
    val paginationMeta: PaginationMeta,
    val rows: List<Row>
)