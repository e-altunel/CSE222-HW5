import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
  private Set<Character> english_alphabet = new LinkedHashSet<Character>();
  private Map<Character, Map<Character, Character>> map = new HashMap<Character, Map<Character, Character>>();

  public alphabet() {
    // do not edit this method
    fill_english_alphabet();
    fill_map();
  }

  private void fill_english_alphabet() {
    // do not edit this method
    for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
      english_alphabet.add(c);
    }
  }

  private void fill_map() {
    Iterator<Character> iterator = english_alphabet.iterator();

    while (iterator.hasNext()) {
      char key = iterator.next();
      Map<Character, Character> innerMap = new HashMap<>();

      for (int i = 0; i < english_alphabet.size(); i++) {
        char value = (char) ('A' + (i + key - 'A') % 26);
        innerMap.put((char) ('A' + i), value);
      }

      map.put(key, innerMap);
    }
  }

  public void print_map() {
    // do not edit this method
    System.out.println("*** Viegenere Cipher ***\n\n");
    System.out.println("    " + english_alphabet);
    System.out.print("    ------------------------------------------------------------------------------");
    for (Character k : map.keySet()) {
      System.out.print("\n" + k + " | ");
      System.out.print(map.get(k).values());
    }
    System.out.println("\n");

  }

  public Map get_map() {
    return map;
  }
}