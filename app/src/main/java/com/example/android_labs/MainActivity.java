package com.example.android_labs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText emailField;
    SharedPreferences share;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailField = (EditText) findViewById(R.id.email);
        share = getSharedPreferences("FileName", Context.MODE_PRIVATE);
        String savedString = share.getString("ReserveName", "Default value");

        emailField.setHint(savedString);
        loginBtn = (Button) findViewById(R.id.button);
        loginBtn.setOnClickListener(c -> {

            Intent profilePage = new Intent(MainActivity.this, ProfileActivity.class);
            //EditText td = (EditText) findViewById(R.id.pass);
            profilePage.putExtra("emailTyped", emailField.getText().toString());
            startActivityForResult(profilePage, 345);

        });
        }



/*{

    SharedPreferences share;
    EditText emailField;

    Switch switch1;
    LinearLayout linearLayout;
    GridLayout gridlayout;
    RelativeLayout relativeLayout;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.button);
        emailField = (EditText) findViewById(R.id.email);
        share = getSharedPreferences("FileName", Context.MODE_PRIVATE);
        String saveEmail = share.getString("ReserveName", "");
        emailField.setHint(saveEmail);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {


                Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
                goToProfile.putExtra("EMAIL", "...what is written in the edit text");

                Intent nextPage = new Intent();
                nextPage.putExtra("emailType", emailField.getText().toString());
                MainActivity.this.startActivityForResult(nextPage, 345);
            }
        });
    }
      Button button = findViewById(R.id.button);
       switch1 = (Switch)findViewById(R.id.switch1);
       linearLayout = (LinearLayout)findViewById(R.id.linearlayout);
       gridlayout = (GridLayout) findViewById(R.id.gridlayout);
       relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
      CheckBox checkbox = (CheckBox)findViewById(R.id.checkBox);
        switch1.setOnCheckedChangeListener(this);

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.ButtonText, Toast.LENGTH_SHORT).show();

           }
      });


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

               Toast.makeText(getApplicationContext(),R.string.toast_message, Toast.LENGTH_SHORT).show();           }
       });






    @Override
    public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
        if(switch1.isChecked()){
            switch1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "The switch is now on", Snackbar.LENGTH_LONG)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    buttonView.setChecked(!isChecked);
                                }
                            });
                    snackbar.show();
                }
            });
        }else{
            switch1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "The switch is now off", Snackbar.LENGTH_LONG)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    buttonView.setChecked(!isChecked);
                                }
                            });

                    snackbar.show();
                }
            });
        }
    }
*/
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = share.edit();
        String typeEmail  = emailField.getText().toString();
        editor.putString("ReserveName", typeEmail);
        editor.apply();
    }
}