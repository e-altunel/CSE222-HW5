import java.util.Map;

public class encryptor {
  private Map<Character, Map<Character, Character>> map;
  private String key;
  private String keystream = "";
  private String plain_text;
  private String cipher_text = "";

  public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
    this.map = _map;
    this.key = _key;
    this.plain_text = text;
  }

  public void encrypt() {
    // do not edit this method
    generate_keystream();
    generate_cipher_text();
  }

  private void generate_keystream() {
    for (int i = 0; i < plain_text.length(); i++) {
      keystream = keystream + key.charAt(i % key.length());
    }
  }

  private void generate_cipher_text() {
    for (int i = 0; i < keystream.length(); i++) {
      char c = map.get(plain_text.charAt(i)).get(keystream.charAt(i)); // Get the corresponding ciphertext character
      cipher_text = cipher_text + c;
    }
  }

  public String get_keystream() {
    return keystream;
  }

  public String get_cipher_text() {
    return cipher_text;
  }
}
