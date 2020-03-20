package sharpie;

import static org.junit.Assert.*;

import org.junit.Test;

public class SharpieTest {
  Sharpie sharpie;
  SharpieSet sharpieSet;

  @Test
  public void createASharpie_WithDefaultValues_ReturnValidDefaultInkAmount() {
    sharpie = new Sharpie("red", 2.8f);
    assertEquals(100, sharpie.inkAmount, 0.0f);
  }

  @Test
  public void createASharpie_WithDefaultValues_ReturnValidDefaultColor() {
    sharpie = new Sharpie("red", 2.8f);
    assertEquals("red", sharpie.color);
  }

  @Test
  public void createASharpie_WithDefaultValues_ReturnValidDefaultWidth() {
    sharpie = new Sharpie("red", 2.8f);
    assertEquals(2.8f, sharpie.width, 0.0f);
  }

  @Test
  public void useSharpie_WithDefaultValues_ReturnValidInkAmountAfterUsing() {
    sharpie = new Sharpie("red", 2.8f);
    for (int i = 0; i < 5; i++) {
      sharpie.use();
    }
    assertEquals(95, sharpie.inkAmount, 0.0f);
  }

  @Test
  public void countUsableSharpies_With5Sharpie_ReturnValidUsableCount() {
    sharpieSet = new SharpieSet();
    for (int i = 0; i < 5; i++) {
      sharpieSet.setOfSharpies.add(new Sharpie("red", 2.8f));
    }
    sharpieSet.setOfSharpies.get(0).inkAmount = 0;
    sharpieSet.setOfSharpies.get(1).inkAmount = 0;
    sharpieSet.setOfSharpies.get(2).inkAmount = 0;

    assertEquals(2, sharpieSet.countUsable());
  }

  @Test
  public void removeUnusableSharpies_With5Sharpie_ReturnValidSize() {
    sharpieSet = new SharpieSet();
    for (int i = 0; i < 5; i++) {
      sharpieSet.setOfSharpies.add(new Sharpie("red", 2.8f));
    }
    sharpieSet.setOfSharpies.get(0).inkAmount = 0;
    sharpieSet.setOfSharpies.get(1).inkAmount = 0;
    sharpieSet.setOfSharpies.get(2).inkAmount = 0;
    sharpieSet.removeTrash();
    assertEquals(2, sharpieSet.setOfSharpies.size());
  }


}