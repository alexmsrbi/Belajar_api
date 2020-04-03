package com.example.myapplication.service;

import com.example.myapplication.model.movie.MovieDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepository {
    @GET("3/discover/movie?api_key=ec66050f737d8264609d129ef24b53e32")
    Call<MovieDiscoverResponse> getMovieDiscover();
}
