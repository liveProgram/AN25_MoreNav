package com.example.an25_morenav.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.an25_morenav.R;
import com.example.an25_morenav.databinding.RvItemUiBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {
    Context c;
    List dataList;

    public ItemAdapter(Context c, List dataList) {
        this.c = c;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ui = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_ui, parent, false);
        return new Holder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class Holder extends RecyclerView.ViewHolder {
        RvItemUiBinding itemUiBinding;
        public Holder(@NonNull View itemView) {
            super(itemView);
            itemUiBinding = RvItemUiBinding.bind(itemView);
        }
    }
}
