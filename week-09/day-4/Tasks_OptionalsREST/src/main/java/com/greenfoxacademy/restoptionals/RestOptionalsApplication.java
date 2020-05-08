package com.greenfoxacademy.restoptionals;

import com.greenfoxacademy.restoptionals.model.Cargo;
import com.greenfoxacademy.restoptionals.model.Food;
import com.greenfoxacademy.restoptionals.model.Song;
import com.greenfoxacademy.restoptionals.repository.CargoRepository;
import com.greenfoxacademy.restoptionals.repository.DraxRepository;
import com.greenfoxacademy.restoptionals.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestOptionalsApplication implements CommandLineRunner {

  private CargoRepository cargoRepository;
  private DraxRepository draxRepository;
  private SongRepository songRepository;

  @Autowired
  public RestOptionalsApplication(CargoRepository cargoRepository, DraxRepository draxRepository, SongRepository songRepository) {
    this.cargoRepository = cargoRepository;
    this.draxRepository = draxRepository;
    this.songRepository = songRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RestOptionalsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    cargoRepository.save(new Cargo());
    draxRepository.save(new Food("TestFood", 666, 666));
    songRepository.save(new Song("John Lennon", "Imagine", "world-music", 1971, 8.1f));
    songRepository.save(new Song("Metallica", "Ride the lightning", "metal", 1984, 7.5f));
    songRepository.save(new Song("Metallica", "Master of puppets", "metal", 1986, 7.8f));
    songRepository.save(new Song("Nirvana", "Smells like teen spirit", "grunge", 1991, 8.5f));
    songRepository.save(new Song("Nirvana", "In Bloom", "grunge", 1991, 8.3f));
    songRepository.save(new Song("Deafheaven", "Sunbather", "metal", 2013, 10f));
  }
}
