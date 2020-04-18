import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchWord {

	public static void main(String[] args) {
		//Scanner to ask user where to locate and read the text file
		Scanner sn = new Scanner(System.in);
		System.out.println("What is the file's name and location? (fileName.txt) ");
		System.out.print("Enter here --> ");
		String fileName = sn.next();
				
		//ask user to input a word to seach for
		System.out.print("\nEnter the word the you want to search: ");
		//reads the user input
		String userInputWord = sn.next();
		//convert the word into lower case to avoid overlooking words that are capitalize or have different font size
		userInputWord.toLowerCase();
		
		//creates a new file using user iinput
		File file = new File(fileName);
		
		//array to store words
		String[] words = null;
				
		int count = 0; //Counts the number of times the word "the" is used in the file
			
				
			try {
				//Use fileReader to read the files
				FileReader fileReader = new FileReader(file);
				//Use buffered reader to readtext that are in lines or structured like arrays
				BufferedReader reader = new BufferedReader(fileReader);
				String line = reader.readLine();
				
				System.out.println("Searching for the word " + "\"" + userInputWord + "\"" + "...\n");
				Thread.sleep(5000);
					
				//A loop to printout the current data inside the file - reads each line
				while(line != null) {
					//splits the string so we can search for the specific word
					//.toLowerCase is to ensure that regardless whether the word is cap or not, we will count it
					words = line.toLowerCase().split(" ");
						
					//Used for each loops to traverse and look for the for word "the"
					for(String word: words) {
							
						//if the word "the" is present, we will add 1 to our count variable
						if(word.equals(userInputWord)) {
							count++;
						}//end inner if
					}//end for loop
						
					//moves to the next line
					line = reader.readLine();
					
				}//end while loop
					
				//If-else statement to determine what will print out in our conosle
				if(count != 0) {
					System.out.println("The number of times the word " + "\"" + userInputWord + "\"" + " is used in the file is " + count + " times.");
				}else {
					System.out.println("The word is not present in the file.");
				}
				reader.close();
					
			}catch(IOException ex) {
				System.out.printf("Error: %s/n", ex);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end mainMethod

	}//end class


