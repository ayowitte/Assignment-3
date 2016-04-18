import processing.core.*;
import ddf.minim.*;
import controlP5.*;



public class MyProcessingSketch extends PApplet 
{
	Minim m;
	AudioPlayer song;
	
	ControlP5 cp5;
	int c = color(100);
	
	int mode = 0;

	
	
	public void setup() 
	{
		background(0);
	    size(1920,1080);
	    smooth();
	    
	    m = new Minim(this);
	    //loads song from the data folder
	    song = m.loadFile("Drop It Like It's Hot.mp3");
	    //song.play();
	    
	    cp5 = new ControlP5(this);
	    cp5.addColorWheel("c",10,10,200).setRGB(color(128,0,255)); 
	}//end setup
  
	
	
  public static void main(String args[]) 
  {
	    PApplet.main(new String[] { "--present", "MyProcessingSketch" });
  }//end main
  
  
  //detects input from User
  void keyPressed()
  {
	  if(key>='0' && key<='9')
	  {
	    mode = key - '0';
	  }//end if
	  
  }//end keyPressed
  
  
  public void draw() 
  {
	    fill(c);
		rect(0,240,1919,839);
		println(cp5.get(ColorWheel.class,"c").getRGB());
		
		stroke(255);
	    if (mousePressed) 
	    {
	      line(mouseX,mouseY,pmouseX,pmouseY);
	    }//end mousePressed
	    
	  switch(mode)
	  {
	  
		  case 1:
		  {
			    
			    break; //end case 1
		  }//end case 1
	  
		  
		  case 2:
		  {
			  
			  break; //end case 2
		  }
	  
		  
		  case 3:
		  {
			  
			  break; //end case 3
		  }
		  
		  
		  default:
		  {
			  
			  break; //end default
		  }
		  
	  }//end switch
	  
  }//end draw
  
}//end Sketch