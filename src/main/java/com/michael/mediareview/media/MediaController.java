package com.michael.mediareview.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/media")
public class MediaController {
    private final MediaService mediaService;
    @Autowired
    public MediaController(MediaService mediaService){
        this.mediaService = mediaService;
    }


    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<Media> getMedia(){
        return mediaService.getMedia();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping(path = "{mediaId}")
    public Media getMediaById(@PathVariable("mediaId") Long mediaId){
        return mediaService.getMediaById(mediaId);
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public void registerNewMedia(@RequestBody Media media){
        mediaService.addNewMedia(media);
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping(path = "{mediaId}")
    public void deleteStudent(@PathVariable("mediaId") Long mediaId){
        mediaService.deleteMedia(mediaId);
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping(path = "{mediaId}")
    public void updateMedia(@PathVariable("mediaId") long mediaId, @RequestParam(required = false) String mediaName, @RequestParam(required = false)  String urlImageName, @RequestParam(required = false) Integer rate, @RequestParam(required = false) String rateDescription){
        mediaService.updateMedia(mediaId,mediaName,urlImageName,rate,rateDescription);
    }
}
