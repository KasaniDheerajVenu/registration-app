package com.example.registration;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1;
        EditText e2;
        EditText e3;
        EditText e4;
        Button b;
        String[] countries={"India","United States of America","Australia"};
        e1=(EditText) findViewById(R.id.edt1);
        e2=(EditText) findViewById(R.id.edt2);
        e3=(EditText) findViewById(R.id.pst);
        e4=(EditText) findViewById(R.id.eml);
        b=(Button) findViewById(R.id.btn);
        HashMap<String, String[]> countryStates = new HashMap<String, String[]>();
        countryStates.put("India", new String[] {"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh ","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra and Nagar Haveli","Daman and Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","National Capital Territory of Delhi","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"});
        countryStates.put("United States of America", new String[] {"Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"});
        countryStates.put("Australia", new String[]{"New South Wales","Queensland","South Australia","Tasmania","Victoria","Western Australia","The Australian Capital Territory","The Northern Territory"});
        Spinner cnt=(Spinner) findViewById(R.id.cty);
        Spinner ste=(Spinner) findViewById(R.id.state);
        String emailPattern = "[a-zA-Z/d._-]+@[a-z]+\\.+[a-z]+";
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cnt.setAdapter(adapter);
        cnt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] newStates = countryStates.get(countries[i]);
                ArrayAdapter<String> stateArad2 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, newStates);
                stateArad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ste.setAdapter(stateArad2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=e1.getText().toString();
                String a=e2.getText().toString();
                String p=e3.getText().toString();
                String e=e4.getText().toString();
                Bundle bl=new Bundle();
                bl.putString("Name",s);
                bl.putString("Address",a);
                bl.putString("Email",e);
                if(s.isEmpty()||p.isEmpty()||a.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please fill required fields",Toast.LENGTH_SHORT).show();
                }
                else if(!(e.matches(emailPattern)&&e.length()>0)){
                    Toast.makeText(getApplicationContext(),"Please enter valid email",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Display.class);
                    i.putExtras(bl);
                    startActivity(i);
                }
            }
        });
    }
}
