import processing.core.*;
import ddf.minim.*;
import controlP5.*;



public class MyProcessingSketch extends PApplet 
{
	Minim m;
	AudioPlayer song;
	
	ControlP5 cp5;
	
	int mode = 1;
	
	
	
	public void setup() 
	{
	    size(1200,1200);
	    background(0);
	    
	    m = new Minim(this);
	    //loads song from the data folder
	    song = m.loadFile("Drop It Like It's Hot.mp3");
	    song.play();
	}//end setup
  
	
	
  public static void main(String args[]) 
  {
	    PApplet.main(new String[] { "--present", "MyProcessingSketch" });
  }//end main

  
  
  public void draw() 
  {
	  switch(mode)
	  {
		  case 1:
		  {
		  }
	  
		  case 2:
		  {
		  }
	  
		  case 3:
		  {
		  }
	  }//end switch
	  
    stroke(255);
    if (mousePressed) 
    {
    	
      line(mouseX,mouseY,pmouseX,pmouseY);
    }//end mousePressed
  }//end draw
}//end Sketch