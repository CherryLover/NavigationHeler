package me.monster.navigationhelper.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import me.monster.navigationhelper.R;
import me.monster.navigationhelper.lib.NavigationHelper;

public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        rootView.findViewById(R.id.btn_third_exit)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavController navController = Navigation.findNavController(v);
                        navController.navigateUp();
                    }
                });

        rootView.findViewById(R.id.btn_third_back_to_root)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showTipDialog(false);
                    }
                });

        rootView.findViewById(R.id.btn_third_navigate_up_to_root)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showTipDialog(true);
                    }
                });
        return rootView;
    }

    private void showTipDialog(final boolean navigateUp) {
        new AlertDialog.Builder(requireActivity())
                .setTitle("Warning")
                .setMessage("Do you want to go to root fragment ? \n\nIt' require you use keep_state_fragment node name in Navigation Graph.")
                .setPositiveButton("I did it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (navigateUp) {
                            NavigationHelper.navigateUp(requireActivity(), R.id.btn_third_back_to_root, R.id.rootFragment);
                        } else {
                            NavigationHelper.close(requireActivity(), R.id.btn_third_back_to_root, R.id.middleFragment);
                        }
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

}
