package com.greenfoxacademy.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SithText {

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String text;

  @JsonProperty("sith_text")
  private String sithText = "";

  public SithText() {
  }

  public SithText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSithText() {
    return sithText;
  }

  public void setSithText(String sithText) {
    this.sithText = sithText;
  }

  //Before : "This is my example sentence. Just for fun."
  //After : "Is this example my sentence. Arrgh. Uhmm. For just fun. Err..err.err."
  public void setSithTextWithTranslating() {
    List<String> sentencesOfSithText = new ArrayList<>();
    sentencesOfSithText.addAll(getReorderedSentences());
    List<String> sithTextWithRandomYodaPhrases = getYodaFilledSentences(sentencesOfSithText);
    this.sithText = sithTextWithRandomYodaPhrases.stream().collect(Collectors.joining(" "));
  }

  private List<String> getYodaFilledSentences(List<String> sentencesOfSithText) {
    List<String> filledList = new ArrayList<>();
    List<String> yodaSentences = Arrays.asList("Arrgh.", "Uhmm.", "Err..err.err.");
    for (int i = 0; i < sentencesOfSithText.size(); i++) {
      filledList.add(sentencesOfSithText.get(i));
      int randomIndex = (int) (Math.random() * 2);
      filledList.add(yodaSentences.get(randomIndex));
    }
    return filledList;
  }

  private List<String> getReorderedSentences() {
    List<String> reorderedSentences = new ArrayList<>();
    String[] sentences = this.text.split("\\.");
    for (String sentence : sentences) {
      String[] words = sentence.trim().split(" ");
      List<String> replacedWords = new ArrayList<>();
      for (int i = 0; i < words.length; i += 2) {
        if ((words.length % 2 != 0) && (i + 1 >= words.length - 1)) {
          replacedWords.add(new String(words[words.length - 1]));
          break;
        }
        replacedWords.add(words[i + 1].toLowerCase());
        replacedWords.add(words[i].toLowerCase());
      }
      String reorderedSentence = replacedWords.stream().collect(Collectors.joining(" "));
      String fixedReorderedSentence = fixFirstLetterOfSentenceAndAddDot(reorderedSentence);
      reorderedSentences.add(fixedReorderedSentence);
    }
    return reorderedSentences;
  }

  private String fixFirstLetterOfSentenceAndAddDot(String reorderedSentence) {
    reorderedSentence.trim();
    reorderedSentence += ".";
    StringBuilder stringBuilder = new StringBuilder(reorderedSentence);
    stringBuilder.replace(0, 1, String.valueOf(reorderedSentence.charAt(0)).toUpperCase());
    return stringBuilder.toString();
  }
}
