
public class ZZZZZnake {
	
		//Startpositionen
		static java.awt.Point playerPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		static java.awt.Point firstSnakePosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		static java.awt.Point secondSnakePosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		static java.awt.Point firstGoldPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		static java.awt.Point secondGoldPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		static java.awt.Point doorPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		
		static boolean rich = false;
		static int count = 0;

	public static void main(String[] args) {
				
		//Spielstart
		while(true) {
						
			//Raster mit Figuren zeichnen
			zeichneSpielfeld();
			
			//Status
			status();			
			
			//Konsoleneingabe und Spielersteuerung
			konsolenEingabe();
			
			//Schlangen bewegen sich in Richtung Spieler
			if(count>=5) {
				schlangenBewegung();				
			}
			
			count++;
		}		
	}

	public static void zeichneSpielfeld() {
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

 	public static void status() {
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
	
	public static void konsolenEingabe() {
		switch(new java.util.Scanner(System.in).next()) {
		case "h": playerPosition.y = Math.max(0, playerPosition.y - 1); break;
		case "t": playerPosition.y = Math.min(9, playerPosition.y +1); break;
		case "l": playerPosition.x = Math.max(0, playerPosition.x - 1); break;
		case "r": playerPosition.x = Math.min(39, playerPosition.x + 1); break;
	}
	}
	
	public static void schlangenBewegung() {
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