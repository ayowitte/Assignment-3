//import external libraries
//processing
import processing.core.*;
//music
import ddf.minim.*;


//creating the class
public class ConnectFour extends PApplet
{
	//width of grid
	int width = 7;
	//height of grid
	int height= 6;
	//blocksize
	int blocksize =100; 
	//declaring 2-D array
	int[][]grid = new int [height][width]; 
	int player =1; 
	
	Minim m;
	AudioPlayer song;
	
	
	//setup
	public void setup()
	{
		//dimensions of the screen
		size(700,600); 
		//modifies location from which ellipses are drawn
		ellipseMode(CORNER);
		//draws geometry with anti-aliased edges
		smooth();
		
		//load in song and plays it
		m = new Minim(this);
	    song = m.loadFile("Asteroids Music.mp3");
	    song.play();
	}
	
	
	//dimensions for the chips
	int chip(int y, int x) 
	{
		//knows if piece is off the board, if so, returns 0, otherwise returns grid
		return (y < 0 || x < 0|| y >= height || x >= width ) ?0:grid[y][x]; 
	}
	
	
	//allows the program to run as a Java Application
	public static void main(String args[]) 
	{
	    PApplet.main(new String[] { "--present", "ConnectFour" });
	}
	
	
	//Checking if the win condition has been met
	int Winner() 
	{ 
		//checks the rows
		for(int y = 0; y < height; y++)
		
			for(int x = 0; x < width; x++)
			
				//if position is not empty and chips are equal to the right chip
			    if (chip(y,x) !=0 && chip(y,x) == chip(y,x + 1) 
			       	&& chip(y,x) == chip(y,x + 2)
			       	&& chip(y,x) == chip(y,x + 3)) 
			    	return chip(y,x);
			
		
	
		
		

		// checks the columns
		for(int y = 0; y < height; y++)
		
			for(int x = 0; x < width; x++)
			
			    if(chip(y,x) !=0 && chip(y,x)== chip(y + 1,x) 
			       && chip(y,x)== chip(y + 2,x)
			       &&chip(y,x)== chip(y + 3,x)) 
			       return chip(y,x);
			
		
		
		
		    
		// checks the diagonals
		for(int y = 0; y < height; y++)
		
			for(int x = 0; x < width; x++) 
			
				for (int m = -1; m <= 1; m +=2)
				
				     if(chip(y,x) !=0  && chip(y,x) == chip(y+1*m,x+1) 
				        && chip(y,x) == chip(y+2*m,x+2) 
				        && chip(y,x) == chip(y+3*m,x+3)) 
				        return chip(y,x);
				
			
		
		
		    
		  //checks for a tie
		  for(int y = 0; y < height; y++)
		  
			  for(int x = 0; x < width; x++)
			  
				  //winner
				  if(chip(y,x)==0) return 0;
				  
		  			//tie
				    return -1;
				  
			  
		  
	}
		  
		  

	//checks where to drop the chip
	int nextSlot(int x)
	{
		for(int y = height - 1; y >= 0; y--)
			
		 if (grid[y][x] == 0)
			  
			   return y;
			   return -1;
			  
	}
		
		
		
	//allows mouse input to be recognized
	public void mousePressed()
	{
		int x = mouseX /blocksize,  y = nextSlot(x); 
		if(y>=0)
		{
			grid[y] [x] = player; 
				player = player == 1?2:1; 
		 }
	}
	
	
	
	public void draw()
	{
		//as long as there is no winner
		if(Winner() ==0)
		{
			  for(int j =0; j<height; j++)
				  
			     for(int i =0; i<width; i++)
			     {
			    	 //background
			    	 fill(255);
			    	 //draws the grid
			    	 rect(i * blocksize,j*blocksize,blocksize,blocksize);

			    	 if(grid [j] [i] > 0)
			    	 {
			    		 //colors for the chips
			    		 fill(grid[j] [i] == 1?255:255, grid [j][i] == 2?255:0,0); 
			    		 ellipse (i*blocksize,j*blocksize,blocksize,blocksize);
			    	 }
			     }
		} 
		
		//option to restart
		else
		{
			//changes the background
			background(0); 
			//font is white
			fill(255);
			//sets text size
			textSize(16);
			//displays winner
			text("Winner: Player " +Winner() + "\n Press Space to Restart", 250, 300); 
			
			//allows 'space' to be recognized as input
			if(keyPressed && key == ' ')
			{
			    player =1;
			    for(int y = 0; y<height; y++)
			    		
			    	for(int x=0;x<width;x++) 
			    			
			    		grid [y] [x] = 0; 
			 }
		}
	
	
	}
}
