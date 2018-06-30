package com.acme.a3csci3130;

import android.support.annotation.Size;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {
    @NotNull
    public  String uid;

    @NotNull
    @Size(min=2, max=48)
    public  String name;

    @NotNull
    @Pattern("/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$/i"))/*regexp=.getString(R.string.emailPattern*/
    public  String email;

    @NotNull
    @Pattern("/[0-9]{9}/")
    @Size(min=9, max=9)
    public  String number;

    @Size(min=0, max=49)
    public  String address;

    @NotNull
    @Pattern("/(Fisher|Distributor|Processor|Fish Monger)/")
    public  String business;

    @Pattern("/(AB|BC|MB|NB|NS|NT|NU|ON|PE|QC|SK|YK|[ ])/")
    public  String pt;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String email, String number, String address, String business, String pt){
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.number = number;
        this.address = address;
        this.business = business;
        this.pt = pt;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("pt", pt);

        return result;
    }
}
