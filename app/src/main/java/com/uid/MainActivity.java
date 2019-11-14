package com.uid;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recylerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHandler myDBHandler = new MyDBHandler(this);


        AsyncFetch asyncFetch = new AsyncFetch(this);
        asyncFetch.execute();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerViewAdapter = new RecyclerViewAdapter(myDBHandler.getAllUsers());
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}