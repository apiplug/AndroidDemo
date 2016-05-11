package com.apiplug.androiddemo.models;

/**
 * Film Model
 * @author APIPlug
 * @version v1.0
 *
 */
public class Film {

    //Variables in our Film JSON result from API
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    //Not all fields added from JSON, only necessary ones generated.

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }


}