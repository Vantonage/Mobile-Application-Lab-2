package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AcknowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledge);

        Intent intent = getIntent();
        String teamName = intent.getStringExtra("teamName");
        ArrayList<String> editTextContents = intent.getStringArrayListExtra("members");

        TextView textViewTeam = findViewById(R.id.team);
        TextView textViewContents = findViewById(R.id.members);

        String combinedContents = TextUtils.join("\n\n", editTextContents);

        textViewTeam.setText(teamName);
        textViewContents.setText(combinedContents);
    }

    public void addTeam(View view){
        Intent intent = getIntent();
        String teamName = intent.getStringExtra("teamName");

        String team = "Team " + teamName + " has been registered";
        Toast.makeText(this, team,Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent newIntent = new Intent(AcknowledgeActivity.this, MainActivity.class);
                startActivity(newIntent);
                finish();
            }
        }, 5000);
    }
}