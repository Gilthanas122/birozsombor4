package com.greenfoxacademy.jwtretrofittesenvmocking.model.retro;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopularMoviesQuery {

  @SerializedName("page")
  @Expose
  public Integer page;
  @SerializedName("total_results")
  @Expose
  public Integer totalResults;
  @SerializedName("total_pages")
  @Expose
  public Integer totalPages;
  @SerializedName("results")
  @Expose
  public List<PopularMovie> results = null;

  public PopularMoviesQuery() {
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public List<PopularMovie> getResults() {
    return results;
  }

  public void setResults(List<PopularMovie> results) {
    this.results = results;
  }
}