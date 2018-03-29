package com.example.cvolk.celebrityratings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cvolk.celebrityratings.data.LocalDataSource;
import com.example.cvolk.celebrityratings.model.Celebrity;

public class ModifyActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etGender;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        bindViews();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (getIntent().getStringExtra("firstName") != "") {
            etFirstName.setText(getIntent().getStringExtra("firstName"));
            etFirstName.setText(getIntent().getStringExtra("lastName"));
            etFirstName.setText(getIntent().getStringExtra("gender"));
            etFirstName.setText(getIntent().getStringExtra("age"));
        }
    }

    private void bindViews() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etGender = findViewById(R.id.etGender);
        etAge = findViewById(R.id.etAge);
    }

    public void addCelebrity(View view) {
        LocalDataSource dataSource = new LocalDataSource(this);

        switch (view.getId()) {
            case R.id.btnAddCelebrity:
                Celebrity celebrity = new Celebrity(
                        etFirstName.getText().toString(),
                        etLastName.getText().toString(),
                        etGender.getText().toString(),
                        Integer.parseInt(etAge.getText().toString()),
                        false
                );

                dataSource.saveCelebrity(celebrity);

                Toast.makeText(this, celebrity.getFirstName() + " " + celebrity.getLastName() + " Added", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
        }
    }

    public void deleteCelebrity(View view) {
        LocalDataSource dataSource = new LocalDataSource(this);

        switch (view.getId()) {
            case R.id.btnDeleteCelebrity:
                Celebrity celebrity = new Celebrity(
                        etFirstName.getText().toString(),
                        etLastName.getText().toString(),
                        etGender.getText().toString(),
                        Integer.parseInt(etAge.getText().toString()),
                        false
                );

                int result = dataSource.deleteCelebrity(celebrity);

                if (result == 1) {
                    Toast.makeText(getApplicationContext(), "Deleted " + celebrity.toString(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
