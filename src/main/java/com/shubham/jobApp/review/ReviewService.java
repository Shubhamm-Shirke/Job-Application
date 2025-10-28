package com.shubham.jobApp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean giveReviewToCompany(Long companyId , Review review);

    boolean deleteReview(Long comId, Long revId);
}
