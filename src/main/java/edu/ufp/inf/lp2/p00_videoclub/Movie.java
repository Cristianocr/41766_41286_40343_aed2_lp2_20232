package edu.ufp.inf.lp2.p00_videoclub;

import java.util.ArrayList;
import java.util.List;

public class Movie {

  private String Title;

  private int year;

    /**
    * 
    *
   */
  private ArrayList<Actor> actors;
    /**
    * 
    *
   */
  private ArrayList<Genre> genres;

  public Genre addGenre(Genre g) {
  return null;
  }

  public Genre deleteGenre(Genre g) {
  return null;
  }

  public ArrayList<Genre> listGenres() {
  return null;
  }

  public Actor addActor(Actor a) {
  return null;
  }

  public Actor deleteActor(Actor a) {
  return null;
  }

  public ArrayList<Actor> listActors() {
  return null;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}