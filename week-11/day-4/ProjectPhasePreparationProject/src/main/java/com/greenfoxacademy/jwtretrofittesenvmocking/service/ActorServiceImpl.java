package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.ActorDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.ActorDTO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.retro.Actor;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.ActorRepository;
import java.util.stream.Collectors;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
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
    Call<Actor> call = apiInterface.getActorById(id, API_KEY, "en-US");
    call.enqueue(new Callback<Actor>() {
      @Override
      public void onResponse(Call<Actor> call, Response<Actor> response) {
        ActorDAO fetchedActor = convertActorToActorDAO(response.body());
        saveActor(fetchedActor);
      }

      @Override
      public void onFailure(Call<Actor> call, Throwable t) {

      }
    });
  }

  @Override
  public void saveActor(ActorDAO actor) {
    actorRepository.save(actor);
  }

  private ActorDAO convertActorToActorDAO(Actor actor) {
    ActorDAO actorDAO = new ActorDAO();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(Actor.class, ActorDAO.class)
        .setPostConverter(new Converter<Actor, ActorDAO>() {
          @Override
          public ActorDAO convert(MappingContext<Actor, ActorDAO> context) {
            context.getDestination().setAlsoKnownAs(
                context.getSource().getAlsoKnownAs().stream()
                    .collect(Collectors.joining(", "))
            );
            context.getDestination().setRemoteDatabaseId(
                context.getSource().getId()
            );
            return context.getDestination();
          }
        }).map(actor, actorDAO);
    return actorDAO;
  }

  @Override
  public ActorDTO convertActorDAOtoDTO(ActorDAO actorDAO){
    ActorDTO actorDTO = new ActorDTO();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(actorDAO, actorDTO);
    return actorDTO;
  }

  @Override
  public ActorDTO convertActorDTOToDAO(ActorDAO actorDAO){
    ActorDTO actorDTO = new ActorDTO();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(actorDAO, actorDTO);
    return actorDTO;
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
  public ActorDAO getActorById(Long id) {
    return actorRepository.findById(id).orElse(null);
  }
}
