package com.example.urbandictionaryandroid

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
        "x-rapidapi-key: ${NetworkingService.rapidAPIKey}"
    )
    //@escaping                         ->
    @GET("define")//path
    suspend fun defineTerm(
        @Query("term")
        term: String
    ): DefineTermResponse
}