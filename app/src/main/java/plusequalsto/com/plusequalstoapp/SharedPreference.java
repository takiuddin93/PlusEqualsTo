package plusequalsto.com.plusequalstoapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    SharedPreferences sharedPreference;

    public SharedPreference(Context context) {
        sharedPreference = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setThemeModeState(Boolean state) {

        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putBoolean("ThemeMode", state);
        editor.commit();

    }

    public Boolean getThemeModeState() {

        Boolean state = sharedPreference.getBoolean("ThemeMode", false);
        return state;

    }
}
