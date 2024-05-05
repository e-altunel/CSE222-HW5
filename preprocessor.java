public class preprocessor {
  private String initial_string;
  private String preprocessed_string;

  public preprocessor(String str) {
    this.initial_string = str;
  }

  public void preprocess() {
    // do not edit this method
    capitalize();
    clean();
  }

  private void capitalize() {
    preprocessed_string = initial_string.toUpperCase();
  }

  private void clean() {
    String result = "";
    for (int i = 0; i < preprocessed_string.length(); i++) {
      char c = preprocessed_string.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        result = result + c;
      }
    }
    preprocessed_string = result.toString();
  }

  public String get_preprocessed_string() {
    return preprocessed_string;
  }
}