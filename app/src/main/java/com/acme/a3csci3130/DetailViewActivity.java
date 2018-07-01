package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Shows user data for the Contact that was selected
 * Allows user to view, change, update, or erase the contact.
 */
public class DetailViewActivity extends Activity{

    private EditText nameField, emailField, numberField, addressField, businessField, ptField;
    private  Button updateButton, eraseButton;
    String personId;
    Contact receivedPersonInfo;
    private MyApplicationData appState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        appState = ((MyApplicationData) getApplicationContext());
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        numberField = (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        businessField = (EditText) findViewById(R.id.business);
        ptField = (EditText) findViewById(R.id.pt);

        if(receivedPersonInfo != null){
            personId = (String) receivedPersonInfo.uid;

            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            numberField.setText(receivedPersonInfo.number);
            addressField.setText(receivedPersonInfo.address);
            businessField.setText(receivedPersonInfo.business);
            ptField.setText(receivedPersonInfo.pt);
        }

        updateButton = (Button) findViewById(R.id.updateButton);
    }

    /**
     * Sends the displayed contact data to the database
     * @param v Context for the update
     */
    public void updateContact(View v){
        //TODO: Update contact functionality
        if (!this.personId.isEmpty()) {
            String name = nameField.getText().toString();
            String email = emailField.getText().toString();
            String number = numberField.getText().toString();
            String address = addressField.getText().toString();
            String business = businessField.getText().toString();
            String pt = ptField.getText().toString();

            Contact updatedPerson = new Contact(personId, name, email, number, address, business, pt);

            appState.firebaseReference.child(personId).setValue(updatedPerson);

            finish();
        }
    }

    /**
     * Removes contact from database and returns user to MainActivity
     * @param v Context for the update
     */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        if (!this.personId.isEmpty()) {
            appState.firebaseReference.child(personId).setValue(null);
            finish();
        }
    }
}
