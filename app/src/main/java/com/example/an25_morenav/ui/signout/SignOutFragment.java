package com.example.an25_morenav.ui.signout;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import com.example.an25_morenav.MainActivity;
import com.example.an25_morenav.databinding.FragmentSignOutBinding;

public class SignOutFragment extends DialogFragment {

    FragmentSignOutBinding binding;
    Button btnCancel, btnConfirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignOutBinding.inflate(getLayoutInflater(), container, false);

        btnCancel = binding.btnCancel;
        btnConfirm = binding.btnConfirm;

        btnCancel.setOnClickListener(v -> getDialog().dismiss());

        btnConfirm.setOnClickListener(v -> {
            // need to call clear method for deleting all info of current user
           // startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finishAffinity(); // clear all the stacked screens
        });

        return binding.getRoot();
    }
}