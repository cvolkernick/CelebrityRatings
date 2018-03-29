package com.example.cvolk.celebrityratings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cvolk.celebrityratings.data.LocalDataSource;
import com.example.cvolk.celebrityratings.model.Celebrity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvCelebrities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvCelebrities = findViewById(R.id.lvCelebrities);

        LocalDataSource dataSource = new LocalDataSource(this);
        ArrayList<Celebrity> celebrityList = (ArrayList)dataSource.getAllCelebrity();

        CelebrityAdapter adapter = new CelebrityAdapter(this, celebrityList);

        lvCelebrities.setAdapter(adapter);

        lvCelebrities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditText etFirstName = findViewById(R.id.etFirstName);
                EditText etLastName = findViewById(R.id.etLastName);
                EditText etGender = findViewById(R.id.etGender);
                EditText etAge = findViewById(R.id.etAge);

                Intent intent = new Intent(getApplicationContext(), ModifyActivity.class);
                intent.putExtra("firstName", etFirstName.getText().toString());
                intent.putExtra("lastName", etLastName.getText().toString());
                intent.putExtra("gender", etGender.getText().toString());
                intent.putExtra("age", etAge.getText().toString());

                Toast.makeText(getApplicationContext(), lvCelebrities.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });
    }

    public void addCelebrity(View view) {
        Intent intent = new Intent(getApplicationContext(), ModifyActivity.class);
        startActivity(intent);
    }


}
