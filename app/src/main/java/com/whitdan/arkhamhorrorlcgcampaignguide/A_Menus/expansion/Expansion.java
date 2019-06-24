package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.expansion;

import androidx.annotation.StringRes;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

public enum Expansion {
    DUNWICH_LEGACY(R.string.dunwich_campaign),
    PATH_TO_CARCOSA(R.string.carcosa_campaign),
    FORGOTEN_AGE(R.string.forgotten_campaign),
    MARIE_PROMO(R.string.marie_lambeau),
    NORMAN_PROMO(R.string.norman_withers),
    CAROLYN_PROMO(R.string.carolyn_fern),
    SILAS_PROMO(R.string.silas_marsh);

    @StringRes
    private int name;

    Expansion(@StringRes int name) {
        this.name = name;
    }

    @StringRes
    public int getName() {
        return name;
    }
}
