package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.settings;

import android.os.Bundle;

import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.expansion.ExpansionsDialog;
import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.utils.BaseActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;

import butterknife.OnClick;

public class SettingsMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_settings_menu);
    }

    @OnClick(R.id.expansions_owned_button)
    void onExpansionsOwnedButtonClicked() {
        new ExpansionsDialog().show(getSupportFragmentManager(), "expansions");
    }

    @OnClick(R.id.language_button)
    void onLanguageButtonClicked() {
        new LanguageDialog().show(getSupportFragmentManager(), "languages");
    }

    @OnClick(R.id.back_button)
    void onBackButtonClicked() {
        finish();
        overridePendingTransition(0, 0);
    }

}
