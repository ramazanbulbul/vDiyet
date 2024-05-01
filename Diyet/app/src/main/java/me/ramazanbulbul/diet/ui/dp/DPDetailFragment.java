package me.ramazanbulbul.diet.ui.dp;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.ramazanbulbul.diet.R;

public class DPDetailFragment extends Fragment {

    private DpdetailViewModel mViewModel;

    public static DPDetailFragment newInstance() {
        return new DPDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dp_detail, container, false);

        TextView textView = view.findViewById(R.id.textview_dp_detail_title);
        textView.setText(getArguments().getString("dietTitle"));

        TextView textViewDetail = view.findViewById(R.id.textview_dp_detail);
        textViewDetail.setText(getArguments().getString("dietDetail"));

        ImageView imageView = view.findViewById(R.id.imageView_dp_detail);
        imageView.setImageResource(getArguments().getInt("dietImage"));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DpdetailViewModel.class);
        // TODO: Use the ViewModel
    }

}
