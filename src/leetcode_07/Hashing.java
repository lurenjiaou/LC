package leetcode_07;

import java.io.*;
import java.util.*;

public class Hashing{
	public static void main (String[] args){
		//Number of items to be added to the hash table.
		int items=90000;

		System.out.println("The size of string array is: "+ items);
		String[] contents = new String[items]; //Creating a string array of size 'items'
		try {
			File myObj = new File("C:\\Users\\user\\Desktop\\梅努斯\\dictionary.txt");
			Scanner myReader = new Scanner(myObj);
			int i=0;
			//Iterating through the array and adding strings
			while (myReader.hasNextLine() & i<items) {
				contents[i]=myReader.nextLine();
				i++;
			}
			myReader.close();
			System.out.println(i + " word strings were read from the file.");
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}		
		HashTable mytable = new HashTable(); //Creating a new object (mytable) of type HashTable
		Solution mysolution = new Solution(mytable); //Creating a new object (mysolution) of type Solution which passes in the HashTable
		mysolution.fill(contents); //Filling the contents of mysolution object with string array contents

		//Iterating through the string array and swapping current string position with rand array position
		for(int i=0;i<items;i++)
		{
			int rand = (int)(Math.random()*items); //Returns random int between 0 and times (i.e. 0 and 2); 
			String temp = contents[i]; 
			contents[i]=contents[rand];
			contents[rand]=temp;
		}
		//Iterating through the string array to search for a particular string (word)
		for(int i=0;i<items;i++)
		{
			int slot = mysolution.find(contents[i]); //slot = array positon of searched string
			//If string not found in array position return error
			if(!mytable.check(slot,contents[i]))
			{
				System.out.println("\n error!");
			}
		}
		System.out.println("\n Number of Collisions: " + mytable.gettotal()); //Printing the number of collisions
	}

}


class HashTable
{
	public int size = 100003; //Setting size of HashTable (no. of slots)
	private String[] hashTable; //Creating string called hashTable
	private int total=0; //Counter used to return number of collisions

	//Function that creates a string array of size 99991 and sets all slots = "";
	public HashTable()
	{
		hashTable = new String[size];
		for(int i=0;i<size;i++)
		{
			hashTable[i]="";
		}
	}
	//Function that checks for a particular string in the hashTable (PARTICULAR STRING OR JUST A STRING I.E. CHECK FOR FREE SLOT)
	public boolean check(int slot, String check)
	{
		if(hashTable[slot].equals(check)) //If current string = string passed in, return true
		{
			return true;
		}
		else //Else, increment the number of collisions and return false
		{
			total++;
			return false;
		}
	}

	//Function that sets slot of hashTable = string
	public void set(int slot, String word)
	{
		hashTable[slot]=word;
	}

	//Function that returns total number of collisions
	public int gettotal()
	{
		return total;
	}
}

class Solution
{
	HashTable mytable = new HashTable(); //Creating a new HashTable object
	//Creating a function that ....................
	public Solution(HashTable input)
	{
		mytable = input;
		//this is the constructor
	}

    int hash(String word)
    {
        int ret = 1531;
        for (int i = 0; i < word.length(); i++)
        {
            ret = 97 * ret % mytable.size;
            ret ^= word.charAt(i);
        }
        return ret % mytable.size;
    }

    int hash2(String word)
    {
        int ret = 131;
        for (int i = 0; i < word.length(); i++)
        {
            ret = 61 * ret % mytable.size;
            ret ^= word.charAt(i);
        }
        return ret % mytable.size;
    }

	//Function to find words in hashTable
	public int find(String word)
	{
		int slot = hash(word);
        int step = hash2(word);
        // if (!mytable.check(slot, word))
        // {
        //     slot = (slot + (step = hash2(word))) % mytable.size;
        //     // slot = (slot + step * (step++)) % mytable.size;
        // }
        while (!mytable.check(slot, word))
        {
            slot = (slot + step) % mytable.size;
            // slot = (slot + step * (step++)) % mytable.size;
        }
        return slot;
    }

	//Function to fill words into hashTable
	public void fill(String[] array)
	{
		//takes in the array of Strings to be placed in the mytable HashTable
		//this should add all the words into the hashtable using some system
		//then it should fill the hashtable array
		for(int i=0;i<array.length;i++){
            int slot = hash(array[i]);
            int step = hash2(array[i]);
            // if (!mytable.check(slot, array[i]))
            // {
            //     slot = (slot + (step = hash2(array[i]))) % mytable.size;
            //     // slot = (slot + step * (step++)) % mytable.size;
            // }
            while (!mytable.check(slot, ""))
            {
                slot = (slot + step) % mytable.size;
                //slot = (slot + step * (step++)) % mytable.size;
            }
			mytable.set(slot , array[i]);
		}
	}

}