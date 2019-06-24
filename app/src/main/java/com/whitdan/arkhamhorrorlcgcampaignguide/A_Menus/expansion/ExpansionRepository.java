package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.expansion;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.List;

public class ExpansionRepository {

    private static final String PREFS_EXPANSIONS_OWNED = "expansions_owned";
    private static final List<Expansion> EXPANSIONS_SELECTED_BY_DEFAULT = Arrays.asList(
            Expansion.DUNWICH_LEGACY,
            Expansion.PATH_TO_CARCOSA,
            Expansion.FORGOTEN_AGE
    );

    private SharedPreferences sharedPreferences;

    public ExpansionRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_EXPANSIONS_OWNED, Context.MODE_PRIVATE);
    }

    public boolean isOwned(Expansion expansion) {
        boolean isSelectedByDefault = EXPANSIONS_SELECTED_BY_DEFAULT.contains(expansion);
        return sharedPreferences.getBoolean(expansion.toString(), isSelectedByDefault);
    }

    public void setOwned(Expansion expansion, boolean owned) {
        sharedPreferences.edit()
                .putBoolean(expansion.toString(), owned)
                .apply();
    }
}
