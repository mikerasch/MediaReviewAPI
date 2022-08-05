package com.michael.mediareview.media;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media,Long> {
    public Optional<Media> findMediaByMediaName(String mediaName);
}
