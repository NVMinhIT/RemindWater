package multiaccounts.parallel.tarallel.com.remindwater.screen.main.changeglass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import multiaccounts.parallel.tarallel.com.remindwater.R;
import multiaccounts.parallel.tarallel.com.remindwater.listener.IOnClickListeners;
import multiaccounts.parallel.tarallel.com.remindwater.model.Glass;
import multiaccounts.parallel.tarallel.com.remindwater.navigation.Navigator;
import multiaccounts.parallel.tarallel.com.remindwater.screen.main.customglass.CustomGlassFragment;

public class GlassActivity extends AppCompatActivity implements View.OnClickListener, IOnClickListeners<Glass> {
    public static final String EXTRA_DATA = GlassActivity.class.getSimpleName();

    ImageButton imageButtonBack;
    RecyclerView recyclerView;
    private AdapterGlass adapterGlass;
    private List<Glass> mGlassList;
    TextView tvSoluong;
    TextView tvOption;
    Navigator navigator;

    public static Intent getInstance(Context context) {
        Intent intent = new Intent(context, GlassActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass);
        inits();
    }

    private void inits() {
        mGlassList = new ArrayList<>();
        recyclerView = findViewById(R.id.content_main);
        tvOption = findViewById(R.id.txt_option);
        navigator = new Navigator(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapterGlass = new AdapterGlass(this, preparGlass());
        adapterGlass.setListeners(this);
        recyclerView.setAdapter(adapterGlass);
        imageButtonBack = findViewById(R.id.image_button_back);
        imageButtonBack.setOnClickListener(this);
        tvOption.setOnClickListener(this);
        tvSoluong = findViewById(R.id.txt_soluong);
    }

    private List<Glass> preparGlass() {
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        int[] resId = {R.drawable.ic_cupone, R.drawable.ic_cuptwo, R.drawable.ic_cupthree, R.drawable.ic_cupfour,
                R.drawable.ic_cupfive
        };
        List<Glass> Names = new ArrayList<>();
        int count = 0;
        for (String name : names) {

            Names.add(new Glass(resId[count], name));
            count++;

        }
        return Names;

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        setResult(RESULT_CANCELED);
        super.onBackPressed();


    }

    @Override
    public void onClick(View v) {

        //Toast.makeText(this, "hihi", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.txt_option:
                navigator.addFragment(R.id.content_constrainlayout, CustomGlassFragment.newInstance(),
                        true, Navigator.NavigateAnim.BOTTOM_UP, CustomGlassFragment.TAG);

        }
    }

    @Override
    public void onClick(Glass glass) {
        String soluong = glass.getAmount();
        String subsoluong = soluong.substring(0, 4);
        //Toast.makeText(this, "Name" + soluong, Toast.LENGTH_SHORT).show();
        Intent data = new Intent();
        data.putExtra(EXTRA_DATA, subsoluong);
        setResult(RESULT_OK, data);
        finish();

    }


}
