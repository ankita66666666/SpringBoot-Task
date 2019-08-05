package seeddata;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import exceptions.TrackAlreadyExistExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TrackServiceSeedDataCommandLineRunner implements CommandLineRunner {
    TrackService trackService;

    @Autowired
    public TrackServiceSeedDataCommandLineRunner(@Qualifier("dummy") TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        //        Create seed data objects
        Track track1 = new Track(4, "Track 4", "Comment from CommandLineRunner");
        Track track2 = new Track(5, "Track 5", "Comment from CommandLineRunner");
        Track track3 = new Track(6, "Track 6", "Comment from CommandLineRunner");
        try {
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);
        } catch (TrackAlreadyExistExceptions trackAlreadyExistExceptions) {
            trackAlreadyExistExceptions.printStackTrace();
        }
    }
}

