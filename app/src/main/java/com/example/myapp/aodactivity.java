package com.example.myapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class aodactivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aodactivity);
        mRecyclerView = findViewById(R.id.aodspinner);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("uploads").orderByChild("course").equalTo("AOD"),model.class)
                        .build();
        adapter = new Myadapter(options,this);
        onStart();
        mRecyclerView.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search) ;
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                query = query.toLowerCase();
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText=newText.toLowerCase();
                search(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void search(String str){
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("uploads").orderByChild("name").startAt(str).endAt(str+"\uf8ff"),model.class)
                        .build();
        adapter = new Myadapter(options,this);
        onStart();
        mRecyclerView.setAdapter(adapter);

    }





}

