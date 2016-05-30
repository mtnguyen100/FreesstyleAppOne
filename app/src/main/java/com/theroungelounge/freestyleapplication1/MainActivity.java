package com.theroungelounge.freestyleapplication1;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;
import android.content.Intent;
import com.theroungelounge.freestyleapplication1.dummy.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //instantiates and starts the refresherService and intentServiceExample
        Intent refresherService = new Intent(this, RefresherService.class);
        Intent intentServiceExample = new Intent(this, IntentServiceExample.class);
        startService(refresherService);
        startService(intentServiceExample);
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
        RelativeLayout main_view = (RelativeLayout)findViewById(R.id.main_view);
        TextView sortText = (TextView)findViewById(R.id.sortText);
        int id = item.getItemId();

        switch (id) {
            case R.id.playlist_list:
                Intent gotoPlaylists = new Intent(this, ItemListActivity.class);
                startActivity(gotoPlaylists);
                return true;
            case R.id.action_settings:
                Intent gotoSettings = new Intent(this, Settings.class);
                startActivity(gotoSettings);
                return true;
            case R.id.send_system_broadcast:
                Intent systemBroadcast = new Intent();
                systemBroadcast.setAction("com.theroungelounge.freestyleapplication1");
                systemBroadcast.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(systemBroadcast);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void playMusic(View view) {
        Intent i = new Intent(this, PlayMusic.class);
        i.putExtra("musicPlaying", "Now playing: ");
        startActivity(i);
    }
}