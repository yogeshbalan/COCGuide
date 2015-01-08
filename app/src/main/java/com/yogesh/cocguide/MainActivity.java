package com.yogesh.cocguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

        //final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        //final RippleBackground rippleBackground2=(RippleBackground)findViewById(R.id.content2);


        army = (ImageButton)findViewById(R.id.army);
        defense = (ImageButton)findViewById(R.id.defense);
        others = (ImageButton)findViewById(R.id.others);
        resources = (ImageButton)findViewById(R.id.resources);
        traps = (ImageButton)findViewById(R.id.traps);
        troops = (ImageButton)findViewById(R.id.troops);
        
        army.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rippleBackground2.startRippleAnimation();
                Intent armyIntent = new Intent(MainActivity.this, Army_Activity.class);
                startActivity(armyIntent);
                overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
            }
        });
        
        defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent defenseIntent = new Intent(MainActivity.this, Defense_Activity.class);
                startActivity(defenseIntent);
                overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
            }
        });
        
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent othersIntent = new Intent(MainActivity.this, Others_Activity.class);
                startActivity(othersIntent);
                overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
            }
        });
        
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resIntent = new Intent(MainActivity.this, Resources_Activity.class);
                startActivity(resIntent);
                overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
            }
        });
        
        traps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trapIntent = new Intent(MainActivity.this, Traps_Activity.class);
                startActivity(trapIntent);
                overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
            }
        });

        troops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rippleBackground.startRippleAnimation();
                Intent troopIntent = new Intent(MainActivity.this, Troops_Activity.class);
                startActivity(troopIntent);
                overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
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
