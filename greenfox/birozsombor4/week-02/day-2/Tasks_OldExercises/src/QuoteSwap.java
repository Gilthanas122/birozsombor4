import java.util.ArrayList;
import java.util.Arrays;

public class QuoteSwap {
    public static void main(String... args){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));

        // Accidentally I messed up this quote from Richard Feynman.
        // Two words are out of place
        // Your task is to fix it by swapping the right words with code
        // Create a method called quoteSwap().

        // Also, print the sentence to the output with spaces in between.
        System.out.println(quoteSwap(list));
        // Expected output: "What I cannot create I do not understand."

    }
    public static String quoteSwap(ArrayList<String> list){
        ArrayList<String> input = new ArrayList<>(list);
        String sentence = "";
        input.remove(input.indexOf("do"));
        input.remove(input.indexOf("cannot"));
        input.add(2, "cannot");
        input.add(5, "do");
        for(String word : input){
            sentence += word + " ";
        }
        sentence.trim();
        return sentence;
    }
}
