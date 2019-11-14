package com.uid;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABSE_NAME = "user.db";
    private static final String TABLE_USERS = "Users";

    private static final String LOGIN_NAME = "login";
    private static final String ID = "id";
    private static final String NODE_ID = "node_id";
    private static final String AVATAR_URL = "avatar_url";
    private static final String GRAVATAR_URL = "gravatar_id";
    private static final String URL = "url";
    private static final String HTML_URL = "html_url";
    private static final String FOLLOWERS_URL = "followers_url";
    private static final String FOLLOWING_URL = "following_url";
    private static final String GISTS_URL = "gists_url";
    private static final String STARRED_URL = "starred_url";
    private static final String SUBSCRIPTION_URL = "subscriptions_url";
    private static final String ORGANIZATION_URL = "organizations_url";
    private static final String REPOS_URL = "repos_url";
    private static final String EVENTS_URL = "events_url";
    private static final String RECEIVED_EVENTS_URL = "received_events_url";
    private static final String TYPE = "type";
    private static final String SITE_ADMIN = "site_admin";

    MyDBHandler(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_USERS + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOGIN_NAME + " TEXT, " +
                NODE_ID + " TEXT, " +
                AVATAR_URL + " TEXT, " +
                GRAVATAR_URL + " TEXT, " +
                URL + " TEXT, " +
                HTML_URL + " TEXT, " +
                FOLLOWERS_URL + " TEXT, " +
                FOLLOWING_URL + " TEXT, " +
                GISTS_URL + " TEXT, " +
                STARRED_URL + " TEXT, " +
                SUBSCRIPTION_URL + " TEXT, " +
                ORGANIZATION_URL + " TEXT, " +
                REPOS_URL + " TEXT, " +
                EVENTS_URL + " TEXT, " +
                RECEIVED_EVENTS_URL + " TEXT, " +
                TYPE + " TEXT, " +
                SITE_ADMIN + " TEXT " +
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS);
        onCreate(db);
    }

    void addUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LOGIN_NAME, user.getLogin());
        values.put(ID, user.getId());
        values.put(NODE_ID, user.getNode_id());
        values.put(AVATAR_URL, user.getAvatar_url());
        values.put(GRAVATAR_URL, user.getGravatar_url());
        values.put(URL, user.getUrl());
        values.put(HTML_URL, user.getHtml_url());
        values.put(FOLLOWERS_URL, user.getFollowers_url());
        values.put(FOLLOWING_URL, user.getFollowing_url());
        values.put(GISTS_URL, user.getGists_url());
        values.put(STARRED_URL, user.getStarred_url());
        values.put(SUBSCRIPTION_URL, user.getSubscription_url());
        values.put(ORGANIZATION_URL, user.getOrganization_url());
        values.put(REPOS_URL, user.getRepos_url());
        values.put(EVENTS_URL, user.getEvents_url());
        values.put(RECEIVED_EVENTS_URL, user.getReceived_events_url());
        values.put(TYPE, user.getType());
        values.put(SITE_ADMIN, user.getSite_admin());

        db.insert(TABLE_USERS, null, values);

        db.close();
    }

    public void deleteUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    List<Users> getAllUsers() {

        List<Users> usersList = new ArrayList<Users>();

        String selectQuery = "SELECT * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Users users = new Users();

                users.setId(cursor.getInt(0));
                users.setLogin(cursor.getString(1));
                users.setNode_id(cursor.getString(2));
                users.setAvatar_url(cursor.getString(3));
                users.setGravatar_url(cursor.getString(4));
                users.setUrl(cursor.getString(5));
                users.setHtml_url(cursor.getString(6));
                users.setFollowers_url(cursor.getString(7));
                users.setFollowing_url(cursor.getString(8));
                users.setGists_url(cursor.getString(9));
                users.setStarred_url(cursor.getString(10));
                users.setSubscription_url(cursor.getString(11));
                users.setOrganization_url(cursor.getString(12));
                users.setRepos_url(cursor.getString(13));
                users.setEvents_url(cursor.getString(14));
                users.setReceived_events_url(cursor.getString(15));
                users.setType(cursor.getString(16));
                users.setSite_admin(Boolean.parseBoolean(cursor.getString(17)));

                usersList.add(users);

            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return usersList;
    }
}