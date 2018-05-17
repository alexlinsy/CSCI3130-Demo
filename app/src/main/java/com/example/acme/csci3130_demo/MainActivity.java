package com.example.acme.csci3130_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Button
        Button copyButton = (Button)findViewById(R.id.copyButton);
        //Create an alert dialog
        AlertDialog.Builder Alertbuilder = new AlertDialog.Builder(this);
        Alertbuilder.setMessage("Please type in some contents");
        Alertbuilder.setCancelable(true);

        Alertbuilder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        final AlertDialog alertBox = Alertbuilder.create();

        //Waiting for the copy button to click
        copyButton.setOnClickListener(

                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //Create textView
                        TextView textView = (TextView)findViewById(R.id.textView);
                        //Create editText
                        EditText editText = (EditText)findViewById(R.id.editText);
                        //Check if the editText is empty
                        if(editText.getText().toString().trim().length() == 0) {
                            alertBox.show();
                        }
                        //Set textView to the content of editText
                        else {
                            textView.setText(editText.getText());
                        }
                    }
                }
        );
    }
}
