package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.expansion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.annimon.stream.Stream;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;

import java.util.List;

public class ExpansionsAdapter
        extends RecyclerView.Adapter<ExpansionsAdapter.ExpansionViewHolder>
        implements OnExpansionClickedListener {

    private List<Entry> data;

    public ExpansionsAdapter(List<Entry> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ExpansionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expansion_owned, parent, false);
        return new ExpansionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpansionViewHolder holder, int position) {
        Expansion expansion = data.get(position).expansion;
        boolean isChecked = data.get(position).isOwned;
        holder.bind(expansion, isChecked, this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onExpansionClicked(Expansion expansion) {
        Stream.of(data)
                .filter(value -> value.expansion.equals(expansion))
                .findFirst()
                .ifPresent(entry -> {
                    entry.isOwned = !entry.isOwned;
                    notifyDataSetChanged();
                });
    }

    public List<Entry> getData() {
        return data;
    }

    public static class Entry {
        Expansion expansion;
        boolean isOwned;
    }

    static class ExpansionViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;

        public ExpansionViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView;
        }

        public void bind(Expansion expansion, boolean isChecked, OnExpansionClickedListener listener) {
            checkBox.setText(expansion.getName());
            checkBox.setChecked(isChecked);
            checkBox.setOnClickListener(view ->
                    listener.onExpansionClicked(expansion)
            );
        }
    }
}
