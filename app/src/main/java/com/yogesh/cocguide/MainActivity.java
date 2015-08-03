package com.yogesh.cocguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yogesh.cocguide.adapters.NotifyScrollView;


public class MainActivity extends ActionBarActivity implements NotifyScrollView.Callback {

    private Toolbar toolbar;
    private ImageButton army, defense, others, resources, traps, troops;
    private TextView toolTitle;
    private CharSequence mtitle;

    //this is it
    private NotifyScrollView mNotifyScrollView;
    private FrameLayout mImageFrameLayout;
    private ImageView mImageView;
    private LinearLayout mContentLinearLayout;
    private LinearLayout mToolbarLinearLayout;
    //yep
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_substituted);

        Typeface type = Typeface.createFromAsset(getAssets(), "Supercell-Magic_5.ttf");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("COC Guide");
        
        toolbar.setTitleTextColor(getResources().getColor(R.color.White));
        toolTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mtitle = "COC Guide";
        toolTitle.setText(mtitle);
        toolTitle.setTypeface(type);
        toolTitle.setTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //new
        mNotifyScrollView = (NotifyScrollView) findViewById(R.id.notify_scroll_view);
        mImageFrameLayout = (FrameLayout) findViewById(R.id.image_frame_layout);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mContentLinearLayout = (LinearLayout) findViewById(R.id.content_linear_layout);
        mToolbarLinearLayout = (LinearLayout) findViewById(R.id.toolbar_linear_layout);
        //end

        // more setup
        setupNotifyScrollView();
        //setupToolbar();


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

    //toolbar methods
    private void setupNotifyScrollView() {
        mNotifyScrollView.setCallback(this);

        ViewTreeObserver viewTreeObserver = mNotifyScrollView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // get size
                    int toolbarLinearLayoutHeight = mToolbarLinearLayout.getHeight();
                    int imageHeight = mImageView.getHeight();

                    // adjust image frame layout height
                    ViewGroup.LayoutParams layoutParams = mImageFrameLayout.getLayoutParams();
                    if (layoutParams.height != imageHeight) {
                        layoutParams.height = imageHeight;
                        mImageFrameLayout.setLayoutParams(layoutParams);
                    }

                    // adjust top margin of content linear layout
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) mContentLinearLayout.getLayoutParams();
                    if (marginLayoutParams.topMargin != toolbarLinearLayoutHeight + imageHeight) {
                        marginLayoutParams.topMargin = toolbarLinearLayoutHeight + imageHeight;
                        mContentLinearLayout.setLayoutParams(marginLayoutParams);
                    }

                    // call onScrollChange to update initial properties.
                    onScrollChanged(0, 0, 0, 0);
                }
            });
        }
    }

    private void setupToolbar() {
        // set ActionBar as Toolbar
        //setSupportActionBar(toolbar);
    }

    @Override
    public void onScrollChanged(int left, int top, int oldLeft, int oldTop) {
        // get scroll y
        int scrollY = mNotifyScrollView.getScrollY();

        // calculate new y (for toolbar translation)
        float newY = Math.max(mImageView.getHeight(), scrollY);

        // translate toolbar linear layout and image frame layout
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mToolbarLinearLayout.setTranslationY(newY);
            mImageFrameLayout.setTranslationY(scrollY * 0.5f);
            /* toolbar.getBackground().setAlpha((int)(newY*0.5f)); */
            
        } else {
            ViewCompat.setTranslationY(mToolbarLinearLayout, newY);
            ViewCompat.setTranslationY(mImageFrameLayout, scrollY * 0.5f);
            
        }
    }

    //end


}
