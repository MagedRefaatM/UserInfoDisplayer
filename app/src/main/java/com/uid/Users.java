package com.uid;

class Users {

    private String login;
    private int id;
    private String node_id;
    private String avatar_url;
    private String gravatar_url;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscription_url;
    private String organization_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;

    ////////////////GETERS////////////


    String getLogin(){ return login; }
    int getId(){ return id; }
    String getNode_id(){ return node_id; }
    String getAvatar_url(){ return avatar_url; }
    String getGravatar_url(){ return gravatar_url; }
    String getUrl(){ return url; }
    String getHtml_url(){ return html_url; }
    String getFollowers_url(){ return followers_url; }
    String getFollowing_url(){ return following_url; }
    String getGists_url(){ return gists_url; }
    String getStarred_url(){ return starred_url; }
    String getSubscription_url(){ return subscription_url; }
    String getOrganization_url(){ return organization_url; }
    String getRepos_url(){ return repos_url; }
    String getEvents_url(){ return events_url; }
    String getReceived_events_url(){ return received_events_url; }
    String getType(){ return type; }
    boolean getSite_admin(){ return site_admin; }

    ////////////SETERS///////////////

    void setLogin(java.lang.String login) { this.login = login; }
    void setId(int id) { this.id = id; }
    void setNode_id(String node_id) { this.node_id = node_id; }
    void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url; }
    void setGravatar_url(String gravatar_url) { this.gravatar_url = gravatar_url; }
    void setUrl(String url) { this.url = url; }
    void setHtml_url(String html_url) { this.html_url = html_url; }
    void setFollowers_url(String followers_url) { this.followers_url = followers_url; }
    void setFollowing_url(String following_url) { this.following_url = following_url; }
    void setGists_url(String gists_url) { this.gists_url = gists_url; }
    void setStarred_url(String starred_url) { this.starred_url = starred_url; }
    void setSubscription_url(String subscription_url) { this.subscription_url = subscription_url; }
    void setOrganization_url(String organization_url) { this.organization_url = organization_url; }
    void setRepos_url(String repos_url) { this.repos_url = repos_url; }
    void setEvents_url(String events_url) { this.events_url = events_url; }
    void setReceived_events_url(String received_events_url) { this.received_events_url = received_events_url; }
    void setType(String type) { this.type = type; }
    void setSite_admin(boolean site_admin) { this.site_admin = site_admin; }
}