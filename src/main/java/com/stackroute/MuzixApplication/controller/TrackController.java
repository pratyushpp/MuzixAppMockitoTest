package com.stackroute.MuzixApplication.controller;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackNotFoundException;
import com.stackroute.MuzixApplication.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/")

public class TrackController
{
    private TrackService trackService;

    @Autowired

    public TrackController(TrackService trackService)

    {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?>saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("track")

    public ResponseEntity<?> getAllTracks()

    {

        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);

    }


    @PutMapping("track")

    public ResponseEntity<?> updateTrack(@RequestBody Track track)

    {

        ResponseEntity responseEntity;

        try {

            trackService.updateTrack(track);

            responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.CREATED);

        }

        catch(TrackAlreadyExistsException e)

        {

            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);

        }

        return responseEntity;

    }

    @DeleteMapping("/track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id)throws TrackNotFoundException
    {
        ResponseEntity responseEntity;

        trackService.deleteTrack(id);
        responseEntity= new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
        return responseEntity;
    }



}
