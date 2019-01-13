package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.settings;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.MainMenuActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;

// Dialog which allows editing in the settings which expansions a player owns
public class LanguageDialog extends DialogFragment {

    SharedPreferences settings;
    String language;
    String languageSetting;
    String sharedPrefs;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the sharedprefs settings
        sharedPrefs = getActivity().getResources().getString(R.string.shared_prefs);
        languageSetting = getActivity().getResources().getString(R.string.language_setting);
        settings = getActivity().getSharedPreferences(sharedPrefs, 0);
        language = settings.getString(languageSetting, "sys");

        // Get the layout inflater and inflate the view
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = View.inflate(getActivity(), R.layout.a_dialog_languages, null);

        // Set the checkboxes using the previous settings
        final RadioGroup languageSelection = v.findViewById(R.id.language_selection);
        final RadioButton english = v.findViewById(R.id.english);
        final RadioButton german = v.findViewById(R.id.german);
        final RadioButton french = v.findViewById(R.id.french);
        final RadioButton spanish = v.findViewById(R.id.spanish);
        final RadioButton italian = v.findViewById(R.id.italian);
        switch(language){
            case "sys":
                languageSelection.clearCheck();
                break;
            case "en":
                english.setChecked(true);
                break;
            case "de":
                german.setChecked(true);
                break;
            case "fr":
                french.setChecked(true);
                break;
            case "es":
                spanish.setChecked(true);
                break;
            case "it":
                italian.setChecked(true);
                break;
        }

        // Set fonts
        Typeface arnopro = Typeface.createFromAsset(getActivity().getAssets(), "fonts/arnoprobold.otf");
        english.setTypeface(arnopro);
        german.setTypeface(arnopro);
        french.setTypeface(arnopro);
        spanish.setTypeface(arnopro);
        italian.setTypeface(arnopro);
        Typeface teutonic = Typeface.createFromAsset(getActivity().getAssets(), "fonts/teutonic.ttf");
        TextView title = v.findViewById(R.id.languages);
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
                if (english.isChecked()){
                    language = "en";
                } else if (german.isChecked()){
                    language = "de";
                } else if (french.isChecked()){
                    language = "fr";
                } else if (spanish.isChecked()){
                    language = "es";
                } else if (italian.isChecked()){
                    language = "it";
                }
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(languageSetting, language);
                editor.apply();
                MainMenuActivity.setLocale(getActivity(), language);
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
