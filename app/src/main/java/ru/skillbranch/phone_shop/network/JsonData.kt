package ru.skillbranch.phone_shop.network

import com.google.gson.annotations.SerializedName

data class JsonData(
    @SerializedName("best_seller")
    val bestSeller: List<BestSeller>,
    val home_store: List<HomeStore>
)