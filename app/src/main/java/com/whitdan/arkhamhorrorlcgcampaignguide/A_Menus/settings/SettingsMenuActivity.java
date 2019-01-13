package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_settings_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.expansions_owned_button)
    void onExpansionsOwnedButtonClicked() {
        new ExpansionsDialog().show(getFragmentManager(), "expansions");
    }

    @OnClick(R.id.language_button)
    void onLanguageButtonClicked() {
        new LanguageDialog().show(getFragmentManager(), "languages");
    }

    @OnClick(R.id.back_button)
    void onBackButtonClicked() {
        finish();
        overridePendingTransition(0, 0);
    }

}
