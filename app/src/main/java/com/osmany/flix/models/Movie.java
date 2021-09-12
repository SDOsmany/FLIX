package com.osmany.flix.models;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String backdropPath;
    String posterPath;
    String title ;
    String overview;
    double rating;

    /**
     The Movie Constructor takes the response jsonObject

     This jsonObject is then used to get the values for the

     posterPath - which is where we will be getting the poster image from
     title - which is the title of the movie
     overview - a small overview of what the movie is about
     */

    //Empty constructor needed for the Parceler
    public  Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");

    }
        //hello movie
    /**
     *
     * @param movieJsonArray the array of movies from the api response
     *                       this array will be the results array which contains all the movies
     * @return
     * @throws JSONException
     */
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0;i < movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
