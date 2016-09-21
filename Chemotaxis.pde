ArrayList<Bacteria> bacteria;
int initialNumBacteria = 50;
int x,y;

void setup() {
	frameRate(20);
	size(800,800);
  background(72,168,216);

  bacteria = new ArrayList<Bacteria>();

  for (int i = 1; i <= initialNumBacteria; i++) {
    x = (int)(Math.random()*400+200);
    y = (int)(Math.random()*400+200);
    bacteria.add(new Bacteria(x,y));
  }
}

void draw() {
  background(72,168,216);
  for (int i = bacteria.size()-1; i >= 0; i--) {
    Bacteria b = bacteria.get(i);
    b.move();
    b.display();

    if (b.numMoves >= b.lifeSpan) {
      bacteria.remove(i);
    }

    if (get(b.myX, b.myY) != b.c && b.numMoves > b.lifeSpan*0.8) {
    	if((int)(Math.random()*2) == 1) {
    		bacteria.add(new Bacteria(x,y));
    	}
  	}
  }

  fill(0);
  text("Colony: " + bacteria.size(), 10, 750);
  text("Time: " + (int)(frameCount/frameRate), 10, 770);
}

class Bacteria {
  int myX,myY,moveDirection,moveUnits,numMoves,lifeSpan,c;
  float mySize;

  Bacteria(int x, int y) {
    myX = x;
    myY = y;
    mySize = (float)(Math.random()*10+10);
    lifeSpan = (int)(Math.random()*200+50);

    x = (int)(Math.random()*400+200);
    y = (int)(Math.random()*400+200);
    c = color((int)(Math.random()*200),255,(int)(Math.random()*200));
  }

  void move() {
    moveDirection = (int)(Math.random()*8+1);
    moveUnits = (int)(Math.random()*26);

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
    mySize+=0.025;
  }

  void display() {
    fill(c);
    ellipse(myX, myY, mySize, mySize);
  }
}
