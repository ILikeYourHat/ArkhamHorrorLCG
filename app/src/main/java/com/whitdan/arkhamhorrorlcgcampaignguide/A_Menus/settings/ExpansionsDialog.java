package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.settings;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

// Dialog which allows editing in the settings which expansions a player owns
public class ExpansionsDialog extends DialogFragment {

    boolean dunwichOwned;
    boolean carcosaOwned;
    boolean forgottenOwned;
    boolean marieOwned;
    boolean normanOwned;
    boolean carolynOwned;
    boolean silasOwned;
    SharedPreferences settings;
    String dunwichOwnedString;
    String carcosaOwnedString;
    String forgottenOwnedString;
    String marieOwnedString;
    String normanOwnedString;
    String carolynOwnedString;
    String silasOwnedString;
    String sharedPrefs;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the sharedprefs settings
        sharedPrefs = getActivity().getResources().getString(R.string.shared_prefs);
        dunwichOwnedString = getActivity().getResources().getString(R.string.dunwich_setting);
        carcosaOwnedString = getActivity().getResources().getString(R.string.carcosa_setting);
        forgottenOwnedString = getActivity().getResources().getString(R.string.forgotten_setting);
        marieOwnedString = getActivity().getResources().getString(R.string.marie_lambeau);
        normanOwnedString = getActivity().getResources().getString(R.string.norman_withers);
        carolynOwnedString = getActivity().getResources().getString(R.string.carolyn_fern);
        silasOwnedString = getActivity().getResources().getString(R.string.silas_marsh);
        settings = getActivity().getSharedPreferences(sharedPrefs, 0);
        dunwichOwned = settings.getBoolean(dunwichOwnedString, true);
        carcosaOwned = settings.getBoolean(carcosaOwnedString, true);
        forgottenOwned = settings.getBoolean(forgottenOwnedString, true);
        marieOwned = settings.getBoolean(marieOwnedString, false);
        normanOwned = settings.getBoolean(normanOwnedString, false);
        carolynOwned = settings.getBoolean(carolynOwnedString, false);
        silasOwned = settings.getBoolean(silasOwnedString, false);

        // Get the layout inflater and inflate the view
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = View.inflate(getActivity(), R.layout.a_dialog_expansions_owned, null);

        // Set the checkboxes using the previous settings
        final CheckBox dunwich = v.findViewById(R.id.dunwich_owned);
        final CheckBox carcosa = v.findViewById(R.id.carcosa_owned);
        final CheckBox forgotten = v.findViewById(R.id.forgotten_owned);
        final CheckBox marie = v.findViewById(R.id.marie_xpac);
        final CheckBox norman = v.findViewById(R.id.norman_xpac);
        final CheckBox carolyn = v.findViewById(R.id.carolyn_xpac);
        final CheckBox silas = v.findViewById(R.id.silas_xpac);
        dunwich.setChecked(dunwichOwned);
        carcosa.setChecked(carcosaOwned);
        forgotten.setChecked(forgottenOwned);
        marie.setChecked(marieOwned);
        norman.setChecked(normanOwned);
        carolyn.setChecked(carolynOwned);
        silas.setChecked(silasOwned);

        // Set fonts
        Typeface arnopro = Typeface.createFromAsset(getActivity().getAssets(), "fonts/arnoprobold.otf");
        dunwich.setTypeface(arnopro);
        carcosa.setTypeface(arnopro);
        forgotten.setTypeface(arnopro);
        marie.setTypeface(arnopro);
        norman.setTypeface(arnopro);
        carolyn.setTypeface(arnopro);
        silas.setTypeface(arnopro);
        Typeface teutonic = Typeface.createFromAsset(getActivity().getAssets(), "fonts/teutonic.ttf");
        TextView title = v.findViewById(R.id.expansions_owned);
        Button cancelButton = v.findViewById(R.id.cancel_button);
        Button okayButton = v.findViewById(R.id.okay_button);
        title.setTypeface(teutonic);
        cancelButton.setTypeface(teutonic);
        okayButton.setTypeface(teutonic);

        // Save the settings on clicking okay
        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the settings per which checkboxes are checked
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(dunwichOwnedString, dunwich.isChecked());
                editor.putBoolean(carcosaOwnedString, carcosa.isChecked());
                editor.putBoolean(forgottenOwnedString, forgotten.isChecked());
                editor.putBoolean(marieOwnedString, marie.isChecked());
                editor.putBoolean(normanOwnedString, norman.isChecked());
                editor.putBoolean(carolynOwnedString, carolyn.isChecked());
                editor.putBoolean(silasOwnedString, silas.isChecked());
                editor.apply();
                dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        builder.setView(v);
        return builder.create();
    }
}
