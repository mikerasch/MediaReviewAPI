package com.michael.mediareview.media.Admin;

import com.michael.mediareview.media.Media;
import com.michael.mediareview.media.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private MediaRepository mediaRepository;

    @Autowired
    public AdminService(MediaRepository mediaRepository){
        this.mediaRepository = mediaRepository;
    }

    public void deleteAll() {
        mediaRepository.deleteAll();
    }

    public List<Media> getMedia() {
        return mediaRepository.findAll();
    }
}
