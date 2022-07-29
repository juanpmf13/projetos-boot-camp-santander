package me.dio.simulator.data

import me.dio.simulator.domain.Match
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface MatchesApi2 {

    @GET("matches.json")
    fun getMatches() : Call<List<Match>>

}