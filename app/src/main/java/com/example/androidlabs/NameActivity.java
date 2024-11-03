package com.example.androidlabs;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");

        Button btnThankYou = findViewById(R.id.btnThank);
        Button btnDont = findViewById(R.id.btnDont);

        TextView greeting = (TextView) findViewById(R.id.textViewGreeting);

        String welcome = NameActivity.this.getResources().getString(R.string.welcome_message);
        String message = welcome +" "+ data + "!";

        greeting.setText(message);


        btnDont.setOnClickListener(click -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(intent,0);
        });

        btnThankYou.setOnClickListener(click -> {
            Intent intent = new Intent();
            startActivityForResult(intent,1);
            setResult(1);
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });

    }
}