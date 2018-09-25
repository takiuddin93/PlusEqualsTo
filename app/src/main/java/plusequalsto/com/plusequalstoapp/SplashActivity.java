package plusequalsto.com.plusequalstoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    public static final int SPLASH_DELAY = 1000;

    SharedPreference sharedPreference;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreference = new SharedPreference(this);
        if (sharedPreference.getThemeModeState() == true) {
            setTheme(R.style.AppNightTheme);
        } else setTheme(R.style.AppDayTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ConstraintLayout splashBackground;

        splashBackground = (ConstraintLayout) findViewById(R.id.splashBackground);
        textView = (TextView) findViewById(R.id.textView);

        if (sharedPreference.getThemeModeState() == true) {
            splashBackground.setBackgroundColor(getResources().getColor(R.color.tintcolorNight));
            textView.setTextColor(getResources().getColor(R.color.textcolorNight));
        } else {
            splashBackground.setBackgroundColor(getResources().getColor(R.color.tintcolorDay));
            textView.setTextColor(getResources().getColor(R.color.textcolorDay));
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}
