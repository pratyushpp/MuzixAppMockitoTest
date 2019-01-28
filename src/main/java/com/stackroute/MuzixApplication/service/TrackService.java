package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService
{
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

    public boolean deleteTrack(int id) throws TrackNotFoundException;

    public Track updateTrack(Track track) throws TrackAlreadyExistsException;
    public Track trackFindByName(String name);
}