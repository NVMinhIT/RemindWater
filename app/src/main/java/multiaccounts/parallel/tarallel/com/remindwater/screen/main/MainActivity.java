package multiaccounts.parallel.tarallel.com.remindwater.screen.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import multiaccounts.parallel.tarallel.com.remindwater.R;
import multiaccounts.parallel.tarallel.com.remindwater.navigation.Navigator;
import multiaccounts.parallel.tarallel.com.remindwater.screen.main.changeglass.GlassActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    ImageView imageCup;
    Navigator navigator;
    TextView tvAccount;
    private DrawerLayout mDrawerLayout;
    private android.support.v7.widget.Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private static final int REQUEST_CODE_EXAMPLE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        setNavigationViewListner();

    }


    private void initControls() {
        mDrawerLayout = findViewById(R.id.content_draw_layout);
        mToolbar = findViewById(R.id.content_toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        mToggle.syncState();
        imageCup = findViewById(R.id.img_caicoc);
        navigator = new Navigator(this);
        imageCup.setOnClickListener(this);
        tvAccount = findViewById(R.id.txt_account);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        navigator.startActivityForResult(GlassActivity.class, new Bundle(), REQUEST_CODE_EXAMPLE);
//        Intent intent = new Intent(this, GlassActivity.class);
//        startActivityForResult(intent, REQUEST_CODE_EXAMPLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_EXAMPLE) {


            if (resultCode == RESULT_OK) {

                final String result;
                if (data != null) {
                    result = data.getStringExtra(GlassActivity.EXTRA_DATA);
                    tvAccount.setText(result);
                }


            } else {

            }
        }

    }

    private void setNavigationViewListner() {
        NavigationView navigationView = findViewById(R.id.nav_drawer_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_history:

                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
