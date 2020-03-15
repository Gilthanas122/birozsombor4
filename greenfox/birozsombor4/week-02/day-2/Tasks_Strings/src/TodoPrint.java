public class TodoPrint {
  public static void main(String... args) {
    String todoText = " - Buy milk\n";
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention
    StringBuilder builder = new StringBuilder(todoText);
    todoText = builder.insert(0, "My todo: \n").toString();
    todoText = todoText.concat(" - Download games\n").concat("\t - Diablo");
    // Expected output:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo

    System.out.println(todoText);
  }
}