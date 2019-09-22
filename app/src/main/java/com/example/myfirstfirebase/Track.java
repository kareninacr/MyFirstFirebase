package com.example.myfirstfirebase;

public class Track {
    private String trackId;
    private String trackName;
    private int trackRating;

    public Track() {

    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public int getTrackRating() {
        return trackRating;
    }

    public Track(String trackId, String trackName, int trackRating) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
    }
}
