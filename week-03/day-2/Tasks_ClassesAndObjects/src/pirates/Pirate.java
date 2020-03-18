package pirates;

public class Pirate {

  enum States {
    ALIVE,
    PASSED_OUT,
    DEAD
  }

  int rumOMeter;
  States state;
  boolean hasAParrot;
  boolean consumedRum;

  public Pirate() {
    this.rumOMeter = 0;
    this.state = state.ALIVE;
    this.hasAParrot = false;
    this.consumedRum = false;
    haveALife();
  }

  public Pirate(boolean hasAParrot) {
    this();
    this.hasAParrot = hasAParrot;
  }

  public void haveALife(){
    int wantToDrinkToday = (int) (Math.random()*2);
    int howMuch = (int) (Math.random()*10);
    if (wantToDrinkToday == 1){
      for (int i = 0; i < howMuch; i++) {
        this.drinkSomeRum();
      }
    }
  }

  public void drinkSomeRum() {
    this.rumOMeter++;
    this.consumedRum = true;
    if (rumOMeter > 10) {
      die();
    } else if (rumOMeter >= 5 && rumOMeter <= 10) {
      this.state = state.PASSED_OUT;
    }
  }

  public void howsItGoingMate() {
    if (rumOMeter < 5) {
      System.out.println("Pour me anudder!");
    } else {
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
    }
  }

  public void die() {
    this.state = States.DEAD;
  }

  public void brawl(Pirate anotherPirate) {
    if (this.state == States.ALIVE && anotherPirate.state == States.ALIVE) {
      double chance = Math.random();
      if (chance < 0.33) {
        die();
        System.out.println("This pirate loosed.");
      } else if (chance > 0.33 && chance < 0.66) {
        anotherPirate.state = States.DEAD;
        System.out.println("Another pirate is dead");
      } else {
        this.state = States.PASSED_OUT;
        anotherPirate.state = States.PASSED_OUT;
        System.out.println("They are both passed out!");
      }
    } else if (this.state == States.ALIVE && (anotherPirate.state == States.PASSED_OUT || anotherPirate.state == States.DEAD)){
      anotherPirate.state = States.DEAD;
      System.out.println("Another pirate wasn't prepared for this fight.");
    } else if (anotherPirate.state == States.ALIVE && (anotherPirate.state == States.PASSED_OUT || anotherPirate.state == States.DEAD)){
      this.state = States.DEAD;
      System.out.println("This pirate wasn't prepared for this fight.");
    }else{
      this.state = States.DEAD;
      anotherPirate.state = States.DEAD;
      System.out.println("A mistery... They have just died!");
    }
  }

}
