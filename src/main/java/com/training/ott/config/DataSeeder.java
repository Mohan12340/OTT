package com.training.ott.config;

import com.training.ott.model.Movie;
import com.training.ott.model.Plan;
import com.training.ott.model.User;
import com.training.ott.repository.MovieRepository;
import com.training.ott.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public DataSeeder(UserRepository userRepository,
                      MovieRepository movieRepository) {

        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {

            userRepository.save(new User(
                    null,
                    "Darshan",
                    "darshan@gmail.com",
                    Plan.PREMIUM));

            userRepository.save(new User(
                    null,
                    "Rahul",
                    "rahul@gmail.com",
                    Plan.BASIC));
        }

        if (movieRepository.count() == 0) {

            movieRepository.save(new Movie(
                    null,
                    "Avengers Endgame",
                    "Action",
                    Plan.PREMIUM));

            movieRepository.save(new Movie(
                    null,
                    "KGF Chapter 2",
                    "Action",
                    Plan.BASIC));

            movieRepository.save(new Movie(
                    null,
                    "Charlie 777",
                    "Drama",
                    Plan.FREE));
        }

        System.out.println("Sample OTT data loaded...");
    }
}
