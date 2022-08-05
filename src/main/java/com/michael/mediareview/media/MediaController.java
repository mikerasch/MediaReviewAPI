package com.michael.mediareview.media;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Media> getMedia(){
        return mediaService.getMedia();
    }

    @PostMapping
    public void registerNewMedia(@RequestBody Media media){
        mediaService.addNewMedia(media);
    }

    @DeleteMapping(path = "{mediaId}")
    public void deleteStudent(@PathVariable("mediaId") Long mediaId){
        mediaService.deleteMedia(mediaId);
    }

    @PutMapping(path = "{mediaId}")
    public void updateMedia(@PathVariable("mediaId") long mediaId, @RequestParam(required = false) String mediaName, @RequestParam(required = false)  String urlImageName, @RequestParam(required = false) Integer rate, @RequestParam(required = false) String rateDescription){
        mediaService.updateMedia(mediaId,mediaName,urlImageName,rate,rateDescription);
    }
}
