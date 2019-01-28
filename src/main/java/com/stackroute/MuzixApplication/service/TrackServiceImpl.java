package com.stackroute.MuzixApplication.service;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackNotFoundException;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService
{
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException
    {
        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");

        }
        Track savedTrack= (Track) trackRepository.save(track);
        if(savedTrack==null)
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }


    @Override
    public List<Track> getAllTracks()
    {
        return trackRepository.findAll();

    }
    @Override
    public boolean deleteTrack(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id))
    {
        throw new TrackNotFoundException("track is not in the database");
    }
        trackRepository.deleteById(id);
        return true;
    }

     @Override

    public Track updateTrack(Track track)
    {
        return track;
    }
    @Override
    public Track trackFindByName(String name) {
        System.out.println(trackRepository.findByName(name));
        return trackRepository.findByName(name);
    }

}
