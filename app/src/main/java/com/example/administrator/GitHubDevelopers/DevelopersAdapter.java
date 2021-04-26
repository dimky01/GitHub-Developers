package com.example.administrator.GitHubDevelopers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 3/30/2021.
 */

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder>{

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "imagers";
    public static final String KEY_URL = "url";
    public static final String KEY_SCORE = "score";
    //public static final String KEY_LOCATION = "location";

    //we define a list from the Developer class
    private List<Developers> developersLists;
    private Context context;


    /**
     * Constructor to initialise the List and Context objects
     * @param developers
     * @param context
     */
    public DevelopersAdapter(List<Developers> developers, Context context) {
        this.developersLists = developers;
        this.context =context;
    }

    /**
     * Method to be called whenever ViewHolder is created
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.developers_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }



    /**
     * to bind data to the ViewHolder from where it will be shown to other views
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Developers developers = developersLists.get(position);
        holder.username.setText(developers.getUsername());

        Picasso.with(context)
                .load(developers.getImageUrl())
                .into(holder.image_Url);

        //holder.gitHub_Score.setText("Score:" + developers.getGitHubScore());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Developers developer1 = developersLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), ProfilePage.class);
                skipIntent.putExtra(KEY_NAME, developer1.getUsername());
                skipIntent.putExtra(KEY_IMAGE, developer1.getImageUrl());
                skipIntent.putExtra(KEY_URL, developer1.getGitHubUrl());
                skipIntent.putExtra(KEY_SCORE, developer1.getGitHubScore());
                //skipIntent.putExtra(KEY_LOCATION, developer1.getGitHubLocation());
                v.getContext().startActivity(skipIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return developersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //define view objects
        public TextView username;
        public ImageView image_Url;
        public TextView gitHub_Url;
        public TextView gitHub_Score;
        //public TextView gitHub_Location;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            username = (TextView) itemView.findViewById((R.id.username));
            image_Url = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            gitHub_Url = (TextView) itemView.findViewById(R.id.profileShare);
            gitHub_Score = (TextView) itemView.findViewById(R.id.score);
            //gitHub_Location = (TextView) itemView.findViewById(R.id.profileGitHubLocation);
        }
    }
}
