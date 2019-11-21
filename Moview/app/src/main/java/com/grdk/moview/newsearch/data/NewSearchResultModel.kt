package com.grdk.moview.newsearch.data

import com.google.gson.annotations.SerializedName
import com.grdk.moview.newsearch.domain.NewSearchModel

data class NewSearchResultModel(
    @SerializedName("Title")
    override val title: String? = null,
    @SerializedName("Year")
    override val year: String? = null,
    @SerializedName("Rated")
    override val rated: String? = null,
    @SerializedName("Released")
    override val released: String? = null,
    @SerializedName("Runtime")
    override val runtime: String? = null,
    @SerializedName("Genre")
    override val genre: String? = null,
    @SerializedName("Director")
    override val director: String? = null,
    @SerializedName("Writer")
    override val writer: String? = null
) : NewSearchModel