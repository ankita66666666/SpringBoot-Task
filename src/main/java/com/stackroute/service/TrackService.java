
package com.stackroute.service;

import com.stackroute.domain.Track;
import exceptions.TrackAlreadyExistExceptions;
import exceptions.TrackNotFoundExceptions;

import java.util.List;

public interface TrackService {
    //Created abstract method
    public Track saveTrack(Track track) throws TrackAlreadyExistExceptions;


    public Track getTrackById(int id) throws TrackNotFoundExceptions;


    public List<Track> getAllTracks();

    public void deleteTrackById(int id) throws TrackNotFoundExceptions;

    public void deleteAllTracks();


    public Track updateTrackById(int id, Track track) throws TrackNotFoundExceptions;

    public List<Track> getTrackByName(String trackName) throws TrackNotFoundExceptions;

}



