package com.example.hw1;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    private MediaPlayer backgroundPlayer;
    private MediaPlayer buttonPlayer;
    TextView text;
    ImageView image_view;
    String savedExtra;
    int savedExtraImage;
    MediaPlayer sound;
    int selected_sound;
    int on_off;
    int this_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.this_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button_contact= findViewById(R.id.button_contact);
        Button button_sound= findViewById(R.id.button_sound);
        image_view=findViewById(R.id.contact_avatar);
        sound =  MediaPlayer.create(this, R.raw.track01);
        FloatingActionButton fab = findViewById(R.id.play);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_off^=1;
                if(on_off==1) {
                    sound.start();
                }
                else{
                    sound.pause();}
            }
        });
        button_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_off=0;
                sound.pause();
                openActivity_contact();
            }
        });
        button_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_off=0;
                sound.pause();
                openActivity_sound();
            }
        });
    }
    public void openActivity_contact() {
        Intent intent = new Intent(this, contact_activity.class);
        startActivityForResult(intent,1);
    }
    public void openActivity_sound() {
        Intent intent = new Intent(this, sound_activity.class);
        intent.putExtra("contact_text",savedExtra);
        intent.putExtra("image",savedExtraImage);
        startActivityForResult(intent,2);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2) {
            if (resultCode == sound_activity.RESULT_OK) {
                selected_sound = data.getIntExtra("selected_sound", 0);
            }
            switch (selected_sound)
            {
                case 0:
                    sound =  MediaPlayer.create(this, R.raw.track01);
                    break;
                case 1:
                    sound =  MediaPlayer.create(this, R.raw.track02);
                    break;
                case 2:
                    sound =  MediaPlayer.create(this, R.raw.track03);
                    break;
                case 3:
                    sound =  MediaPlayer.create(this, R.raw.track04);
                    break;
                case 4:
                    sound =  MediaPlayer.create(this, R.raw.track05);
                    break;
                default:
                    sound =  MediaPlayer.create(this, R.raw.track01);
            }
        }
        else if (requestCode==1)
        {
            if(resultCode==contact_activity.RESULT_OK) {
                savedExtra = data.getStringExtra("contact_text");
                savedExtraImage = data.getIntExtra("image", 0);
                switch (savedExtraImage)
                {
                    case 1:
                        this_image=R.drawable.avatar_1;
                        break;
                    case 2:
                        this_image=R.drawable.avatar_2;
                        break;
                    case 3:
                        this_image=R.drawable.avatar_3;
                        break;
                    case 4:
                        this_image=R.drawable.avatar_4;
                        break;
                    case 5:
                        this_image=R.drawable.avatar_5;
                        break;
                    default:
                }
                if(savedExtra!=null){
                    text.setText(savedExtra);
                    image_view.setImageResource(this_image);}
            }
        }
    }

    @Override
    protected void onDestroy() {
        sound.release();
        super.onDestroy();
    }
}
