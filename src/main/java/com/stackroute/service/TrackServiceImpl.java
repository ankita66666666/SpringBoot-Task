


package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;


    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) {
        Track retrieveTrackById = trackRepository.findById(id).get();
        return retrieveTrackById;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }


    @Override
    public void deleteTrackById(int id) {
        trackRepository.deleteById(id);
    }


    @Override
    public void deleteAllTracks() {
        trackRepository.deleteAll();
    }

    @Override
    public Track updateTrackById(int id, Track track) {
        Track getTrack = trackRepository.findById(id).get();
        getTrack.setComments(track.getComments());
        return trackRepository.save(getTrack);
    }

    @Override
    public List<Track> getTrackByName(String trackName) {
        return null;
    }
}