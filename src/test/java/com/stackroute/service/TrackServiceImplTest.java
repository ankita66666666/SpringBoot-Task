
package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistExceptions;
import com.stackroute.exceptions.TrackNotFoundExceptions;
import com.stackroute.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceImplTest {
    Track track;
    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;
    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list = null;

    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackName("Ankita");
        track.setComments("hi");
        track.setId(10);
        list = new ArrayList<>();
        list.add(track);
    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistExceptions {
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track, savedTrack);
        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository, times(2)).save(track);
    }

    @Test(expected = TrackAlreadyExistExceptions.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistExceptions, TrackNotFoundExceptions {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        Assert.assertEquals(track, savedTrack);
      /*doThrow(new UserAlreadyExistExceptions()).when(userRepository).findById(eq(101));
      userService.saveUser(user);*/
    }

    @Test
    public void getAllTracks() {
        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list, tracklist);
    }
//    @Test
//    public void
}
