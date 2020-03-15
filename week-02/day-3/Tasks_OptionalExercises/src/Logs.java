import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
  public static void main(String[] args) throws IOException {
    // Read all data from 'log.txt'.
    // Each line represents a log message from a web server
    // Write a function that returns an array with the unique IP adresses.
    // Write a function that returns the GET / POST request ratio.
    List<String> log = Files.readAllLines(Paths.get("files/log.txt"));
    System.out.println(returnUniqueIpAddresses(log));
    System.out.println("");
    System.out.println(getGetPostRatio(log));

  }

  private static String getGetPostRatio(List<String> log) {
    int getCounter = 0;
    int postCounter = 0;
    for (String line : log){
      if (line.contains("GET")){
        getCounter++;
      }else {
        postCounter++;
      }
    }
    return new String("GET : POST ratio is " + getCounter + " / " + postCounter);
  }

  private static List<String> returnUniqueIpAddresses(List<String> log) {
    List<String> ipAddresses = new ArrayList<>();
    String actualYear = "2018";
    for (String line : log) {
      ipAddresses.add(line.substring(line.indexOf(actualYear) + 7, line.indexOf(actualYear) + 18));
    }
    List<String> uniqueIpAddresses = new ArrayList<>();
    for (String ip : ipAddresses) {
      if (!uniqueIpAddresses.contains(ip)) {
        uniqueIpAddresses.add(ip);
      }
    }
    System.out.println("IP adresses: " + ipAddresses.size());
    System.out.println("Unique IP adresses: " + uniqueIpAddresses.size());
    return uniqueIpAddresses;
  }
}
