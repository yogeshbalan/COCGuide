package com.yogesh.cocguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ImageButton army, defense, others, resources, traps, troops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        setSupportActionBar(toolbar);

        
        army = (ImageButton)findViewById(R.id.army);
        defense = (ImageButton)findViewById(R.id.defense);
        others = (ImageButton)findViewById(R.id.others);
        resources = (ImageButton)findViewById(R.id.resources);
        traps = (ImageButton)findViewById(R.id.traps);
        troops = (ImageButton)findViewById(R.id.troops);
        
        army.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent armyIntent = new Intent(MainActivity.this, Army_Activity.class);
                startActivity(armyIntent);
            }
        });
        
        defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent defenseIntent = new Intent(MainActivity.this, Defense_Activity.class);
                startActivity(defenseIntent);
            }
        });
        
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent othersIntent = new Intent(MainActivity.this, Others_Activity.class);
                startActivity(othersIntent);
            }
        });
        
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resIntent = new Intent(MainActivity.this, Resources_Activity.class);
                startActivity(resIntent);
            }
        });
        
        traps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trapIntent = new Intent(MainActivity.this, Traps_Activity.class);
                startActivity(trapIntent);
            }
        });
        
        troops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent troopIntent = new Intent(MainActivity.this, Troops_Activity.class);
                startActivity(troopIntent);
            }
        });

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
