package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Displays empty fields for creating a contact
 */
public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField, numberField, businessField, addressField, ptField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        ptField = (EditText) findViewById(R.id.pt);
    }

    /**
     * Creates new Contact in the database
     * Update will only happen if the fields follow the database rules.
     * @param v Context
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String number = numberField.getText().toString();
        String address = addressField.getText().toString();
        String business = businessField.getText().toString();
        String pt = ptField.getText().toString();
        Contact person = new Contact(personID, name, email, number, address, business, pt);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
