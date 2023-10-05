package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AcknowledgeActivity extends AppCompatActivity {

    private ProgressBar loadingProgressBar;
    private int currentProgress = 0;
    private Handler handler = new Handler();

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

        loadingProgressBar = findViewById(R.id.progressBar);
    }

    public void addTeam(View view){
        Intent intent = getIntent();
        String teamName = intent.getStringExtra("teamName");

        String team = "Team " + teamName + " has been registered";
        Toast.makeText(this, team,Toast.LENGTH_SHORT).show();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentProgress <= 100){
                    currentProgress += 20;
                    loadingProgressBar.setProgress(currentProgress);
                    handler.postDelayed(this, 1000);
                }
                else{
                    Intent newIntent = new Intent(AcknowledgeActivity.this, MainActivity.class);
                    startActivity(newIntent);
                    finish();
                }

            }
        }, 1000);
    }
}