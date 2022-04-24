package com.akash.assignment.model


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("matchLevel")
    val matchLevel: String?,
    @SerializedName("matchedWords")
    val matchedWords: List<Any>?,
    @SerializedName("value")
    val value: String?
)