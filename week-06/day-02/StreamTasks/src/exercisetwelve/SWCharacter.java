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

  public String getHairColor() {
    return hairColor;
  }

  public String getSkinColor() {
    return skinColor;
  }

  public String getEyeColor() {
    return eyeColor;
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
    this.height = covertNumberFormat(height);
    this.mass = covertNumberFormat(mass);
    this.hairColor = hairColor;
    this.skinColor = skinColor;
    this.eyeColor = eyeColor;
    this.birthYear = birthYear;
    this.gender = gender;
  }

  private String covertNumberFormat(String number) {
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
  }
}
