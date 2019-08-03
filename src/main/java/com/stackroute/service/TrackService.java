package com.stackroute.service;

import com.stackroute.domain.Track;
import exceptions.TrackAlreadyExistExceptions;
import exceptions.TrackNotFoundExceptions;

import java.util.List;

public interface TrackService {


//      AbstractMethod to save a track

    public Track saveTrack(Track track) throws TrackAlreadyExistExceptions;


//      AbstractMethod to get a track by Id

    public Track getTrackById(int id) throws TrackNotFoundExceptions;


//      AbstractMethod to get all tracks

    public List<Track> getAllTracks();


//      AbstractMethod to delete track by Id

    public void deleteTrackById(int id) throws TrackNotFoundExceptions;


//     AbstractMethod to delete all tracks

    public void deleteAllTracks();


//      AbstractMethod to update comments of a track by its id

    public Track updateTrackById(int id, Track track) throws TrackNotFoundExceptions;


//      AbstractMethod to get track by Name

    public List<Track> getTrackByName(String trackName) throws TrackNotFoundExceptions;

}
