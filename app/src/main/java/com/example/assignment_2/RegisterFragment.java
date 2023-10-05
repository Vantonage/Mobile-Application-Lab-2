package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_register, container, false);

        Button sendData = root.findViewById(R.id.addMemberBtn);

        EditText editText = root.findViewById(R.id.teamNameEditText);

        RadioGroup groupSize = root.findViewById(R.id.groupSizeRadioGroup);


        sendData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity().getBaseContext(), memberRegistration.class);
                String teamName = editText.getText().toString();

                int selectedGroup = groupSize.getCheckedRadioButtonId();
                String size = "";
                if (selectedGroup != -1) {
                    RadioButton selectedRadioButton = root.findViewById(selectedGroup);
                    size = selectedRadioButton.getText().toString();
                }

                intent.putExtra("team", teamName);
                intent.putExtra("size", size);

                // Start the activity with the intent
                startActivity(intent);

            }
        });

        return root;

    }
}