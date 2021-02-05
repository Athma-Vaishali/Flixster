package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;
    boolean adult;
    String release_date;
    int movie_id;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath=jsonObject.getString("backdrop_path");
        posterPath=jsonObject.getString("poster_path");
        title=jsonObject.getString("title");
        overview=jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        adult = jsonObject.getBoolean("adult");
        release_date = jsonObject.getString("release_date");
        movie_id=jsonObject.getInt("id");
    }

    public Movie(){}

    public int getMovie_id() {
        return movie_id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public boolean isAdult() {
        return adult;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getTitle() {
        return title;
    }



    public String getOverview() {
        return overview;
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies= new ArrayList<>();
        for(int i=0;i<movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }
}
