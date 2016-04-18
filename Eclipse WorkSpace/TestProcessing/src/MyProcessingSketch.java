import processing.core.*;

public class MyProcessingSketch extends PApplet {

  public void setup() {
    size(600,600);
    background(0);
  }
  
  public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "MyProcessingSketch" });
	  }

  public void draw() {
    stroke(255);
    if (mousePressed) {
      line(mouseX,mouseY,pmouseX,pmouseY);
    }
  }
}