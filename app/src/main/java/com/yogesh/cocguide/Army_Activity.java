package com.yogesh.cocguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Army_Activity extends ActionBarActivity {

    private Toolbar toolbar;
    private static String titles[] = {"Heroes",
            "Barracks",
            "Dark Barracks",
            "Laboratory",
            "Spell Factory"
    };
    ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_army);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        toolbar.setTitle("Army");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,R.layout.row_item, R.id.row_text, titles);

        mListview = (ListView) findViewById(R.id.listView_army);
        mListview.setAdapter(arrayAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String value = (String)parent.getItemAtPosition(position);

                if(value=="Heroes"){
                    Intent mIntent = new Intent(Army_Activity.this, Heroes.class);
                    startActivity(mIntent);
                    overridePendingTransition(R.anim.slide_out, R.anim.fade_out);
                }

            }
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_army, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }
}
