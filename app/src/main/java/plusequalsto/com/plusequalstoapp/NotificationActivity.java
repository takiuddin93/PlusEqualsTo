package plusequalsto.com.plusequalstoapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
    TextView title, content;
    Typeface fonts;

    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreference = new SharedPreference(this);
        if (sharedPreference.getThemeModeState() == true) {
            setTheme(R.style.AppNightTheme);
        } else setTheme(R.style.AppDayTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupActionBar();
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        fonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Regular.otf");
        title.setTypeface(fonts);
        content.setTypeface(fonts);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Notifications");
        }
    }
}
