package com.example.ex_091;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.os.Bundle;
import androidx.core.view.ViewCompat;
import android.widget.Button;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Spinner;
import android .widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerstate;
    EditText firstname,lastname,phone,email,description;
    String first,last,ph,emailid,state,type,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Spinner spinnerState = findViewById(R.id.spinnerState);
            ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.state_list,
                    android.R.layout.simple_spinner_item
            );
            stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerState.setAdapter(stateAdapter);

            Spinner spinnerComplaint = findViewById(R.id.spinnerType);
            ArrayAdapter<CharSequence> complaintAdapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.Complaint_type_list,
                    android.R.layout.simple_spinner_item
            );
            complaintAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerComplaint.setAdapter(complaintAdapter);

            firstname=findViewById(R.id.FirstName);
            lastname=findViewById(R.id.etLastName);
            phone=findViewById(R.id.etPhone);
            email=findViewById(R.id.etEmail);
            description=findViewById(R.id.etDescription);
            Button btnSubmit=findViewById(R.id.btnSubmit);
            btnSubmit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    first=firstname.getText().toString();
                    last=lastname.getText().toString();
                    ph=phone.getText().toString();
                    emailid=email.getText().toString();
                    state=spinnerState.getSelectedItem().toString();
                    type=spinnerComplaint.getSelectedItem().toString();
                    desc=description.getText().toString();
                    Intent intend=new Intent(MainActivity.this,MainActivity2.class);
                    Bundle bun=new Bundle();
                    bun.putString("first",first);
                    bun.putString("last",last);
                    bun.putString("phone",ph);
                    bun.putString("email",emailid);
                    bun.putString("state",state);
                    bun.putString("type",type);
                    bun.putString("description",desc);
                    intend.putExtras(bun);
                    startActivity(intend);
                }
            });
            return insets;
        });
    }
}

