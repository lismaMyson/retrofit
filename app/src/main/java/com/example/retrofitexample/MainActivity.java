package com.example.retrofitexample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.Adapter.RetrofitAdapter;
import com.example.retrofitexample.Model.RetrofitListModel;
import com.example.retrofitexample.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvRetrofitList;
    RetrofitAdapter rvRetrofitListAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        rvRetrofitList=findViewById(R.id.rvRetrofitList);
        List<RetrofitListModel> retrofitListModelList = new ArrayList<>();
        rvRetrofitListAdapter = new RetrofitAdapter(context, retrofitListModelList);
        rvRetrofitList.setLayoutManager(new LinearLayoutManager(context));
        rvRetrofitList.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        rvRetrofitList.setAdapter(rvRetrofitListAdapter);
        getSuperHero();
    }

    private void getSuperHero() {
        Call<List<RetrofitListModel>> call = RetrofitClient.getInstance().getMyApi().getSuperHero();
        call.enqueue(new Callback<List<RetrofitListModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitListModel>> call, @NonNull Response<List<RetrofitListModel>> response) {
                rvRetrofitListAdapter.UpdateRetrofitList(response.body());
                Log.e("onResponse: ", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitListModel>> call, @NonNull Throwable t) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                t.printStackTrace();

            }
        });
    }
}