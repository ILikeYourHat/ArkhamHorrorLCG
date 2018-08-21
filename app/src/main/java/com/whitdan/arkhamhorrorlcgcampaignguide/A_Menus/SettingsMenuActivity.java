package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_settings_menu);

        // Get the button views for all of the campaigns
        Button expansionsButton = findViewById(R.id.expansions_owned_button);
        Button languageButton = findViewById(R.id.language_button);

        // Set correct font to all of the buttons
        Typeface teutonic = Typeface.createFromAsset(getAssets(), "fonts/teutonic.ttf");
        expansionsButton.setTypeface(teutonic);
        languageButton.setTypeface(teutonic);

        // Attach click listener to each button
        expansionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment expansionsDialog = new ExpansionsDialog();
                expansionsDialog.show(getFragmentManager(), "expansions");
            }
        });
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment languageDialog = new LanguageDialog();
                languageDialog.show(getFragmentManager(), "languages");
            }
        });

        // Back button
        Button backButton = findViewById(R.id.back_button);
        backButton.setTypeface(teutonic);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }

    // Dialog which allows editing in the settings which expansions a player owns
    public static class LanguageDialog extends DialogFragment {

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

    // Dialog which allows editing in the settings which expansions a player owns
    public static class ExpansionsDialog extends DialogFragment {

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
}
