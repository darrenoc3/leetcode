package solved.ransomnote;

import java.util.HashMap;

/** https://leetcode.com/problems/ransom-note */
public class RansomNote {
  /**
   * Runtime: 11 ms, faster than 28.68% of Java online submissions for Ransom Note. Memory Usage:
   * 39.5 MB, less than 46.66% of Java online submissions for Ransom Note.
   */
  public boolean canConstruct(String magazine, String ransomNote) {
    var magazineLetterCounts = new HashMap<Character, Integer>();
    for (char magazineLetter : magazine.toCharArray()) {
      int wordCount = 1;
      if (magazineLetterCounts.containsKey(magazineLetter)) {
        wordCount += magazineLetterCounts.get(magazineLetter);
      }
      magazineLetterCounts.put(magazineLetter, wordCount);
    }
    for (char ransomLetter : ransomNote.toCharArray()) {
      Object value = magazineLetterCounts.get(ransomLetter);
      // fail case is if the magazine doesnt contain the word, or
      // the magazine contains the word but we've used all the occurrences
      // of it already
      if (value == null || (int) value == 0) {
        return false;
      } else {
        // lower the counter for this word by 1 as we've used it
        int wordCount = magazineLetterCounts.get(ransomLetter);
        magazineLetterCounts.put(ransomLetter, wordCount - 1);
      }
    }
    return true;
  }
}
