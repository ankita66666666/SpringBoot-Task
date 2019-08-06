package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistExceptions;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-mongo.properties")
public class TrackServiceApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    //   TrackService to perform database operations.
    private TrackService trackService;

    @Autowired
    public TrackServiceApplicationListener( TrackService trackService) {
        this.trackService = trackService;
    }

    @Autowired
    private Environment environment;

    @Value("${id}")
    int id;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        Create seed data objects
           /* Track track1 = new Track(1, "Track 1", "Comment 1");
            Track track2 = new Track(2, "Track 2", "Comment 2");
            Track track3 = new Track(3, "Track 3", "Comment 3");*/
        try {
            trackService.saveTrack(new Track(id, environment.getProperty("trackName"), environment.getProperty("comments")));
        } catch (TrackAlreadyExistExceptions  trackAlreadyExistExceptions) {
            trackAlreadyExistExceptions.printStackTrace();
        }
    }
}

