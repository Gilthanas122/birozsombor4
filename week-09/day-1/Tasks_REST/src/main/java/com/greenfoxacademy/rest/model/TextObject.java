package com.greenfoxacademy.rest.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextObject {

  private String text;
  private String lang;
  private List<Character> vowels;

  public TextObject(String text, String lang) {
    this.text = text;
    this.lang = lang;
    this.vowels = new ArrayList<>();
    initAllVowels();
  }

  private void initAllVowels() {
    vowels.add('a');
    vowels.add('á');
    vowels.add('e');
    vowels.add('é');
    vowels.add('i');
    vowels.add('í');
    vowels.add('o');
    vowels.add('ó');
    vowels.add('ö');
    vowels.add('ő');
    vowels.add('u');
    vowels.add('ú');
    vowels.add('ü');
    vowels.add('ű');
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public void translate() {
    switch (this.lang) {
      case "hu":
        this.lang = "teve";
        this.setTextToCamelized();
        break;
      case "eng":
        this.lang = "gibberish";
        this.setTextToGibberish();
        break;
      default:
        break;
    }
  }

  private void setTextToCamelized() {
    String cammelizedText = "";
    for (char c : this.text.toCharArray()) {
      if (vowels.contains(Character.toLowerCase(c))) {
        cammelizedText += c + "v" + Character.toLowerCase(c);
        continue;
      }
      cammelizedText += c;
    }
    this.text = cammelizedText;
  }

  public void setTextToGibberish() {
    String gibberishText = "";
    boolean isPreviousVowel = false;
    for (char c : this.text.toCharArray()) {
      if (vowels.contains(Character.toLowerCase(c)) && isPreviousVowel == false) {
        gibberishText += "idig" + c;
        isPreviousVowel = true;
        continue;
      }
      gibberishText += c;
      isPreviousVowel = false;
    }
    this.text = gibberishText;
  }
}
