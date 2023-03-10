package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderapp.adapters.MainAdapter;
import com.example.foodorderapp.databinding.ActivityMainBinding;
import com.example.foodorderapp.models.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger , "Burger" , "5" , "Chicken Burger with extra cheese"));
        list.add(new MainModel(R.drawable.pizza , "Pizza" , "0" , "Chicken Pizza with extra cheese and apply coupon code if you have"));
        list.add(new MainModel(R.drawable.por , "Por" , "4" , "Chicken Por with extra cheese"));
        list.add(new MainModel(R.drawable.boc , "Boc" , "52" , "Chicken Boc with extra cheese"));
        list.add(new MainModel(R.drawable.burger , "Burger" , "20" , "Chicken Burger with extra cheese"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}