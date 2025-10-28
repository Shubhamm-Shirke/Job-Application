package com.shubham.jobApp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

   @GetMapping("/getAllReviewOfCompany/{id}")
    ResponseEntity<List<Review>>getAllReviewOfCompany(@PathVariable Long id){
       List<Review>reviews = reviewService.getAllReviews(id);
       if (!reviews.isEmpty()) {
           return new ResponseEntity<>(reviews, HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   @PostMapping("/addReviewToCompany/{id}")
    ResponseEntity<String> addReview(@PathVariable Long id , @RequestBody Review review){
       boolean isAdd = reviewService.giveReviewToCompany(id , review);
       if (isAdd) {
           return new ResponseEntity<>("Review added..",HttpStatus.OK);
       }else {
           return new ResponseEntity<>("failed to add review",HttpStatus.BAD_REQUEST);
       }
   }

    @DeleteMapping("/deleteReview/{comid}/{revid}")
    public ResponseEntity<String> deleteReview(
            @PathVariable("comid") Long comId,
            @PathVariable("revid") Long revId) {

        boolean isDeleted = reviewService.deleteReview(comId, revId);

        if (isDeleted) {
            return new ResponseEntity<>("Review deleted..", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete review", HttpStatus.BAD_REQUEST);
        }
    }



}
