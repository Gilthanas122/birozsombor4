package exercisetwelve;

public class SWCharacter {
  private String name;
  private String height;
  private String mass;
  private String hairColor;
  private String skinColor;
  private String eyeColor;
  private String birthYear;
  private String gender;

  public String getName() {
    return name;
  }

  public String getHeight() {
    return height;
  }

  public String getMass() {
    return mass;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getGender() {
    return gender;
  }

  public SWCharacter(String name, String height, String mass, String hairColor, String skinColor,
                     String eyeColor, String birthYear, String gender) {
    this.name = name;
    this.height = height;
    this.mass = mass;
    this.hairColor = hairColor;
    this.skinColor = skinColor;
    this.eyeColor = eyeColor;
    this.birthYear = convertAgeForm(birthYear);
    this.gender = gender;
  }

  private String convertAgeForm(String birthYear) {
    if (birthYear.contains("BBY")) {
      birthYear = birthYear.replace("BBY", "");
    }
    if (birthYear.contains(".")) {
      birthYear = birthYear.replace(".", "");
    }
    return birthYear;
  }

  @Override
  public String toString() {
    return this.getName();
  }

  //NEED FOR BEFORE TO THE CLASS CONSTRUCTORS
  /*private String covertNumberFormat(String number) {
    String holder = number;
    if (number.contains(",")) {
      StringBuilder stringBuilder = new StringBuilder(number);
      holder = stringBuilder.delete(number.indexOf(','), number.indexOf(',') + 1).toString();
    } else if (number.contains(".")) {
      holder = number.replace(".", "");
    }
    if (holder.isEmpty()) {
      holder = "unknown";
    }
    return holder;
  }*/
  /*private String convertGender(String gender) {
    if (!gender.equals("male") && !gender.equals("female")) {
      gender = "other";
    }
    return gender;
  }

  /*public String getGroup() {
    if (!this.birthYear.equals("unknown")) {
      if (Integer.valueOf(this.birthYear) < 21) {
        return "below 21";
      } else if (Integer.valueOf(this.birthYear) >= 21 && Integer.valueOf(this.birthYear) < 40) {
        return "between 21 and 40";
      } else if (Integer.valueOf(this.birthYear) >= 40) {
        return "above 40";
      }
    } else {
      return "unknown";
    }
    return null;
  }*/
}
