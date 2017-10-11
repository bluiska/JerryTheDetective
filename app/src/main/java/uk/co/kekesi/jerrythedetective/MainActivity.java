package uk.co.kekesi.jerrythedetective;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.textColor;
import static uk.co.kekesi.jerrythedetective.R.id.imageView2;
import static uk.co.kekesi.jerrythedetective.R.id.inv_layout;

public class MainActivity extends AppCompatActivity {

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
                    mTextMessage.setText(R.string.title_home);
                    mainLayout = (ConstraintLayout) findViewById(R.id.container);
                    view = getLayoutInflater().inflate(R.layout.inventory, mainLayout, false);
                    mainLayout.addView(view);
                    inventoryVisible = true;
                    return true;
                case R.id.nav_gameplay:
                    mTextMessage.setText(R.string.title_dashboard);
                    if(inventoryVisible || mapVisible){
                        mainLayout.removeView(view);
                    }
                    gameplayVisible = true;
                    return true;
                case R.id.nav_map:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.nav_gameplay);

    }

}
