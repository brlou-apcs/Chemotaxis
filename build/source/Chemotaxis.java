import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

ArrayList<Bacteria> bacteria;
int initialNumBacteria = 100;

public void setup() {
  int x,y;
  
  background(72,168,216);

  bacteria = new ArrayList<Bacteria>();

  for (int i = 1; i <= initialNumBacteria; i++) {
    x = (int)(Math.random()*400+200);
    y = (int)(Math.random()*400+200);
    bacteria.add(new Bacteria(x,y));
  }
}

public void draw() {
  background(72,168,216);
  for (int i = bacteria.size()-1; i >= 0; i--) {
    Bacteria b = bacteria.get(i);
    b.move();
    b.display();

    if (b.numMoves >= b.lifeSpan) {
      bacteria.remove(i);
    }

  }
}

class Bacteria {
  int myX,myY,mySize,moveDirection,moveUnits,numMoves,lifeSpan;

  Bacteria(int x, int y) {
    myX = x;
    myY = y;
    mySize = (int)(Math.random()*10+10);
    lifeSpan = (int)(Math.random()*200+200);
  }

  public void move() {
    moveDirection = (int)(Math.random()*8+1);
    moveUnits = (int)(Math.random()*16);

    switch(moveDirection) {
      case 1:
          myY += moveUnits;
        break;
      case 2:
          myY += moveUnits;
          myX += moveUnits;
        break;
      case 3:
          myX += moveUnits;
        break;
      case 4:
          myX += moveUnits;
          myY -= moveUnits;
        break;
      case 5:
          myY -= moveUnits;
        break;
      case 6:
          myX -= moveUnits;
          myY -= moveUnits;
        break;
      case 7:
          myX -= moveUnits;
        break;
      case 8:
          myX -= moveUnits;
          myY += moveUnits;
        break;
    }
    numMoves++;
  }

  public void display() {
    fill(0,255,0);
    ellipse(myX, myY, mySize, mySize);
  }
}
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
