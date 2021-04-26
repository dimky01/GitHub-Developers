package com.example.administrator.GitHubDevelopers;

/**
 * Created by Administrator on 3/30/2021.
 */

public class Developers {

    private String mUserName;
    private String mImageUrl;
    private String mGitHubUrl;
    private String mGitHubScore;
    //private String mGitHubLocation;


    public Developers (String userName, String imageUrl, String gitHubUrl) {
        mUserName = userName;
        mImageUrl = imageUrl;
        mGitHubUrl = gitHubUrl;
        //mGitHubScore = gitHubScore;
    }

    public String getUsername() {
        return mUserName;
    }

    public String getGitHubUrl() {
        return mGitHubUrl;
    }

    public String getImageUrl() { return mImageUrl;  }

    public String getGitHubScore() { return mGitHubScore;  }

    public void setmGitHubScore(String score) {
        this.mGitHubScore=score;
    }

    //public String getGitHubLocation() { return mGitHubLocation;  }

    //public void setGitHubLocation(String location) {
        //this.mGitHubLocation=location;
    //}

}
