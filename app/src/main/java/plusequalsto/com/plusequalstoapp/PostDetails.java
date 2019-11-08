package plusequalsto.com.plusequalstoapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PostDetails extends AppCompatActivity {
    TextView title, author, description;
    ImageView featuredImage;
    Typeface titleFonts, authorFonts, descriptionFonts;
    Dialog myDialog;

    private ShareActionProvider mShareActionProvider;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.AppNightTheme);
        } else setTheme(R.style.AppDayTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdetails);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupActionBar();

        featuredImage = (ImageView) findViewById(R.id.featuredImage);
        title = (TextView) findViewById(R.id.Title);
        author = (TextView) findViewById(R.id.Author);
        description = (TextView) findViewById(R.id.Description);
        titleFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Bold.otf");
        authorFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Light.otf");
        descriptionFonts = Typeface.createFromAsset(this.getAssets(), "fonts/Poppins-Regular.otf");
        Intent pos = getIntent();
        int position = pos.getExtras().getInt("itemPosition");

        String tempTitle = HomeFragment.mAllPost.get(position).getTitle().getRendered().toString();
//        tempTitle = tempTitle.replace("<p>","");
//        tempTitle = tempTitle.replace("</p>","");
//        tempTitle = tempTitle.replace("[&hellip;]","");

        String tempAuthor = HomeFragment.mAllPost.get(position).getAuthor().toString();
        if (Integer.valueOf(tempAuthor) == 1) {
            tempAuthor = "Plus Equals To";
        } else if (Integer.valueOf(tempAuthor) == 2) {
            tempAuthor = "Taki Uddin";
        } else {
            tempAuthor = "Fahim Sarower";
        }

        String tempDescription = HomeFragment.mAllPost.get(position).getContent().getRendered().toString();
//        tempDescription = tempDescription.replace("<p>","");
//        tempDescription = tempDescription.replace("</p>","");
//        tempDescription = tempDescription.replace("[&hellip;]","");
//        tempDescription = tempDescription.replace("&#8211;","-");
//        tempDescription = tempDescription.replace("&#8217;","'");

        Picasso.get().load(HomeFragment.mAllPost.get(position).getJetpackFeaturedMediaUrl()).into(featuredImage);
        title.setTypeface(titleFonts);
        title.setText(Html.fromHtml(tempTitle));
        author.setTypeface(authorFonts);
        author.setText("By " + tempAuthor);
        description.setTypeface(descriptionFonts);
        description.setText(Html.fromHtml(tempDescription));

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.social, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
//            Intent notificationsIntent = new Intent(this, NotificationActivity.class);
//            this.startActivity(notificationsIntent);
            Intent pos = getIntent();
            int position = pos.getExtras().getInt("itemPosition");
            Intent share = new Intent(
                    Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(
                    Intent.EXTRA_TEXT, HomeFragment.mAllPost.get(position).getTitle() + " " + HomeFragment.mAllPost.get(position).getLink());
            startActivity(Intent.createChooser(share, "Share Via"));
            return true;
        }
        if (id == R.id.action_lit) {
//            Intent settingsIntent = new Intent(this, SettingsActivity.class);
//            this.startActivity(settingsIntent);
            Toast.makeText(this, "Lit clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
