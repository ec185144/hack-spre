package com.ncr.hackspre.endpoints;

import com.ncr.hackspre.model.RetroPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetOrderDetails {

    //TODO: Fetch order details
    @GET("/")
    Call<List<RetroPosts>> getAllPosts();
}
