package org.example.moviereview.repository;

import org.example.moviereview.entity.Member;
import org.example.moviereview.entity.Movie;
import org.example.moviereview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertReview() {
        IntStream.rangeClosed(1, 200).forEach(i -> {
            Long mno = (long)(Math.random()*100) + 1;

            Long mid = (long)(Math.random()*100) + 1;

            Member member = Member.builder()
                    .mid(mid)
                    .build();

            Movie movie = Movie.builder()
                    .mno(mno)
                    .build();

            int grade = (int)(Math.random()*5) + 1;

            Review review = Review.builder()
                    .member(member)
                    .movie(movie)
                    .grade(grade)
                    .text("영화 리뷰 텍스트 " + i)
                    .build();

            reviewRepository.save(review);
        });
    }

    @Test
    public void testGetMovieReviews(){
        Movie movie = Movie.builder()
                .mno(91L)
                .build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(review -> {
            System.out.print(review.getReviewnum() + "\t");
            System.out.print(review.getGrade() + "\t");
            System.out.print(review.getText() + "\t");
            System.out.print(review.getMember().getEmail() + "\t");
            System.out.println("-----------------------------------");
        });
    }
}
