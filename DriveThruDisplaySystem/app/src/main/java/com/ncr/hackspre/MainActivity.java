package com.ncr.hackspre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.ncr.hackspre.adapters.PostsAdapter;
import com.ncr.hackspre.endpoints.GetPosts;
import com.ncr.hackspre.model.RetroPosts;
import com.ncr.hackspre.net.RetroClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetPosts posts = RetroClient.getRetrofitInstance().create(GetPosts.class);
        Call<List<RetroPosts>> call = posts.getAllPosts();

        call.enqueue(new Callback<List<RetroPosts>>() {
            @Override
            public void onResponse(final Call<List<RetroPosts>> call,
                                   final Response<List<RetroPosts>> response) {
                generateDataList(response.body());
                for(RetroPosts p: response.body()){
                    Log.d("RESP: ", p.getTitle());
                }

            }

            @Override
            public void onFailure(final Call<List<RetroPosts>> call, final Throwable t) {

            }
        });
    }
    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPosts> photoList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PostsAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}