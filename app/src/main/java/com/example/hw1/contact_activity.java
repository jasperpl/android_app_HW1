package com.example.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contact_activity extends AppCompatActivity {
    private Button button_ok_contact;
    private Button button_cancel_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_activity);
        Button button_cancel_contact= findViewById(R.id.button_cancel_contact);
        Button button_ok_contact= findViewById(R.id.button_ok_contact);
//        Intent received_intent = getIntent();
//        Integer sound_id = received_intent.getIntExtra(MainActivity.SOUND_ID,0);
//        TextView txV = (TextView)findViewById(R.id.current_sound_text);
//        txV.setText(getText(R.string.current_sound_str) + sound_id.toString());
        button_ok_contact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contact_activity.this.finish();
        }
    });
        button_cancel_contact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contact_activity.this.finish();
        }
    });
    }
}
