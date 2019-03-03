package com.whitdan.arkhamhorrorlcgcampaignguide.B_CampaignSetup.chaosbag;

import androidx.annotation.DrawableRes;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

public enum ChaosBagToken {
    PLUS_ONE(R.drawable.token_1),
    ZERO(R.drawable.token_2),
    MINUS_ONE(R.drawable.token_3),
    MINUS_TWO(R.drawable.token_4),
    MINUS_THREE(R.drawable.token_5),
    MINUS_FOUR(R.drawable.token_6),
    MINUS_FIVE(R.drawable.token_7),
    MINUS_SIX(R.drawable.token_8),
    MINUS_SEVEN(R.drawable.token_9),
    MINUS_EIGHT(R.drawable.token_10),
    SKULL(R.drawable.token_11),
    CULTIST(R.drawable.token_12),
    TABLET(R.drawable.token_13),
    ELDER_THING(R.drawable.token_14),
    TENTACLES(R.drawable.token_15),
    ELDER_SIGN(R.drawable.token_16);

    @DrawableRes
    private int imageRes;

    ChaosBagToken(@DrawableRes int imageRes){
        this.imageRes = imageRes;
    }

    @DrawableRes
    public int getImageRes() {
        return imageRes;
    }

}
