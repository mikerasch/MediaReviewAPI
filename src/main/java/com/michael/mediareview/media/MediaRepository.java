package com.michael.mediareview.media;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media,Long> {
    Optional<Media> findMediaByMediaName(String mediaName);

    Media findMediaById(long id);
}
