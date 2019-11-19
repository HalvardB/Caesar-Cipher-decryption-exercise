package com.company;

import edu.duke.*;
import org.apache.commons.csv.*;

public class WordLengths {

    public int cleanWord(String word){

        // Remove white spaces from the word
        while(word.contains(" ") || word.contains("\n")){
            if(word.substring(0,1) == " "){
                word = word.substring(1);
            }

            if(word.substring(word.length() -1) == " "){
                word = word.substring(0, word.length() -1 );
            }
        }

        int stringLength = word.length();

        // Check the first character in the string
        char firstLetter = word.charAt(0);
        if(!Character.isAlphabetic(firstLetter)){
            stringLength--;
        }

        // Check the last character in the string
        char lastLetter = word.charAt(word.length() - 1);
        if(!Character.isAlphabetic(lastLetter)){
            stringLength--;
        }

        return stringLength;
    }

    public void countWordLengths(FileResource resource, int[] counts){

        // Loop through all the rows in the file
        for(CSVRecord rec : resource.getCSVParser(false)){
            String allText = rec.get(0);
            int currentIndex = allText.indexOf(" ");

            // Loop through the text in the row
            while(allText.length() > 0){
                currentIndex = allText.indexOf(" ");

                // If there is only one word left
                if(currentIndex == -1){
                    currentIndex = allText.length();
                }

                // If there is a space in index[1], continue to the next iteration
                if(currentIndex == 0){
                    allText = allText.substring(currentIndex + 1);
                    continue;
                }

                // Find the current subscring and find the length
                String currentWord = allText.substring(0, currentIndex);
                int stringLength = cleanWord(currentWord);

                // Group all words longer than the array size
                if(stringLength > counts.length){
                    stringLength = counts.length;
                }

                // Update the counts array
                counts[stringLength]++;

                // Continue the loop if there are more words
                if(allText == currentWord){
                    break;
                } else {
                    allText = allText.substring(currentIndex + 1);
                }
            }
        }

        // Print out the results in the array
        for(int i = 0; i < counts.length; i++){
            System.out.println("Words with " + i + " characters: " + counts[i]);
        }
    }
}
