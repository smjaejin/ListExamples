package com.example.mclane.listexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends AppCompatActivity {

    TextView nameTextView, descTextView;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        wireWidgets();
        Intent i = getIntent();
        Person p = i.getParcelableExtra("person");
        nameTextView.setText(p.getName());
        descTextView.setText(p.getDesc());
        pic.setImageResource(p.getImageResourceID());
    }

    private void wireWidgets() {
        nameTextView = (TextView) findViewById(R.id.textView_name);
        descTextView = (TextView) findViewById(R.id.textView_desc);
        pic = (ImageView) findViewById(R.id.imageView_pic);

    }

}
