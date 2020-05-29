package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.Actor;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.call.ActorDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class ActorServiceImpl implements ActorService {

  private ActorRepository actorRepository;
  private Retrofit retrofit;
  private String BASE_URL = "https://api.themoviedb.org";
  private ApiInterface apiInterface;
  private String API_KEY = System.getenv("API_KEY");

  @Autowired
  public ActorServiceImpl(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
    this.retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    this.apiInterface = retrofit.create(ApiInterface.class);
  }

  @Override
  public void fetchActorById(Long id) {
    Call<ActorDTO> call = apiInterface.getActorById(id, API_KEY, "en-US");
    call.enqueue(new Callback<ActorDTO>() {
      @Override
      public void onResponse(Call<ActorDTO> call, Response<ActorDTO> response) {
        Actor fetchedActor = convertActorDTOToActor(response.body());
        saveActor(fetchedActor);
      }

      @Override
      public void onFailure(Call<ActorDTO> call, Throwable t) {

      }
    });
  }

  @Override
  public void saveActor(Actor actor) {
    actorRepository.save(actor);
  }

  @Override
  public Actor convertActorDTOToActor(ActorDTO actorDTO) {
    return new Actor(actorDTO);
  }

  @Override
  public boolean isActorStoredAlready(Long id) {
    if (actorRepository.findActorById(id).isPresent()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Actor getActorById(Long id) {
    return actorRepository.findById(id).orElse(null);
  }
}
