package com.uid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncFetch extends AsyncTask<String, Void, String> {

    private HttpURLConnection connection = null;

    private BufferedReader bufferedReader = null;


    private JSONObject user;
    private JSONArray jObject;
    private Users siteUsers = new Users();

    private Context myContext;

    public AsyncFetch(Context myContext) {
        this.myContext = myContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Toast.makeText (myContext , "Loading..." ,Toast.LENGTH_LONG ).show();
    }

    @Override
    protected String doInBackground(String... strings) {


        ConnectivityManager cm = (ConnectivityManager)myContext.getSystemService(myContext.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null ) {

            try {

                URL url = new URL("https://api.github.com/users?since=135");
                connection = (HttpURLConnection) url.openConnection();

                if (connection != null) {

                    connection.connect();

                    InputStream inputStream = connection.getInputStream();

                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    String line = "";

                    while ((line = bufferedReader.readLine()) != null) {
                        jObject = new JSONArray(line);
                    }
                }
                else {
                    Toast.makeText(myContext,"Error : URL is empty",Toast.LENGTH_LONG).show();
                }
            } catch(IOException | JSONException e){
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(myContext,"Error : check your Internet Connection",Toast.LENGTH_LONG).show();
        }
        return String.valueOf(jObject);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        MyDBHandler myDBHandler = new MyDBHandler(myContext);

        for (int i = 0 ; i<=jObject.length()-1 ; i++)
        {
            try {

                user = jObject.getJSONObject(i);

                siteUsers.setLogin(user.getString("login"));
                siteUsers.setId(user.getInt("id"));
                siteUsers.setNode_id(user.getString("node_id"));
                siteUsers.setAvatar_url(user.getString("avatar_url"));
                siteUsers.setGravatar_url(user.getString("gravatar_id"));
                siteUsers.setUrl(user.getString("url"));
                siteUsers.setHtml_url(user.getString("html_url"));
                siteUsers.setFollowers_url(user.getString("followers_url"));
                siteUsers.setFollowing_url(user.getString("following_url"));
                siteUsers.setGists_url(user.getString("gists_url"));
                siteUsers.setStarred_url(user.getString("starred_url"));
                siteUsers.setSubscription_url(user.getString("subscriptions_url"));
                siteUsers.setOrganization_url(user.getString("organizations_url"));
                siteUsers.setRepos_url(user.getString("repos_url"));
                siteUsers.setEvents_url(user.getString("events_url"));
                siteUsers.setReceived_events_url(user.getString("received_events_url"));
                siteUsers.setType(user.getString("type"));
                siteUsers.setSite_admin(user.getBoolean("site_admin"));

                myDBHandler.addUser(siteUsers);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}