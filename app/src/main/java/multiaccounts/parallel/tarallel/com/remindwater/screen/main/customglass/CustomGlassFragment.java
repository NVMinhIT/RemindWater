package multiaccounts.parallel.tarallel.com.remindwater.screen.main.customglass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import multiaccounts.parallel.tarallel.com.remindwater.R;

public class CustomGlassFragment extends Fragment {
    public static final String TAG = "CustomGlassFragment";

    public static CustomGlassFragment newInstance() {
        return new CustomGlassFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_glass_fragment, container, false);
        return view.getRootView();
    }

}
