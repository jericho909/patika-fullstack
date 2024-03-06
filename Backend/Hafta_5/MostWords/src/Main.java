import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String wordWithMaxCount = null;
        int maxCount = Integer.MIN_VALUE;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the text: ");
        String sentence = input.nextLine();
        String[] sentenceToArray = sentence.split(" ");
        HashMap<String, Integer> mostOccurred = new HashMap<>();


        for (String s : sentenceToArray) {
            if (!mostOccurred.containsKey(s)) {
                mostOccurred.put(s, 1);
            } else {
                int letterCount = mostOccurred.get(s);
                mostOccurred.put(s, letterCount + 1);
            }
        }

        for (String words: mostOccurred.keySet()){
            if (mostOccurred.get(words) > maxCount){
                maxCount = mostOccurred.get(words);
                wordWithMaxCount = words;
            }
        }


        System.out.println("The word " + wordWithMaxCount + " is seen " + maxCount + " times and is the " +
                "most occurring in the text.");



    }
}