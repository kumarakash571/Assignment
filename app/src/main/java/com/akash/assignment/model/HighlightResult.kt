package com.akash.assignment.model


import com.google.gson.annotations.SerializedName

data class HighlightResult(
    @SerializedName("author")
    val author: Author?,
    @SerializedName("story_text")
    val storyText: StoryText?,
    @SerializedName("title")
    val title: Title?,
    @SerializedName("url")
    val url: Url?
)