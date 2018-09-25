package plusequalsto.com.plusequalstoapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    ConstraintLayout settingBackground;
    TextView notificationPrefHeading, themePrefHeading, supportHeading, privacyPolicy, aboutHeading, version;
    Typeface notificationHeadingFonts, themeFonts, supportHeadingFonts, privacyFonts, aboutHeadingFonts, versionFonts;
    Switch notificationPref, themePref, gridPref;

    AppBarLayout appbar;
    Toolbar toolbar;

    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreference = new SharedPreference(this);
        if (sharedPreference.getThemeModeState() == true) {
            setTheme(R.style.AppNightTheme);
        } else setTheme(R.style.AppDayTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settingBackground = (ConstraintLayout) findViewById(R.id.settingBackground);
        notificationPrefHeading = (TextView) findViewById(R.id.notificationPrefHeading);
        themePrefHeading = (TextView) findViewById(R.id.themePrefHeading);
        supportHeading = (TextView) findViewById(R.id.supportHeading);
        privacyPolicy = (TextView) findViewById(R.id.privacyPolicy);
        aboutHeading = (TextView) findViewById(R.id.aboutHeading);
        version = (TextView) findViewById(R.id.version);

        notificationPref = (Switch) findViewById(R.id.notificationPref);
        themePref = (Switch) findViewById(R.id.themePref);
        gridPref = (Switch) findViewById(R.id.gridPref);

        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (sharedPreference.getThemeModeState() == true) {
            themePref.setChecked(true);
        }
        themePref.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    sharedPreference.setThemeModeState(true);
                    appbar.setBackgroundColor(Color.parseColor("#2F2F2F"));
                    toolbar.setBackgroundColor(Color.parseColor("#2F2F2F"));
                    settingBackground.setBackgroundColor(Color.parseColor("#2F2F2F"));
                    notificationPrefHeading.setTextColor(Color.parseColor("#FAFAFA"));
                    notificationPref.setTextColor(Color.parseColor("#FAFAFA"));
                    themePrefHeading.setTextColor(Color.parseColor("#FAFAFA"));
                    themePref.setTextColor(Color.parseColor("#FAFAFA"));
                    gridPref.setTextColor(Color.parseColor("#FAFAFA"));
                    supportHeading.setTextColor(Color.parseColor("#FAFAFA"));
                    privacyPolicy.setTextColor(Color.parseColor("#FAFAFA"));
                    aboutHeading.setTextColor(Color.parseColor("#FAFAFA"));
                    version.setTextColor(Color.parseColor("#FAFAFA"));
//                    restartApp();
                } else {
                    sharedPreference.setThemeModeState(false);
                    appbar.setBackgroundColor(Color.parseColor("#EC2238"));
                    toolbar.setBackgroundColor(Color.parseColor("#EC2238"));
                    settingBackground.setBackgroundColor(Color.parseColor("#FAFAFA"));
                    notificationPrefHeading.setTextColor(Color.parseColor("#2F2F2F"));
                    notificationPref.setTextColor(Color.parseColor("#2F2F2F"));
                    themePrefHeading.setTextColor(Color.parseColor("#2F2F2F"));
                    themePref.setTextColor(Color.parseColor("#2F2F2F"));
                    gridPref.setTextColor(Color.parseColor("#2F2F2F"));
                    supportHeading.setTextColor(Color.parseColor("#2F2F2F"));
                    privacyPolicy.setTextColor(Color.parseColor("#2F2F2F"));
                    aboutHeading.setTextColor(Color.parseColor("#2F2F2F"));
                    version.setTextColor(Color.parseColor("#2F2F2F"));
//                    restartApp();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupActionBar();

        notificationHeadingFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.otf");
        themeFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Regular.otf");
        supportHeadingFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.otf");
        privacyFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Regular.otf");
        aboutHeadingFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.otf");
        versionFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Regular.otf");

        notificationPrefHeading.setTypeface(notificationHeadingFonts);
        themePrefHeading.setTypeface(themeFonts);
        supportHeading.setTypeface(supportHeadingFonts);
        privacyPolicy.setTypeface(privacyFonts);
        aboutHeading.setTypeface(aboutHeadingFonts);
        version.setTypeface(versionFonts);

        privacyPolicy = (TextView) findViewById(R.id.privacyPolicy);
        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, PrivacyPolicyActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Settings");
        }
    }

    private void restartApp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
