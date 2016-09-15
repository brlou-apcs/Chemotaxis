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















/*
int x,y; // global x and y

int maxNumber = 100; // max number of bacteria

ArrayList<Bacteria> colony = new ArrayList<Bacteria>(); // Declares an array of Bacteria

 void setup() {
 	frameRate(30);
 	size(800,800);
 	background(72, 168, 216);

 	for (int i = 0; i < colony.size(); i++) { // Loops for all Bacteria in the array

 		// Random x and y for each bacteria
 		x = (int)(Math.random()*801);
 		y = (int)(Math.random()*801);

 		// Initializes each Bacteria in array with random position and color
 		colony.add(new Bacteria(x,y,(int)(Math.random()*100),(int)(Math.random()*10+240),(int)(Math.random()*100)));
 	}
 }

 void draw() {

 	// Resets screen
 	background(72, 168, 216);

 	// Move and show each bacteria in the array
 	for(int i = 0; i < colony.size(); i++) {
 		colony.get(i).move();
 		colony.get(i).show();
 		//if (colony[i].m >= colony[i].l)
 	}
 }

 void mousePressed() {
 	Food f = new Food((int)mouseX, (int)mouseY);
 	f.show();
 }

 class Bacteria {

 	// Declares all Bacteria member variables
 	int x,y,r,g,b,w,h,rn,u,l,m;

 	// x and y are coordinates
 	// r,g,b is for color
 	// w (width) and h (height)
 	// m is a random (M)oving case
 	// u is (U)nits of movement
 	// l is (L)ifespan

 	// Constructor function to initialize variables
 	Bacteria(int inputX, int inputY, int inputR, int inputG, int inputB) {
 		x = inputX;
 		y = inputY;
 		r = inputR;
 		g = inputG;
 		b = inputB;
 		w = 20;
 		h = 20;
 		u = 10;
 		l = (int)(Math.random()*100+100);
 		m = 0;
 	}

 	void move() {

 		// random case
 		rn = (int)(Math.random()*8+1);

 		switch (rn) {
 			case 1:
 				x+=u;
 				break;
 			case 2:
 				x-=u;
 				break;
 			case 3:
 				y+=u;
 				break;
 			case 4:
 				y-=u;
 				break;
 			case 5:
 				x+=u;
 				y+=u;
 				break;
 			case 6:
 				x+=u;
 				y-=u;
 				break;
 			case 7:
 			 	x-=u;
 				y-=u;
 				break;
 			case 8:
 			 	x-=u;
 				y+=u;
 				break;
 		}
 		m++;
 	}

 	void show() {
 		fill(r,g,b);
 		ellipse(x,y,w,h);
 	}
 }

 class Food {
 	int x,y,w,h;

 	Food(int inputX, int inputY) {
 		x = inputX;
 		y = inputY;
 		w = 50;
 		h = 50;
 	}

 	void show() {
 		fill(255,0,0);
 		ellipse(x,y,w,h);
 	}

 }
 */
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
