package com.example.cloneyoutube.data.network.response

data class Row(
    val active_cases: String,
    val cases_per_mill_pop: String,
    val country: String,
    val country_abbreviation: String,
    val flag: String,
    val new_cases: String,
    val new_deaths: String,
    val serious_critical: String,
    val total_cases: String,
    val total_deaths: String,
    val total_recovered: String
)