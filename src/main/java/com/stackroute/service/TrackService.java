
package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {
    //Created abstract method for all.
    public Track saveTrack(Track track) ;


    public Track getTrackById(int id) ;


    public List<Track> getAllTracks();

    public void deleteTrackById(int id) ;
    public void deleteAllTracks();


    public Track updateTrackById(int id, Track track) ;
    public List<Track> getTrackByName(String trackName) ;
}



