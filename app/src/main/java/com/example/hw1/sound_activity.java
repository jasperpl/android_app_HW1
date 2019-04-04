package com.example.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sound_activity extends AppCompatActivity {
   private Button button_ok_sound;
   private Button button_cancel_sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_activity);
        Button button_ok_sound= findViewById(R.id.button_ok_sound);
        Button button_cancel_sound= findViewById(R.id.button_cancel_sound);
                button_ok_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound_activity.this.finish();
            }
        });
        button_cancel_sound.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sound_activity.this.finish();
        }
    });

    }

}
