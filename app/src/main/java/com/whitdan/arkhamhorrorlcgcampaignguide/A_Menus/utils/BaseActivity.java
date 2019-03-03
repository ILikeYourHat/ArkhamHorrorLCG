package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.MainMenuActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.B_CampaignSetup.chaosbag.ChaosBagSetupActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data.GlobalVariables;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected GlobalVariables globalVariables;

    protected void restartAppIfActivityRecreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Intent intent = new Intent(this, MainMenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        globalVariables = (GlobalVariables) this.getApplication();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

}
