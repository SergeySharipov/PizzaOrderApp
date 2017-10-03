package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Sergey-PC on 30.09.2017.
 */

public class AppSharedPref {;
    private static final String SHARED_PREF_KEY =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.app_shared_pref";

    public static SharedPreferences getSharedPref(Context context){
        return context.getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);
    }

    public static void put(Context context, String key, int value) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, Set<String> value) {
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key){
        SharedPreferences sharedPref = getSharedPref(context);
        return sharedPref.getInt(key, 0);
    }
    public static String getString(Context context, String key){
        SharedPreferences sharedPref = getSharedPref(context);
        return sharedPref.getString(key, "");
    }
    public static Set<String> getStringSet(Context context, String key){
        SharedPreferences sharedPref = getSharedPref(context);
        return sharedPref.getStringSet(key, null);
    }
}
