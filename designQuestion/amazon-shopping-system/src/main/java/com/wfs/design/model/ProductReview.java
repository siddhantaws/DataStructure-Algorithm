package com.wfs.design.model;

public class ProductReview {
  private int rating;
  private String review;

  private Member reviewer;

  public ProductReview(int rating, String review, Member reviewer) {
    this.rating = rating;
    this.review = review;
    this.reviewer = reviewer;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public Member getReviewer() {
    return reviewer;
  }

  public void setReviewer(Member reviewer) {
    this.reviewer = reviewer;
  }
}