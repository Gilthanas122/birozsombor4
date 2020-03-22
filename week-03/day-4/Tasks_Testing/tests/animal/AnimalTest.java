package animal;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {
  Animal animal;

  @Test
  public void createAnimal_WithDefaultValues_ReturnsDefaultValues() {
    animal = new Animal();
    assertEquals(100, animal.getHunger() + animal.getThirst());
  }

  @Test
  public void setValues_WithAnotherValues_ReturnsChangedValues() {
    animal = new Animal();
    animal.setHunger(40);
    animal.setThirst(40);
    assertEquals(80, animal.getHunger() + animal.getThirst());
  }

  @Test
  public void eat_WithDefaultValues_ReturnsChangedValueAfterEating() {
    animal = new Animal();
    animal.eat();
    assertEquals(49, animal.getHunger());
  }

  @Test
  public void drink_WithDefaultValues_ReturnsChangedValueAfterDrinking() {
    animal = new Animal();
    animal.drink();
    assertEquals(49, animal.getThirst());
  }

  @Test
  public void play_WithDefaultValues_ReturnsChangedValuesAfterPlaying() {
    animal = new Animal();
    animal.play();
    assertEquals(102, animal.getHunger() + animal.getThirst());
  }
}