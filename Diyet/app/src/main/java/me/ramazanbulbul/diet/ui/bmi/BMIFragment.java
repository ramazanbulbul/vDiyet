package me.ramazanbulbul.diet.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import me.ramazanbulbul.diet.R;

public class BMIFragment extends Fragment {

    private BMIViewModel bmiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bmiViewModel =
                ViewModelProviders.of(this).get(BMIViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bmi, container, false);
        final TextView textView = root.findViewById(R.id.text_bmi);
        bmiViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}