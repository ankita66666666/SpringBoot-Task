

package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistExceptions;
import com.stackroute.exceptions.TrackNotFoundExceptions;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Primary annotation is used to give higher preference to a bean when there are multiple beans of the same type.
//@Primary
//In Spring, @Qualifier means, which bean is qualify to autowired on a field.
@Profile("main")
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //
    @Override
    public Track getTrackById(int id) throws TrackAlreadyExistExceptions {

        if(trackRepository.existsById(id)){
            throw new TrackAlreadyExistExceptions("track is already added before");
        }
        return trackRepository.findById(id).get();
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistExceptions {
        if(trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistExceptions("track is not present");
        }
        Track savedTrack = trackRepository.save(track);
        if (savedTrack==null) {
            throw new TrackAlreadyExistExceptions("Track is null");
        }
        return trackRepository.save(track);

    }

    // method to delete track with particular id
    @Override
    public Track deleteTrackById(int id) {
        Optional<Track> value = trackRepository.findById(id);
        if (value.isPresent()) {
            trackRepository.deleteById(id);
            return value.get();
        } else
            return null;
    }

    @Override
    public void deleteAllTracks() {

    }

    @Override
    public Track updateTrackById(int id, Track track) throws TrackNotFoundExceptions {
        return null;
    }

    @Override
    public Track updateTrack(int id, Track track) {
        //        delete the track
        trackRepository.deleteById(id);
        // edit the track and save it
        Track updateTrack = trackRepository.save(track);
        return updateTrack;
    }

    //method to find all tracks
    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }
    //method to get track by their name
    @Override
    public List<Track> getTrackByName(String name) {
        return trackRepository.findByTrackName(name);
    }

}