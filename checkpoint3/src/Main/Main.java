//Yingying Sroy
//CSC 130 (In-person and online).....o
//Checkpoint #3
//03.28.2022


package Main;

import logic.Control;
import timer.stopWatchX;
import java.util.ArrayList;
import Data.spriteInfo;
import Data.Vector2D;

public class Main
{
	// Fields (Static) below...
	
	//create an ArrayList of spriteInfo
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	//create a frame counter variable and set it 0
	public static int frameCounter= 0;
	//create a stop watch and set it to 100
	public static stopWatchX timer = new stopWatchX(100);
	//create a variable p for size of the arrayList
	private static int p;


	
	// End Static fields...
	
	public static void main(String[] args) 
	{
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start()
	{
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
		//use for loop for adding our frame to the arrayList
		for(int i = -128; i < 2048; i+=8)
		{
			//create new spriteInfor based on x and y coordinates, and the frame is the sprite Tag
			sprites.add(new spriteInfo(new Vector2D(i,150),"mizu"+ frameCounter));
			
			frameCounter++;//increment the number of the frames
			
			//if our frame is at the index 3, 
			if (frameCounter > 3)
			{
				//go back to first frame
				frameCounter = 0;
			}
		}
		//set the size of the array list of the frames
		p = sprites.size();	
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) 
	{
		//set the spriteInfo a variable to the frame counter
		spriteInfo tmp = sprites.get(frameCounter);
		//add the sprite according to it coordinates
		ctrl.addSpriteToFrontBuffer(tmp.getCoords().getX(),tmp.getCoords().getY(),tmp.getTag());
		
		
		//set timer so that it goes over and over from the left to right side of the screen
		if(timer.isTimeUp())
		{
			frameCounter++;
			if(frameCounter == p)
			{
				frameCounter = 0;
			}
			//reset the time again
			timer.resetWatch();
		}
	
	}
	
	// Additional Static methods below...(if needed)
   
}
