 package com.stackroute.MuzixApplication.Seed;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerSeed implements CommandLineRunner {
    private TrackRepository trackRepository;

    public CommandLineRunnerSeed(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
      trackRepository.save(new Track(1,"song2","lyrics abc"));
        trackRepository.save(new Track(2,"song2","lyrics abc"));

        trackRepository.save(new Track(3,"song3","lyrics abc"));

        trackRepository.save(new Track(4,"song4","lyrics abc"));
        trackRepository.save(new Track(5,"song5","lyrics abc"));
        trackRepository.save(new Track(6,"song6","lyrics abc"));
        trackRepository.save(new Track(7,"song7","lyrics abc"));

    }
}
