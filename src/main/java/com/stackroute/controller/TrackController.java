package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrackController {
    private TrackService trackService;

    public TrackController() {
    }

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        System.out.println(id);
        Track retrivedTrack = trackService.getTrackById(id);
        return new ResponseEntity<Track>(retrivedTrack, HttpStatus.OK);


    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id) {
        Optional<Track> tracksList = (Optional<Track>) trackService.deleteTrackById(id);
        return new ResponseEntity<>(tracksList, HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrackById(@PathVariable("id") int id) {
        Optional<Track> tracksList = (Optional<Track>) trackService.deleteTrackById(id);
        return new ResponseEntity<>(tracksList, HttpStatus.OK);
    }


    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        List<Track> retrivedTrack = (List<Track>) trackService.getAllTracks();
        return new ResponseEntity<List<Track>>(retrivedTrack, HttpStatus.OK);

    }

    /**
     * Search Track By name.
     * @param trackName Name of the track to search.
     * @return List of tracks
     */
    @GetMapping("tracks/{trackName}")
    public ResponseEntity<?> searchTrackByName(@PathVariable String trackName) {
        return new ResponseEntity<>(trackService.searchByName(trackName), HttpStatus.FOUND);
    }
}



