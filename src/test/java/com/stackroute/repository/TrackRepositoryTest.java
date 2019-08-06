package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;
    @Before
    public void setUp()
    {
        track = new Track();
        track.setId(10);
        track.setTrackName("Ankita");
        track.setComments("Song1");
//            track.setTrackId(11);
//            track.setTrackName("Johnson");
//            track.setComments("test2");
    }
    @After
    public void tearDown(){
        trackRepository.deleteAll();
    }
    @Test
    public void givenTrackIdShouldFetchTheRespectiveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(10,fetchTrack.getId());
    }
    @Test
    public void GivenTrackIdShouldShowSaveTrackFailure(){
        Track testTrack = new Track(10,"arun","hi");
        trackRepository.save(testTrack);
        Track fetchTrack= trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testTrack,fetchTrack);
    }
    //
    @Test
    public void testShouldReturnAllTracks() {
        Track track1 = new Track(12,"kabirsingh","comments for kabirsingh");
        Track track2 = new Track(13,"rani","comments for rani");
        trackRepository.save(track1);
        trackRepository.save(track2);
        List<Track> testTracks= new ArrayList<>();
        testTracks.add(track1);
        testTracks.add(track2);
        List<Track> outputList = trackRepository.findAll();
        Assert.assertEquals(testTracks,outputList);
    }}