import java.awt.*;

public class ZZZZZnake {
	
		
	public static void main(String[] args) {
				
		//Startpositionen
		Point playerPosition = new Point();
		Point firstSnakePosition = new Point();
		Point secondSnakePosition = new Point();
		Point firstGoldPosition = new Point();
		Point secondGoldPosition = new Point();
		Point doorPosition = new Point();
		
		initialisierePunkt(playerPosition);
		initialisierePunkt(firstSnakePosition);
		initialisierePunkt(secondSnakePosition);
		initialisierePunkt(firstGoldPosition);
		initialisierePunkt(secondGoldPosition);
		initialisierePunkt(doorPosition);
		
		boolean rich = false;
		int count = 0;

		//Spielstart
		while(true) {
						
			//Raster mit Figuren zeichnen
			zeichneSpielfeld(playerPosition, firstSnakePosition, secondSnakePosition,
					firstGoldPosition, secondGoldPosition, doorPosition);
			
			//Status
			status(rich, playerPosition, firstSnakePosition, secondSnakePosition,
					firstGoldPosition, secondGoldPosition, doorPosition);			
			
			//Konsoleneingabe und Spielersteuerung
			konsolenEingabe(playerPosition);
			
			//Schlangen bewegen sich in Richtung Spieler
			if(count>=5) {
				schlangenBewegung(playerPosition, firstSnakePosition, secondSnakePosition);				
			}
			
			count++;
		}		
	}

	public static void initialisierePunkt(Point p) {
		int x = (int)(Math.random() * 40);
		int y = (int)(Math.random() * 10);
		p.setLocation(x, y);
	}
	
	public static void zeichneSpielfeld(Point playerPosition, Point firstSnakePosition, Point secondSnakePosition,
			Point firstGoldPosition, Point secondGoldPosition, Point doorPosition) {
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 40; x++) {
				java.awt.Point p = new java.awt.Point(x, y);
				if(playerPosition.equals(p))
					System.out.print("&");
				else if(firstSnakePosition.equals(p) || secondSnakePosition.equals(p))
					System.out.print("S");
				else if(firstGoldPosition.equals(p) || secondGoldPosition.equals(p))
					System.out.print("$");
				else if(doorPosition.equals(p))
						System.out.print("#");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}

 	public static void status(boolean rich, Point playerPosition, Point firstSnakePosition, Point secondSnakePosition,
			Point firstGoldPosition, Point secondGoldPosition, Point doorPosition) {
		if(rich && playerPosition.equals(doorPosition)) {
			System.out.println("Gewonnen!");
			System.exit(0);
			//return;
		}
		if(playerPosition.equals(firstSnakePosition) || playerPosition.equals(secondSnakePosition)) {
			System.out.println("ZZZZZZZ. Die Schlange hat dich!");
			System.exit(0);
			//return;
		}
		if(playerPosition.equals(firstGoldPosition) || playerPosition.equals(secondGoldPosition)) {
			rich = true;
			firstGoldPosition.setLocation(-1, 1);
			secondGoldPosition.setLocation(-1, 1);
		}
	}
	
	public static void konsolenEingabe(Point playerPosition) {
		switch(new java.util.Scanner(System.in).next()) {
			case "h": playerPosition.y = Math.max(0, playerPosition.y - 1); break;
			case "t": playerPosition.y = Math.min(9, playerPosition.y +1); break;
			case "l": playerPosition.x = Math.max(0, playerPosition.x - 1); break;
			case "r": playerPosition.x = Math.min(39, playerPosition.x + 1); break;
		}
	}
	
	public static void schlangenBewegung(Point playerPosition, Point firstSnakePosition, Point secondSnakePosition) {
		//Erste Schlange
		if(playerPosition.x < firstSnakePosition.x)
			firstSnakePosition.x--;
		else if(playerPosition.x > firstSnakePosition.x)
			firstSnakePosition.x++;
		if(playerPosition.y < firstSnakePosition.y)
			firstSnakePosition.y--;
		else if(playerPosition.y > firstSnakePosition.y)
			firstSnakePosition.y++;
		
		//Zweite Schlange
		if(playerPosition.x < secondSnakePosition.x)
			secondSnakePosition.x--;
		else if(playerPosition.x > secondSnakePosition.x)
			secondSnakePosition.x++;
		if(playerPosition.y < secondSnakePosition.y)
			secondSnakePosition.y--;
		else if(playerPosition.y > secondSnakePosition.y)
			secondSnakePosition.y++;
	}
}