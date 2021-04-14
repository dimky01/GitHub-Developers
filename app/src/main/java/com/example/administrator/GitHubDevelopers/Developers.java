package com.example.administrator.GitHubDevelopers;

/**
 * Created by Administrator on 3/30/2021.
 */

public class Developers {

    private String mUserName;
    private String mImageUrl;
    private String mGitHubUrl;


    public Developers (String userName, String imageUrl, String gitHubUrl) {
        mUserName = userName;
        mImageUrl = imageUrl;
        mGitHubUrl = gitHubUrl;
    }

    public String getUsername() {
        return mUserName;
    }

    public String getGitHubUrl() {
        return mGitHubUrl;
    }

    public String getImageUrl() { return mImageUrl;  }

}
