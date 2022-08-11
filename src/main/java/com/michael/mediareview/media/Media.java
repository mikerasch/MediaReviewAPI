package com.michael.mediareview.media;

import javax.persistence.*;

@Entity(name = "media")
@Table
public class Media {
    @Id
    @SequenceGenerator(
            name = "media_sequence",
            sequenceName = "media_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "media_sequence"
    )
    private Long id;

    @Column(
            name = "mediaName"
    )
    private String mediaName;

    @Column(
            name = "urlImageName"
    )
    private String urlImageName;

    @Column(
            name = "rate"
    )
    private int rate;

    @Column(
            name = "rateDescription"
    )
    private String rateDescription;
    public Media(){

    }
    public Media(Long id, String mediaName, String urlImageName, int rate, String rateDescription){
        this.id = id;
        this.mediaName = mediaName;
        this.urlImageName = urlImageName;
        this.rate = rate;
        this.rateDescription = rateDescription;
    }

    public Media(String mediaName, String urlImageName, int rate, String rateDescription){
        this.mediaName = mediaName;
        this.urlImageName = urlImageName;
        this.rate = rate;
        this.rateDescription = rateDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaName(){
        return mediaName;
    }

    public void setMediaName(String mediaName){
        this.mediaName = mediaName;
    }
    public String getUrlImageName() {
        return urlImageName;
    }

    public void setUrlImageName(String urlImageName) {
        this.urlImageName = urlImageName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRateDescription() {
        return rateDescription;
    }

    public void setRateDescription(String rateDescription) {
        this.rateDescription = rateDescription;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", urlImageName='" + urlImageName + '\'' +
                ", rate=" + rate +
                ", rateDescription='" + rateDescription + '\'' +
                '}';
    }
}
