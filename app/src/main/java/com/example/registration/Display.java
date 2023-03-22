package com.example.registration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class Display extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        TextView t1=(TextView) findViewById(R.id.tv1);
        TextView t2=(TextView) findViewById(R.id.tv2);
        TextView t3=(TextView) findViewById(R.id.tv3);
        t1.setText(b.getString("Name"));
        t2.setText(b.getString("Address"));
        t3.setText(b.getString("Email"));
    }
}
