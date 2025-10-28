package com.shubham.jobApp.review;

import com.shubham.jobApp.company.Company;
import com.shubham.jobApp.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private CompanyRepository companyRepo;


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean giveReviewToCompany(Long companyId, Review review) {
        Optional<Company> company = companyRepo.findById(companyId);
        if (company.isPresent()) {
            review.setCompany(company.get());
            reviewRepo.save(review);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long comId, Long revId) {

        Optional<Company> company = companyRepo.findById(comId);
        if (company.isEmpty()) {
            return false;
        }

        Optional<Review> review = reviewRepo.findById(revId);
        if (review.isEmpty()) {
            return false;
        }

        if (!review.get().getCompany().getId().equals(comId)) {
            return false;
        }

        reviewRepo.delete(review.get());
        return true;
    }

}
