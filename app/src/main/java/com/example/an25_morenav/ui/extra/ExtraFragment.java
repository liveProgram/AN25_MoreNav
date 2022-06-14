package com.example.an25_morenav.ui.extra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.an25_morenav.R;
import com.example.an25_morenav.databinding.FragmentExtraBinding;
import com.squareup.picasso.Picasso;


public class ExtraFragment extends Fragment {

    private FragmentExtraBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExtraBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /* Displaying image using library */

        Picasso.get() // instance of picasso accessed in the file
                .load("https://lh5.googleusercontent.com/p/AF1QipPEDU_DJnEdUStKmiOop1I9nARg8cbt5fiwydV2") // the image url need to be provided
                .centerCrop() // cropping
                .error(R.drawable.ic_baseline_account_circle_24)
                .placeholder(androidx.transition.R.drawable.abc_ic_star_black_16dp)
                .into(binding.iv);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}