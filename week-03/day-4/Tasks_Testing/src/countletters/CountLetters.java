package countletters;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountLetters {
  public HashMap<Character, Integer> getLetterOccurences(String inputWord) {
    HashMap<Character, Integer> lettersAndOccurences = new HashMap<>();
    ArrayList<Character> uniqueCharacters = new ArrayList<>();
    for (char c : inputWord.toCharArray()) {
      if (!uniqueCharacters.contains(c)) {
        uniqueCharacters.add(c);
      }
    }
    for (char c : uniqueCharacters) {
      lettersAndOccurences.put(c, 0);
    }
    for (char c : inputWord.toCharArray()) {
      for (Map.Entry<Character, Integer> entry : lettersAndOccurences.entrySet()) {
        if (entry.getKey().equals(c)) {
          int holder = entry.getValue();
          holder++;
          lettersAndOccurences.put(c, holder);
          break;
        }
      }
    }
    return lettersAndOccurences;

  }
}
