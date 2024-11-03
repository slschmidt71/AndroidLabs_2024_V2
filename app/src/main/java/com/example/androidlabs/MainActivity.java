package com.example.androidlabs;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.edtxtName);

        final SharedPreferences prefs = getApplicationContext().getSharedPreferences("shared_prefs", MODE_PRIVATE);
        String nameInEditText = prefs.getString("name","name not found");

        SharedPreferences.Editor editor = prefs.edit();

        editTextName.setText(nameInEditText);

        Button nextButton = findViewById(R.id.btnNext);

       nextButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getApplicationContext(), NameActivity.class);
               intent.putExtra("data",editTextName.getText().toString());

               editor.putString("name", editTextName.getText().toString());
               editor.commit();

               startActivityForResult(intent,1);

           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0)
        {
            // user wants to change their name. This check isn't actually necessary here.
        }
        else if (requestCode==1)
        {
            finish();
            System.exit(0);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}

