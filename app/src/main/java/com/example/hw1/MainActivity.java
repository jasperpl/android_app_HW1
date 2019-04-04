package com.example.hw1;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button button_contact;
    private Button button_sound;
    TextView text;
    ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String savedExtra = getIntent().getStringExtra("contact_text");
        int savedExtraImage=getIntent().getIntExtra("image", 0);;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button_contact= findViewById(R.id.button_contact);
        Button button_sound= findViewById(R.id.button_sound);
        image_view=findViewById(R.id.contact_avatar);
        FloatingActionButton fab = findViewById(R.id.play);
        text = findViewById(R.id.this_contact);
        if(getIntent().getExtras()!=null) {
            text.setText(savedExtra);
            image_view.setImageResource(savedExtraImage);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_contact();
            }
        });
        button_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_sound();
            }
        });
    }
    public void openActivity_contact() {
        Intent intent = new Intent(this, contact_activity.class);
        startActivity(intent);
    }
    public void openActivity_sound() {
        Intent intent = new Intent(this, sound_activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
