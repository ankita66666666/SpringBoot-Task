package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    //    Select * from is not added  and will be added automatically
//    Ref: https://www.youtube.com/watch?v=WTEGvLXxyOY
    @Query("select track from Track track where track.name =%?1%")
    List<Track> searchByName(String Name);
}

