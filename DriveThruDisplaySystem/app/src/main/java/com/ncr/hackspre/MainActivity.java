package com.ncr.hackspre;

import com.ncr.hackspre.adapters.PostsAdapter;
import com.ncr.hackspre.endpoints.GetPosts;
import com.ncr.hackspre.model.RetroPosts;
import com.ncr.hackspre.net.RetroClient;

import java.util.List;

import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide action bar
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        ActionBar b = getSupportActionBar();
        b.hide();



        GetPosts posts = RetroClient.getRetrofitInstance().create(GetPosts.class);
        Call<List<RetroPosts>> call = posts.getAllPosts();

        call.enqueue(new Callback<List<RetroPosts>>() {
            @Override
            public void onResponse(final Call<List<RetroPosts>> call,
                                   final Response<List<RetroPosts>> response) {
                generateDataList(response.body());

            }

            @Override
            public void onFailure(final Call<List<RetroPosts>> call, final Throwable t) {

            }
        });

        // Get the Intent that started this activity and extract the customer
        Intent intent = getIntent();
        Bundle customerData = intent.getExtras();
        Customer customer = (Customer) customerData.getSerializable("data");

        // Capture the layout's TextView and set the customer name and loyalty points as its text
        TextView customerName = findViewById(R.id.userNameGreeting);
        TextView loyaltyPoints = findViewById(R.id.loyaltyPointsText);
        customerName.setText("Hello, " + customer.getName() + "!");
        loyaltyPoints.setText("You have " + customer.getRewards() + " points!");    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPosts> photoList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PostsAdapter(this,photoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
            layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}