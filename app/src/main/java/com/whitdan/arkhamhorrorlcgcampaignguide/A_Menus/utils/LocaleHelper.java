package com.whitdan.arkhamhorrorlcgcampaignguide.A_Menus.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class LocaleHelper {

    private static final String SELECTED_LANGUAGE = "language_setting";

    public static Context onAttach(Context context) {
        String language = getLocale(context);
        return setLocale(context, language);
    }

    public static Context setLocale(Context context, String language) {
        persist(context, language);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(context, locale);
        } else {
            return updateResourcesLegacy(context, locale);
        }
    }

    public static String getLocale(Context context) {
        String defaultLanguage = Locale.getDefault().getLanguage();
        return prefs(context).getString(SELECTED_LANGUAGE, defaultLanguage);
    }

    private static void persist(Context context, String language) {
        prefs(context).edit()
                .putString(SELECTED_LANGUAGE, language)
                .apply();
    }

    private static SharedPreferences prefs(Context context) {
        return context.getSharedPreferences("Shared preferences", Context.MODE_PRIVATE);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResources(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static Context updateResourcesLegacy(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

}