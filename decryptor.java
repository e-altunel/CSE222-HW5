import java.util.Map;
import java.util.Iterator;

public class decryptor {
  private Map<Character, Map<Character, Character>> map;
  private String key;
  private String keystream = "";
  private String plain_text = "";
  private String cipher_text;

  public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
    this.map = _map;
    this.key = _key;
    this.cipher_text = text;
  }

  public void decrypt() {
    // do not edit this method
    generate_keystream();
    generate_plain_text();
  }

  private void generate_keystream() {
    for (int i = 0; i < cipher_text.length(); i++) {
      keystream = keystream + key.charAt(i % key.length());
    }
  }

  private void generate_plain_text() {
    for (int i = 0; i < keystream.length(); i++) {
      char keystreamChar = keystream.charAt(i);
      char cipherChar = cipher_text.charAt(i);

      Iterator<Character> iterator = map.get(keystreamChar).keySet().iterator();
      while (iterator.hasNext()) {
        char character2 = iterator.next();

        if (map.get(keystreamChar).get(character2) == cipherChar) {
          plain_text = plain_text + character2;
          break;
        }
      }
    }
  }

  public String get_keystream() {
    return keystream;
  }

  public String get_plain_text() {
    return plain_text;
  }
}
