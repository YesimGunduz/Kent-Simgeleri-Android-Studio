package com.yesimgunduz.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Binder;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.yesimgunduz.landmarkbook.databinding.ActivityDetailsBinding;
import com.yesimgunduz.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark>LandMarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        LandMarkArrayList=new ArrayList<>();
        LandMark pisa=new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark bridge=new LandMark("Bridge","London",R.drawable.bridge);
        LandMark eyfel=new LandMark("Eyfel","Fransa",R.drawable.eyfel);
        LandMark colosseum=new LandMark("Colosseum","Italy",R.drawable.colosseum);

        LandMarkArrayList.add(pisa);
        LandMarkArrayList.add(bridge);
        LandMarkArrayList.add(eyfel);
        LandMarkArrayList.add(colosseum);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                LandMarkArrayList.stream().map(LandMark->LandMark.name).collect(Collectors.toList()));

        binding.listview.setAdapter(arrayAdapter);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
              intent.putExtra("landmark",LandMarkArrayList.get(i));
                startActivity(intent);
            }
        });


    }
}