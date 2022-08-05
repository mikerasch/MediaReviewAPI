package com.michael.mediareview.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if(media.getRate() < 0 || media.getRate() > 10){
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
}
