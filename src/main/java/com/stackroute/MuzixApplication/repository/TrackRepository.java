package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer>


{   @Query
    public Track findByName(String name);
}
