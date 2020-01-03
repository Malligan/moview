package com.grdk.moview.newsearch.data

import com.grdk.moview.newsearch.domain.NewSearchResultModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewSearchService {

    @GET(".")
    fun getSearchResult(@Query("t") title: String): Single<Response<NewSearchResultModel>>
}