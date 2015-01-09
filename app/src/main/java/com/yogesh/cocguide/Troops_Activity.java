package com.yogesh.cocguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Troops_Activity extends ActionBarActivity {
    
    private Toolbar toolbar;
    private static String titles[] = {"Normal Troops", "Dark Troops"};
    ListView mListview;

    {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troops);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        toolbar.setTitle("Troops");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        /*
        mAdapter = new TroopsPagerAdapter(getSupportFragmentManager());
        ViewPager vpPager = (ViewPager) findViewById(R.id.troopsPager);
        vpPager.setAdapter(mAdapter);
        */

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,R.layout.row_item, R.id.row_text, titles);

        mListview = (ListView) findViewById(R.id.listView_troops);
        mListview.setAdapter(arrayAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String value = (String)parent.getItemAtPosition(position);
                
                if(value=="Normal Troops"){
                    Intent mIntent = new Intent(Troops_Activity.this, NormalTroops.class);
                    startActivity(mIntent);
                    overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
                }
                else if (value=="Dark Troops"){
                    Intent mIntent = new Intent(Troops_Activity.this, Darktroops.class);
                    startActivity(mIntent);
                    overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
                    
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_troops, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }
}
