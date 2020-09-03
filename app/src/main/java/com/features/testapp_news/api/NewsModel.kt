package com.features.testapp_news.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "title",
    "type",
    "click_url",
    "time",
    "img",
    "top")
class NewsModel(
    @JsonProperty("title") val title: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("img") val img: String?,
    @JsonProperty("click_url") val click_url: String,
    @JsonProperty("time") val time: String,
    @JsonProperty("top") val top: Int
)


//{"title":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
//    "type":"video",
//    "click_url":"https://lampalampa.net",
//    "time":"2 hour ago",
//    "top":"1"}]