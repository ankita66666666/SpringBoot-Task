package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import exceptions.TrackAlreadyExistExceptions;
import exceptions.TrackNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;




    @Service
    @Qualifier("dummy")
    public class TrackServiceDummyImpl implements TrackService{
        private TrackRepository trackRepository;
        @Autowired
        public TrackServiceDummyImpl(TrackRepository trackRepository) {
            this.trackRepository = trackRepository;
        }

        @Override
        public Track getTrackById(int id) throws TrackAlreadyExistExceptions {
            return null;
        }

        @Override
        public List<Track> getAllTracks() {
            return null;
        }

        @Override
        public Track saveTrack(Track track) throws TrackAlreadyExistExceptions, TrackNotFoundExceptions {
            return null;
        }

        @Override
        public Track deleteTrackById(int id) throws TrackNotFoundExceptions {
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
            return null;
        }

        @Override
        public List<Track> getAllTrack() {
            return null;
        }

        @Override
        public List<Track> getTrackByName(String name) {
            return null;
        }
    }

