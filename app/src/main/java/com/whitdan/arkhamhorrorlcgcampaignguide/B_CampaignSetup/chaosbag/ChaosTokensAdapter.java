package com.whitdan.arkhamhorrorlcgcampaignguide.B_CampaignSetup.chaosbag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChaosTokensAdapter
        extends RecyclerView.Adapter<ChaosTokensAdapter.ChaosTokenViewHolder> {

    private List<ChaosBagToken> tokens;

    public ChaosTokensAdapter(List<ChaosBagToken> tokens) {
        this.tokens = tokens;
    }

    @NonNull
    @Override
    public ChaosTokenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chaos_token, parent, false);
        return new ChaosTokenViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ChaosTokenViewHolder holder, int position) {
        holder.bind(tokens.get(position));
    }

    @Override
    public int getItemCount() {
        return tokens.size();
    }

    static class ChaosTokenViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivChaosToken)
        ImageView ivChaosToken;

        public ChaosTokenViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(ChaosBagToken token) {
            ivChaosToken.setImageResource(token.getImageRes());
        }
    }

}
