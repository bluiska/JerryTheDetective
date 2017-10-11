package uk.co.kekesi.jerrythedetective;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.kekesi.jerrythedetective.Fragment.InventoryFragment;
import uk.co.kekesi.jerrythedetective.Fragment.GameplayFragment;
import uk.co.kekesi.jerrythedetective.Fragment.MapFragment;

import static android.R.attr.textColor;

public class MainActivity extends AppCompatActivity {

    //This is our viewPager
    private ViewPager viewPager;


    //Fragments

    GameplayFragment gameplayFragment;
    InventoryFragment inventoryFragment;
    MapFragment mapFragment;
    MenuItem prevMenuItem;

    private TextView mTextMessage;
    private ConstraintLayout mainLayout;
    private View view;
    private boolean inventoryVisible, gameplayVisible, mapVisible;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_inventory:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_gameplay:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_map:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.nav_gameplay);
        viewPager.setCurrentItem(1);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);
        viewPager.setCurrentItem(1);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        inventoryFragment=new InventoryFragment();
        gameplayFragment=new GameplayFragment();
        mapFragment=new MapFragment();
        adapter.addFragment(inventoryFragment);
        adapter.addFragment(gameplayFragment);
        adapter.addFragment(mapFragment);
        viewPager.setAdapter(adapter);
    }



}
