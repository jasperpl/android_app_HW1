package com.example.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class sound_activity extends AppCompatActivity {
   private Button button_ok_sound;
   private Button button_cancel_sound;
   int selected_sound;
    String savedExtra;
    int savedExtraImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_activity);
        setSpinnerItemSelectedListener();
         savedExtra = getIntent().getStringExtra("contact_text");
         savedExtraImage=getIntent().getIntExtra("image", 0);
        Button button_ok_sound= findViewById(R.id.button_ok_sound);
        Button button_cancel_sound= findViewById(R.id.button_cancel_sound);
                button_ok_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("selected_sound", selected_sound);
                intent.putExtra("contact_text", savedExtra);
                intent.putExtra("image",savedExtraImage);
                sound_activity.this.finish();
                startActivity(intent);
            }
        });
        button_cancel_sound.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sound_activity.this.finish();
        }
    });

    }
    public void setSpinnerItemSelectedListener()
    {
        Spinner spinner=(Spinner) findViewById(R.id.spinner_sound);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position)
                    {
                        case 0:
                            selected_sound=0;break;
                        case 1:
                            selected_sound=1;break;
                        case 2:
                            selected_sound=2;break;
                        case 3:
                            selected_sound=3;break;
                        case 4:
                            selected_sound=4;break;
                            default:
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

}
