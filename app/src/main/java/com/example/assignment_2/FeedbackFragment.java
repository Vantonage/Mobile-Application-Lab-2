package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_feedback, container, false);

        Button sendFeedback = root.findViewById(R.id.feedbackButton);

        sendFeedback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String feedback = "Feedback sent";
                Toast.makeText(getContext(), feedback, Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}