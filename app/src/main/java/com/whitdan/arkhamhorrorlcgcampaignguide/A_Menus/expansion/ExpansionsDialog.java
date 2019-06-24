package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.expansion;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.annimon.stream.Stream;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpansionsDialog extends DialogFragment {

    private ExpansionRepository repository;
    private ExpansionsAdapter expansionsAdapter;

    @BindView(R.id.rvExpansions)
    RecyclerView rvExpansions;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        repository = new ExpansionRepository(getContext());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View v = View.inflate(getActivity(), R.layout.a_dialog_expansions_owned, null);
        ButterKnife.bind(this, v);
        expansionsAdapter = new ExpansionsAdapter(getEntries());
        rvExpansions.setAdapter(expansionsAdapter);
        builder.setView(v);
        return builder.create();
    }

    private List<ExpansionsAdapter.Entry> getEntries() {
        return Stream.of(Expansion.values())
                .map(expansion -> {
                    ExpansionsAdapter.Entry entry = new ExpansionsAdapter.Entry();
                    entry.expansion = expansion;
                    entry.isOwned = repository.isOwned(expansion);
                    return entry;
                })
                .toList();
    }

    @OnClick(R.id.okay_button)
    void onOkayButtonClicked() {
        Stream.of(expansionsAdapter.getData())
                .forEach(entry -> repository.setOwned(entry.expansion, entry.isOwned));
        dismiss();
    }

    @OnClick(R.id.cancel_button)
    void onCancelButtonClicked() {
        dismiss();
    }
}
