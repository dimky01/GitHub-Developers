package com.example.administrator.GitHubDevelopers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 3/30/2021.
 */

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        ImageView profileImageView = (ImageView) findViewById(R.id.profileImageView);
        TextView profileUsernameView = (TextView) findViewById(R.id.profileUserName);
        TextView profileGitHubUrlView = (TextView) findViewById(R.id.profileGitHubUrl);
        TextView profileActive = (TextView) findViewById(R.id.profileActive);
        //TextView profileLocation = (TextView) findViewById(R.id.profileGitHubLocation);
        Button shareProfileView = (Button) findViewById(R.id.profileShare);

        Intent intent = getIntent();
        final String userName = intent.getStringExtra(DevelopersAdapter.KEY_NAME);
        String profileImage = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);
        final String gitHubUrl = intent.getStringExtra(DevelopersAdapter.KEY_URL);
        final String gitHubActive = intent.getStringExtra(DevelopersAdapter.KEY_SCORE);
        //final String gitHubLocation = intent.getStringExtra(DevelopersAdapter.KEY_LOCATION);


        Picasso.with(this)
                .load(profileImage)
                .into(profileImageView);

        profileUsernameView.setText(userName);
        profileGitHubUrlView.setText(gitHubUrl);
        profileActive.setText(gitHubActive);
        //profileGitHubUrlView.setText(gitHubLocation);

        profileGitHubUrlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = gitHubUrl;
                Intent urlIntent = new Intent(Intent.ACTION_VIEW);
                urlIntent.setData(Uri.parse(url));
                startActivity(urlIntent);

            }
        });

        shareProfileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer @"
                        + userName +
                        ", " + gitHubUrl);
                Intent appChooser = Intent.createChooser(shareIntent, "Share Via");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(appChooser);
                }
            }
        });
    }
}

