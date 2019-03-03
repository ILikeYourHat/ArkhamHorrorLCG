package com.whitdan.arkhamhorrorlcgcampaignguide.B_CampaignSetup.chaosbag;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.utils.BaseActivity;
import com.whitdan.arkhamhorrorlcgcampaignguide.R;
import com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data.Difficulty;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
    ChaosBagSetupActivity - Allows the selection of a difficulty and shows the makeup of the chaos bag relevant to
                            that difficulty
 */

public class ChaosBagSetupActivity extends BaseActivity {

    @BindView(R.id.campaign_name)
    TextView tvCampaignName;
    @BindView(R.id.rvChaosTokens)
    RecyclerView rvChaosTokens;
    @BindView(R.id.easy_button)
    RadioButton btnEasy;
    @BindView(R.id.standard_button)
    RadioButton btnStandard;
    @BindView(R.id.hard_button)
    RadioButton btnHard;
    @BindView(R.id.expert_button)
    RadioButton btnExpert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        restartAppIfActivityRecreated(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity_chaos_bag_setup);

        tvCampaignName.setText(globalVariables.getCurrentScenarioName());
        initDifficulties();
        refreshBag();
    }

    @OnClick(value = {
            R.id.easy_button,
            R.id.standard_button,
            R.id.hard_button,
            R.id.expert_button
    })
    void onDifficultyClicked(View v) {
        Difficulty difficulty = viewToDifficulty(v);
        globalVariables.CurrentDifficulty = difficulty.getId();
        refreshBag();
    }

    @OnClick(R.id.back_button)
    void onBackButtonClicked() {
        finish();
    }

    private void initDifficulties() {
        List<Difficulty> availableDifficulties = globalVariables.getAvailableDifficulties();
        for (Difficulty difficulty : Difficulty.values()) {
            RadioButton btn = difficultyToView(difficulty);
            if (availableDifficulties.contains(difficulty)) {
                btn.setVisibility(View.VISIBLE);
                btn.setChecked(difficulty.getId() == globalVariables.CurrentDifficulty);
            } else {
                btn.setVisibility(View.GONE);
                btn.setChecked(false);
            }
        }
    }

    private void refreshBag() {
        ChaosBag bag = globalVariables.getCurrentBag();
        rvChaosTokens.setAdapter(new ChaosTokensAdapter(bag.getTokens()));
    }

    private Difficulty viewToDifficulty(View view) {
        switch (view.getId()) {
            case (R.id.easy_button):
                return Difficulty.EASY;
            case (R.id.standard_button):
                return Difficulty.STANDARD;
            case (R.id.hard_button):
                return Difficulty.HARD;
            case (R.id.expert_button):
                return Difficulty.EXPERT;
            default:
                throw new IllegalArgumentException();
        }
    }

    private RadioButton difficultyToView(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return btnEasy;
            case STANDARD:
                return btnStandard;
            case HARD:
                return btnHard;
            case EXPERT:
                return btnExpert;
            default:
                throw new IllegalArgumentException();
        }
    }
}
