package com.example.orderflowersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.orderflowersapp.Interface.ItemClickListener;
import com.example.orderflowersapp.Model.Flower;
import com.example.orderflowersapp.ViewHolder.FlowerViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FlowerList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference flowersList;

    String categoryId ="";
    FirebaseRecyclerAdapter<Flower, FlowerViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        flowersList = database.getReference("Flowers");

        recyclerView = findViewById(R.id.recycler_flower);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get Intent
        if(getIntent()!= null){
            categoryId = getIntent().getStringExtra("CategoryId");
        }
        if(!categoryId.isEmpty() && categoryId!=null){
            loadFlowerList(categoryId);
        }

    }

    private void loadFlowerList(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Flower, FlowerViewHolder>(Flower.class,
                R.layout.flower_item,
                FlowerViewHolder.class,
                flowersList.orderByChild("MenuId").equalTo(categoryId))//like Select * From Flowers where MenuId=categoryId
        {
            @Override
            protected void populateViewHolder(FlowerViewHolder flowerViewHolder, Flower flower, int i) {
                flowerViewHolder.flower_name.setText(flower.getName());
                Picasso.with(getBaseContext()).load(flower.getImage())
                        .into(flowerViewHolder.flower_image);

                final Flower local = flower;
                flowerViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void OnClick(View view, int position, boolean isLongClick) {
                       //Open detail of flower item
                        Intent flowerDetail = new Intent(FlowerList.this, FlowerDetail.class);
                        flowerDetail.putExtra("FlowerId",adapter.getRef(position).getKey());
                        startActivity(flowerDetail);
                    }
                });
            }
        };
        //Set adapter
        recyclerView.setAdapter(adapter);

    }
}
