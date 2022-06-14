package com.example.an25_morenav.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.an25_morenav.adapters.ItemAdapter;
import com.example.an25_morenav.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    RecyclerView rView;
    GridLayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rView = binding.rv;

        // specifying the layout
        layoutManager = new GridLayoutManager(getActivity(),2);
        rView.setLayoutManager(layoutManager);

        setData();

        return root;
    }

    private void setData() {
        ItemAdapter adapter = new ItemAdapter(getActivity(), new ArrayList());
        rView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}