package com.michael.mediareview.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {
    private MediaRepository mediaRepository;
    @Autowired
    public MediaService(MediaRepository mediaRepository){
        this.mediaRepository = mediaRepository;
    }


    public List<Media> getMedia(){
        return mediaRepository.findAll();
    }

    public void addNewMedia(Media media) {
        Optional<Media> findIfExists = mediaRepository.findMediaByMediaName(media.getMediaName());
        if(findIfExists.isPresent()){
            throw new IllegalStateException("Movie already exists in the database");
        }
        if(media.getRate() < 0 || media.getRate() > 10) {
            throw new IllegalStateException("Rating must be between 0-10 [inclusive]");
        }
        mediaRepository.save(media);
    }

    public void deleteMedia(Long mediaId) {
        if(!mediaRepository.existsById(mediaId)){
            throw new IllegalStateException("media id does not exist to delete");
        }
        mediaRepository.deleteById(mediaId);
    }

    // To-Do: Make sure when they are updating name, that it does not already appear in the database.
    @Transactional
    public void updateMedia(long mediaId, String mediaName, String urlImageName, Integer rate, String rateDescription) {
        Media media = mediaRepository.findMediaById(mediaId);
        if(mediaName != null && mediaName.length() > 0){
            media.setMediaName(mediaName);
        }
        if(urlImageName != null && urlImageName.length() > 0){
            media.setUrlImageName(urlImageName);
        }
        if(rate != null){
            if(rate < 0 || rate > 10){
                throw new IllegalStateException("Updated rate must be between 0 and 10 [inclusive]");
            }
            media.setRate(rate);
        }
        if(rateDescription != null && rateDescription.length() > 0){
            media.setRateDescription(rateDescription);
        }
    }

    public Media getMediaById(Long mediaId) {
        if(mediaRepository.existsById(mediaId)){
            return mediaRepository.findMediaById(mediaId);
        }
        else{
            throw new IllegalStateException("ID does not exist in database!");
        }
    }
}
