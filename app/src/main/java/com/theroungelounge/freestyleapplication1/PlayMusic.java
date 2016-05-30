package com.theroungelounge.freestyleapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PlayMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle mainMenuData = getIntent().getExtras();
        if (mainMenuData == null) {
            return;
        }
        final TextView musicText = (TextView)findViewById(R.id.musicText);
        String menuMessage = mainMenuData.getString("musicPlaying");
        musicText.setText(menuMessage);
    }

    public void returnToMenu(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
