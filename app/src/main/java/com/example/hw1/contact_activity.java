package com.example.hw1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class contact_activity extends AppCompatActivity {
    private Button button_ok_contact;
    private Button button_cancel_contact;
    String value;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_activity);
        Intent received_intent = getIntent();
        Button button_cancel_contact= findViewById(R.id.button_cancel_contact);
        Button button_ok_contact= findViewById(R.id.button_ok_contact);
        button_ok_contact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("contact_text", value);
            intent.putExtra("image",image);
            contact_activity.this.finish();
            startActivity(intent);
        }
    });
        button_cancel_contact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contact_activity.this.finish();
        }
    });
    }
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.contact1:
                if (checked) {
                    RadioButton text = (RadioButton) findViewById(R.id.contact1);
                    value = text.getText().toString();
                    TextView txV = (TextView) findViewById(R.id.change_contact);
                    txV.setText(value);
                   image= R.drawable.avatar_1;
                    }
                    break;
            case R.id.contact2:
                if (checked) {
                    RadioButton text = (RadioButton) findViewById(R.id.contact2);
                    value = text.getText().toString();
                    TextView txV = (TextView) findViewById(R.id.change_contact);
                    txV.setText(value);
                    image= R.drawable.avatar_2;
                }
                    break;
            case R.id.contact3:
                if (checked) {
                    RadioButton text = (RadioButton) findViewById(R.id.contact3);
                    value = text.getText().toString();
                    TextView txV = (TextView) findViewById(R.id.change_contact);
                    txV.setText(value);
                    image= R.drawable.avatar_3;
                }
                break;
            case R.id.contact4:
                if (checked) {
                    RadioButton text = (RadioButton) findViewById(R.id.contact4);
                    value = text.getText().toString();
                    TextView txV = (TextView) findViewById(R.id.change_contact);
                    txV.setText(value);
                    image= R.drawable.avatar_4;
                }
                break;
            case R.id.contact5:
                if (checked) {
                    RadioButton text = (RadioButton) findViewById(R.id.contact5);
                    value = text.getText().toString();
                    TextView txV = (TextView) findViewById(R.id.change_contact);
                    txV.setText(value);
                    image= R.drawable.avatar_5;
                }
                break;
            case R.id.contact6:
                if (checked) {
                    RadioButton text = (RadioButton) findViewById(R.id.contact6);
                    value = text.getText().toString();
                    TextView txV = (TextView) findViewById(R.id.change_contact);
                    txV.setText(value);
                    image= R.drawable.avatar_5;
                }
                break;
        }
    }
}
