//Yingying Sroy
//CSC 130 (online)
//checkpoint #5
//04.25.2022


package Main;

import java.awt.Color;
import logic.Control;

public class Main
{
	// Fields (Static) below...
	public static String trigger = "";
	public static Color c = new Color(255,255,0);
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start()
	{
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		
		ctrl.drawString(100, 250,trigger,c);		// Test drawing text on screen where you want (Remove later! Test only!)
	}
	
	// Additional Static methods below...(if needed)

}
