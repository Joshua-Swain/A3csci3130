package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, numberField, addressField, businessField, ptField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        numberField = (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        businessField = (EditText) findViewById(R.id.business);
        ptField = (EditText) findViewById(R.id.pt);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            numberField.setText(receivedPersonInfo.number);
            addressField.setText(receivedPersonInfo.address);
            businessField.setText(receivedPersonInfo.business);
            ptField.setText(receivedPersonInfo.pt);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
