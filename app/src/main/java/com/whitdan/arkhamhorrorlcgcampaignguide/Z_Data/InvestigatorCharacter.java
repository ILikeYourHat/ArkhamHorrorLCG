package com.whitdan.arkhamhorrorlcgcampaignguide.Z_Data;

import androidx.annotation.StringRes;

import com.whitdan.arkhamhorrorlcgcampaignguide.R;

public enum InvestigatorCharacter {
    NONE(0, 0, 0, 0),
    ROLAND_BANKS(R.string.roland_banks, 9, 5, 0),
    DAISY_WALKER(R.string.daisy_walker, 5, 9, 0),
    SKIDS_OTOOLE(R.string.skids_otoole, 8, 6, 0),
    AGNES_BAKER(R.string.agnes_baker, 6, 8, 0),
    WENDY_ADAMS(R.string.wendy_adams, 7, 7, 0),
    ZOEY_SAMARAS(R.string.zoey_samaras, 9, 6, 0),
    REX_MURPHY(R.string.rex_murphy, 6, 9, 0),
    JENNY_BARNES(R.string.jenny_barnes, 8, 7, 0),
    JIM_CULVER(R.string.jim_culver, 7, 8, 0),
    ASHCAN_PETE(R.string.ashcan_pete, 6, 5, 0),
    MARK_HARRIGAN(R.string.mark_harrigan, 9, 5, 0),
    MINH_THI_PHAN(R.string.minh_thi_phan, 7, 7, 0),
    SEFINA_ROUSSEAU(R.string.sefina_rousseau, 5, 9, 0),
    AKACHI_ONYELE(R.string.akachi_onyele, 6, 8, 0),
    WILLIAM_YORICK(R.string.william_yorick, 8, 6, 0),
    LOLA_HAYES(R.string.lola_hayes, 6, 6, 0),
    MARIE_LAMBEAU(R.string.marie_lambeau, 6, 8, 0),
    NORMAN_WITHERS(R.string.norman_withers, 6, 8, 0),
    CAROLYN_FERN(R.string.carolyn_fern, 6, 9, 0),
    SILAS_MARSH(R.string.silas_marsh, 9, 5, 0),
    LEO_ANDERSON(R.string.leo_anderson, 8, 6, 0),
    URSULA_DOWNS(R.string.ursula_downs, 7, 7, 0),
    FINN_EDWARDS(R.string.finn_edwards, 7, 7, 0),
    FATHER_MATEO(R.string.father_mateo, 6, 8, 5),
    CALVIN_WRIGHT(R.string.calvin_wright, 6, 6, 0);

    @StringRes
    private int name;
    private final int health;
    private final int sanity;
    private final int startingXP;

    InvestigatorCharacter(
            @StringRes int name,
            int health,
            int sanity,
            int startingXP
    ) {
        this.name = name;
        this.health = health;
        this.sanity = sanity;
        this.startingXP = startingXP;
    }

    @StringRes
    public static int getNameById(int id) {
        return values()[id].getName();
    }

    @StringRes
    public int getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSanity() {
        return sanity;
    }

    public int getStartingXP() {
        return startingXP;
    }
}
