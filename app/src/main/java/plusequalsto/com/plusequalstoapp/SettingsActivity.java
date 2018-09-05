package plusequalsto.com.plusequalstoapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    TextView notificationPrefHeading, themePrefHeading, supportHeading, privacyPolicy, aboutHeading, version;
    Typeface notificationHeadingFonts, themeFonts, supportHeadingFonts, privacyFonts, aboutHeadingFonts, versionFonts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupActionBar();

        notificationPrefHeading = (TextView) findViewById(R.id.notificationPrefHeading);
        themePrefHeading = (TextView) findViewById(R.id.themePrefHeading);
        supportHeading = (TextView) findViewById(R.id.supportHeading);
        privacyPolicy = (TextView) findViewById(R.id.privacyPolicy);
        aboutHeading = (TextView) findViewById(R.id.aboutHeading);
        version = (TextView) findViewById(R.id.version);

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
}
