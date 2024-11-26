package org.example.moviereview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Movie extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    private String title;
}
