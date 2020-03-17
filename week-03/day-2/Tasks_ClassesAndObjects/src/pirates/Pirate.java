package pirates;

public class Pirate {

  enum States{
    ALIVE,
    PASSED_OUT,
    DEAD
  }
  int rumOMeter;
  States state = States.ALIVE;
  boolean hasAParrot;

  public Pirate() {
    this.rumOMeter = 0;
    this.state = state.ALIVE;
  }
  public Pirate(boolean hasAParrot){
    this();
    this.hasAParrot = hasAParrot;
  }

  public void drinkSomeRum() {
    this.rumOMeter++;
    if (rumOMeter > 10){
      die();
    }
  }

  public void howsItGoingMate() {
    if (rumOMeter < 5) {
      System.out.println("Pour me anudder!");
    } else {
      this.state =States.PASSED_OUT;
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
    }
  }

  public void die(){
    this.state = States.DEAD;
    System.out.println("This pirate is dead.");
  }

  public void brawl(Pirate anotherPirate){
    double chance = Math.random();
    if (chance < 0.33){
      die();
    }else if (chance > 0.33 && chance < 0.66){
      anotherPirate.state = States.DEAD;
    }else{
      die();
      anotherPirate.state = States.DEAD;
    }
  }

}
