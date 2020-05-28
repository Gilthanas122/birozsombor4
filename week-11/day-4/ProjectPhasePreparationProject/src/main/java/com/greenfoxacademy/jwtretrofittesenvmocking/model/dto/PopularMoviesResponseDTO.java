package com.greenfoxacademy.jwtretrofittesenvmocking.model.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopularMoviesResponseDTO {

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
  public List<ResultDTO> results = null;

  public PopularMoviesResponseDTO() {
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

  public List<ResultDTO> getResults() {
    return results;
  }

  public void setResults(List<ResultDTO> results) {
    this.results = results;
  }
}