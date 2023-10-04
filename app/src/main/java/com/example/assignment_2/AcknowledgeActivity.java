package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class AcknowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledge);

        Intent intent = getIntent();
        ArrayList<String> editTextContents = intent.getStringArrayListExtra("edit");

        TextView textViewContents = findViewById(R.id.lol);

        String combinedContents = TextUtils.join("\n", editTextContents);

        textViewContents.setText(combinedContents);



    }
}