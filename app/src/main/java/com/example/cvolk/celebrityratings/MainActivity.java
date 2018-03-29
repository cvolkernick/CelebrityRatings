package com.example.cvolk.celebrityratings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cvolk.celebrityratings.data.LocalDataSource;
import com.example.cvolk.celebrityratings.model.Celebrity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvCelebrities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCelebrities = findViewById(R.id.lvCelebrities);

        LocalDataSource dataSource = new LocalDataSource(this);
        List<Celebrity> celebrityList = dataSource.getAllCelebrity();

        CelebrityAdapter adapter = new CelebrityAdapter(this, celebrityList);

        lvCelebrities.setAdapter(adapter);
    }

    public void addCelebrity(View view) {
        Intent intent = new Intent(getApplicationContext(), ModifyActivity.class);
        startActivity(intent);
    }
}
