
public class ZZZZZnake {

	public static void main(String[] args) {
		
		//Startpositionen
		java.awt.Point playerPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		java.awt.Point snakePosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		java.awt.Point firstGoldPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		java.awt.Point secondGoldPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		java.awt.Point doorPosition = new java.awt.Point((int)(Math.random() * 40), (int)(Math.random() * 10));
		boolean rich = false;
		
		//Spielstart
		while(true) {
			//Raster mit Figuren zeichnen
			for(int y = 0; y < 10; y++) {
				for(int x = 0; x < 40; x++) {
					java.awt.Point p = new java.awt.Point(x, y);
					if(playerPosition.equals(p))
						System.out.print("&");
					else if(snakePosition.equals(p))
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
			
			//Status
			if(rich && playerPosition.equals(doorPosition)) {
				System.out.println("Gewonnen!");
				return;
			}
			if(playerPosition.equals(snakePosition)) {
				System.out.println("ZZZZZZZ. Die Schlange hat dich!");
				return;
			}
			if(playerPosition.equals(firstGoldPosition) || playerPosition.equals(secondGoldPosition)) {
				rich = true;
				firstGoldPosition.setLocation(-1, 1);
				secondGoldPosition.setLocation(-1, 1);
			}
			
			//Konsoleneingabe und Spielersteuerung
			switch(new java.util.Scanner(System.in).next()) {
				case "h": playerPosition.y = Math.max(0, playerPosition.y - 1); break;
				case "t": playerPosition.y = Math.min(9, playerPosition.y +1); break;
				case "l": playerPosition.x = Math.max(0, playerPosition.x - 1); break;
				case "r": playerPosition.x = Math.min(39, playerPosition.x + 1); break;
			}
			
			//Schlange bewegt sich in Richtung Spieler
			if(playerPosition.x < snakePosition.x)
				snakePosition.x--;
			else if(playerPosition.x > snakePosition.x)
				snakePosition.x++;
			if(playerPosition.y < snakePosition.y)
				snakePosition.y--;
			else if(playerPosition.y > snakePosition.y)
				snakePosition.y++;
		}		
	}
}
