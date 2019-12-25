package me.monster.navigationhelper.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.monster.navigationhelper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiddleFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_middle, container, false);
        rootView.findViewById(R.id.btn_middle_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.thirdFragment);
            }
        });
        rootView.findViewById(R.id.btn_middle_exit)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavController navController = Navigation.findNavController(v);
                        navController.navigateUp();
                    }
                });
        return rootView;
    }

}
