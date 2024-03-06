package com.pizzeria.service;

import java.util.List;

import com.pizzeria.Exception.ReviewException;
import com.pizzeria.model.Review;
import com.pizzeria.model.User;
import com.pizzeria.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
	public Review updateReview(Long reviewId, ReviewRequest updatedReview) throws ReviewException;

}
