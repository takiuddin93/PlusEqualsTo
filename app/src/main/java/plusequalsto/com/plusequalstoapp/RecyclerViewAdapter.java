package plusequalsto.com.plusequalstoapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<Model> dataset;
    private Context mContext;
    Typeface titleFonts, authorFonts;

    public RecyclerViewAdapter(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
        titleFonts = Typeface.createFromAsset(mContext.getAssets(), "fonts/Poppins-Bold.otf");
        authorFonts = Typeface.createFromAsset(mContext.getAssets(), "fonts/Poppins-Light.otf");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardPosts;
        TextView title, author;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.cardPosts = (CardView) itemView.findViewById(R.id.cardPosts);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageThumbnail);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.author = (TextView) itemView.findViewById(R.id.author);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyclerviewadapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Model object = dataset.get(position);
        String author;
        if (Integer.valueOf(object.author) == 1) {
            author = "Plus Equals To";
        } else if (Integer.valueOf(object.author) == 2) {
            author = "Taki Uddin";
        } else {
            author = "Fahim Sarower";
        }

        Log.e("RecyclerViewAdapter", String.valueOf(object.title));

        ((ViewHolder) holder).title.setTypeface(titleFonts);
        ((ViewHolder) holder).title.setText(Html.fromHtml(object.title));
        ((ViewHolder) holder).author.setTypeface(authorFonts);
        ((ViewHolder) holder).author.setText("By " + author + ".");
        Picasso.get().load(HomeFragment.mAllPost.get(position).getJetpackFeaturedMediaUrl()).into(((ViewHolder) holder).imageView);
        ((ViewHolder) holder).cardPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostDetails.class);
//                Bundle bundle = ActivityOptions.makeCustomAnimation(mContext, R.anim.slide_in_up, R.anim.slide_out_up).toBundle();
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });
        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
