package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.settings.SettingsMenuActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.utils.BaseActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.utils.LocaleHelper;
import com.whitdan.arkhamhorrorlcgcampaignguide.D_Misc.ChaosBagActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;
import com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data.GlobalVariables;

import butterknife.OnClick;

/*
    MainMenuActivity - This is the main activity, and shows the title as well as buttons to take users to either
    start a new campaign, load an existing campaign, or select a standalone scenario; all of these buttons simply
    take the user to the relevant activity
 */

// TODO: export/import, standalones
public class MainMenuActivity extends BaseActivity {

    static GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_main_menu);
        globalVariables = (GlobalVariables) this.getApplication();
    }

    @OnClick(R.id.new_campaign_button)
    void onNewCampaignClicked() {
        Intent intent = new Intent(this, ChooseCampaignActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @OnClick(R.id.load_campaign_button)
    void onLoadCampaignClicked() {
        Intent intent = new Intent(this, LoadCampaignActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.standalone_scenario_button)
    void onStandaloneScenarioClicked() {
        Intent intent = new Intent(getBaseContext(), StandaloneActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @OnClick(R.id.chaos_bag_button)
    void onChaosBagClicked() {
        globalVariables.CurrentCampaign = 1000;
        Intent intent = new Intent(this, ChaosBagActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.settings_button)
    void onSettingsClicked() {
        Intent intent = new Intent(getBaseContext(), SettingsMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public static void setLocale(Context context, String newLanguage) {
        String currentLanguage = LocaleHelper.getLocale(context);
        if (!currentLanguage.equals(newLanguage)) {
            LocaleHelper.setLocale(context, newLanguage);
            restartApp(context);
        }
    }

    private static void restartApp(Context context) {
        Intent refresh = new Intent(context, MainMenuActivity.class);
        context.startActivity(refresh);
        Activity activity = (Activity) context;
        activity.finish();
    }

}
