
package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import exceptions.TrackAlreadyExistExceptions;
import exceptions.TrackNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping(value = "api/v1")
public class TrackController {

    public TrackService trackService;


    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
//using try block of code
 // Catch block for catching exception here

        try {
            Track savedTrack = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
        } catch (TrackAlreadyExistExceptions ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }


    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        /**Try this block of code else catch the exception*/
        try {
            Track retrieveTrackById = trackService.getTrackById(id);
            responseEntity = new ResponseEntity<>(retrieveTrackById, HttpStatus.FOUND);
        } catch (TrackNotFoundExceptions ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        /**Try this block of code else catch the exception*/
        try {
            List<Track> retrieveTracks = trackService.getAllTracks();
            responseEntity = new ResponseEntity<>(retrieveTracks, HttpStatus.FOUND);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;

        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        } catch (TrackNotFoundExceptions ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteAllTracks() {
        ResponseEntity responseEntity;
        /**Try this block of code else catch the exception*/
        try {
            trackService.deleteAllTracks();
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>("No tracks to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> UpdateTrackById(@PathVariable int id, @RequestBody Track track) {
        ResponseEntity responseEntity;
        /**Try this block of code else catch the exception*/
        try {
            Track updatedTrack = trackService.updateTrackById(id, track);
            return new ResponseEntity<>(updatedTrack, HttpStatus.ACCEPTED);
        } catch (TrackNotFoundExceptions ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("track/search/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName) {
        ResponseEntity responseEntity;
        try {
            List<Track> retrieveTrackByNAme = trackService.getTrackByName(trackName);
            responseEntity = new ResponseEntity<>(retrieveTrackByNAme, HttpStatus.FOUND);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}