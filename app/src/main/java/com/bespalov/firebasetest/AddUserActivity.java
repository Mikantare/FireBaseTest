package com.bespalov.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bespalov.firebasetest.pojo.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUserActivity extends AppCompatActivity {

    private DatabaseReference database;
    private EditText editTextAddName, editTextAddLastName, editTextAddAge, editTextAddMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        editTextAddName = findViewById(R.id.editTextAddName);
        editTextAddLastName = findViewById(R.id.editTextAddLastName);
        editTextAddAge = findViewById(R.id.editTextAddAge);
        editTextAddMan = findViewById(R.id.editTextAddMan);
        database = FirebaseDatabase.getInstance().getReference();


    }

    public void saveNewUser(View view) {
        if (editTextAddName != null && editTextAddLastName != null && editTextAddAge != null && editTextAddMan != null) {
            String name = editTextAddName.getText().toString().trim();
            String lastName = editTextAddLastName.getText().toString().trim();
            String age = editTextAddAge.getText().toString().trim();
            String man = editTextAddMan.getText().toString().trim();
            User newUser = new User(name,lastName,age, man);
            database.child("users").setValue(newUser);

        } else {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }

    }
}
