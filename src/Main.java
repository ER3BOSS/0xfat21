import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static List<String> wordlist = new ArrayList<>();
    private static String input = "dotwbone;mbsplseiai;frgenfaigin;ealcresr;oevanncdet;treopssehs;nontaucnti;sooiatbln;juaokds;wboylo"; //lazy ass input
    public static void main(String arg[]) {
        try {
            readFile();
            String[] words = input.split(";");
            List<Character> compare  = new ArrayList<>();
            List<String> results = new ArrayList<>();
            boolean charFound = true;
            Collections.sort(wordlist, Comparator.comparingInt(String::length)); //Sort by length descending order
            for (int i = 0; i < words.length; i++){ // for every input word
                for (int j = 0; j < wordlist.size(); j++){ // go through the whole wordlist
                    if (words[i].length() == wordlist.get(j).length()){//look if the charCount of both match
                        compare = getCharArray(wordlist.get(j)); //get an array of the chars of wordlist at i
                        for (int y = 0;y<words[i].length(); y++){ //iterrates through all the chars of the input word
                            for (int z = 0; z < compare.size(); z++){// ~ through all the chars of the wordlist word
                                if (words[i].charAt(y) == compare.get(z)){
                                        compare.remove(z);
                                        charFound = true;
                                        break;
                                }else{//There is no Char that matches the given word anymore
                                    charFound = false;
                                }
                            }
                            if (!charFound) {
                                break;
                            }
                        }
                        if (!charFound){
                            charFound = true;
                        }else {
                            results.add(wordlist.get(j));
                        }
                    }else{//the word sizes dont match up
                        //System.out.println(words[i].length() +" vs "+  wordlist.get(j).length());
                        /*
                        no need to implement a break if the if the search reaches words of sizes greater than
                        the word we are currently looking for since that case will never happen in the given case
                        */
                    }
                }
            }
            for (int i = 0; i < results.size(); i++){
                System.out.print(results.get(i)+";"); //lazy ass output
            }
        }/* catch (IOException e) {
            e.printStackTrace();
        }*/ catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("wordlist.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null)

        {
            // process the line.
            wordlist.add(line);
        }
    }
    private static List<Character> getCharArray(String input){
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            characters.add(input.charAt(i));
        }
        return characters;
    }

}
