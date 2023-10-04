package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class memberRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_registration);

        Intent intent = getIntent();
        String receivedMessage = intent.getStringExtra("edit_text");
        String m = intent.getStringExtra("g");
        String name = intent.getStringExtra("message");
        // Display the received data in a TextView or perform any other actions
        TextView textView = findViewById(R.id.textView);
        //textView.setText(receivedMessage);
        m = m.substring(m.length()-1);
        textView.setText(m + receivedMessage);

        LinearLayout layout = findViewById(R.id.bob);

        int size = Integer.parseInt(m);
        for (int i = 0; i < size; i++){
            EditText editText = new EditText(this);
            editText.setId(i);
            editText.setHint("Member " + (i + 1));
            layout.addView(editText);
        }


        // Register button

        Button register = findViewById(R.id.registerBtn);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                List<String> content = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    EditText editText = findViewById(i);
                    String cont = editText.getText().toString();
                    content.add(cont);
                }

                Intent newIntent = new Intent(memberRegistration.this, AcknowledgeActivity.class);
                ArrayList<String> arrayListContent = new ArrayList<>(content);


                newIntent.putExtra("edit", arrayListContent);
                startActivity(newIntent);
            }
        });

    }
}