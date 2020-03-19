package apples;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppleTest {

  @Test
  public void getApple_WithNothing_ReturnsApple() {
    Apple apple = new Apple();
    assertEquals("apple", apple.getApple());
  }
}