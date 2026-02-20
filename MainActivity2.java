package com.example.ex_091;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView tvdetails,tv1details;
    Button back;
    String first,last,phone,email,state,type,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            tvdetails=findViewById(R.id.tvDetails);
            back=findViewById(R.id.btnback);
            Bundle bun=getIntent().getExtras();
            first=bun.getString("first");
            last=bun.getString("last");
            phone=bun.getString("phone");
            email=bun.getString("email");
            state=bun.getString("state");
            type=bun.getString("type");
            description=bun.getString("description");
            tvdetails.setText("First Name   : "+ first + "\n"+ "Last Name   : "+ last + "\n" +"Phone   :" + phone +"\n" + "Email   :"
                                + email + "\n"+"State   :" + state + "\n" + "Type   : " + type + "\n" +"Description   :" + description );
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            return insets;
        });
    }
}


