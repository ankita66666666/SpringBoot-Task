package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

    //    Select * from is not added  and will be added automatically
//    Ref: https://www.youtube.com/watch?v=WTEGvLXxyOY
//    @Query("select track from Track track where track.trackName like %?1%")
    List<Track> findByTrackName(String trackName);
;
}

