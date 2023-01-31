//Yingying Sroy
//CSC 130 (In-person)
//checkpoint #4
//04.11.2022...


package Main;

import logic.Control;
import FileIO.EZFileRead;
import java.util.HashMap;
import java.util.StringTokenizer;
import timer.stopWatchX;
import java.awt.Color;



public class Main
{
	//  Fields (Static) below..
	
	public static HashMap<String,String> map;
	public static String S = "string1";
	public static int i = 0;
	public static stopWatchX timer = new stopWatchX(1000);
	public static Color c = new Color(100,255,0);
	public static String raw;
	
	
	// End Static fields....
	
	public static void main(String[] args)
	{
		Control ctrl = new Control();		// Do Not remove 
		ctrl.gameLoop();					// Do Not remove
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start()
	{
		// TODO: Code your starting conditions here...... Not DRAW CALLS HERE! ( no addSrite or drawString)
		
		
		//Import the text file into the game engine 
		EZFileRead ezr = new EZFileRead("myDailog.txt");
		//create a new hashMap for the conversation 
		map = new HashMap<>();
		
		//use while loop 
		while(i < ezr.getNumLines())
		{
			raw = ezr.getNextLine();
			i++;
			//use SringTokenizer for key and its values
			StringTokenizer str = new StringTokenizer(raw,"*");
			String key = str.nextToken();    //acquires the Key from the raw String
			String value = str.nextToken();  //acquires the value from the raw String  
			
			//add the K,v pair to our map
			map.put(key,value);

		}
		i= 1;
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl)
	{
		String str1= map.get(S);
		//set the coordinate of each line of conversation 
		ctrl.drawString(100, 250, str1, c);
		if(timer.isTimeUp())
		{
			i++;
			//if it is more than 5 
			if(i>5)
			{
				i = 1;//back to the first key
			}
			S ="string" + i;
			timer.resetWatch();
		}
	}
}


