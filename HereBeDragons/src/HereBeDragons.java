import java.util.Random;
import java.util.Scanner;

public class HereBeDragons {
		
    int heroX; 
    int heroY;
    int keyFlag;
    String [][] map;
	private static Scanner scanner;
    
		public static String[][] drawMap() {
			 String[][] map = { 
					   {" X", " X", " X", " X", " X", " X", " X", " X", " X", " X",} ,
					   {" X", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " X",} ,
					   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
					   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
					   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
					   {" X", "  ", "  ", "  ", "  ", "  ", "  ", " X", "  ", " E",} ,
					   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
					   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} , 
					   {" X", "  ", " X", " X", "  ", "  ", "  ", "  ", "  ", " X",} ,
					   {" X", " X", " X", " X", " X", " X", " X", " X", " X", " X",} , };

			 return map;
		}
		
		
		public void createHero() {
		      
		      Random randomGenerator = new Random();
		      
		      while(true) {
		    	  	heroX = randomGenerator.nextInt(9);
		    	 	heroY = randomGenerator.nextInt(9);
		    	  
		    	 	if(map[heroY][heroX] != " X")
		    	 		if(map[heroY][heroX] != " E")
		    			 	break;
		      }
		      
		      map[heroY][heroX] = " H";
		      
		}
		
		
		public void createDragon() {
		      int dragonX;
		      int dragonY;
		      
		      Random randomGenerator = new Random();
		      
		      while(true) {
		    	  	dragonX = randomGenerator.nextInt(9);
		    	 	dragonY = randomGenerator.nextInt(9);
		    	  
		    	 	if(map[dragonY][dragonX] != " X")
		    	 		if(map[dragonY][dragonX] != " E")
		    	 			if(map[dragonY-1][dragonX] != " H")
		    	 				if(map[dragonY+1][dragonX] != " H")
		    	 					if(map[dragonY][dragonX+1] != " H")
		    	 						if(map[dragonY][dragonX-1] != " H")
		    	 							if(map[dragonY][dragonX] != " H")
		    	 								break;
		      }
		      
		      map[dragonY][dragonX] = " D";
		      
		      
		}
		
		
		public void createKey() {
			  int keyX;
		      int keyY;
		      
		      Random randomGenerator = new Random();
		      
		      while(true) {
		    	  	keyX = randomGenerator.nextInt(9);
		    	 	keyY = randomGenerator.nextInt(9);
		    	  
		    	 	if(map[keyX][keyY] != " X")
		    	 		if(map[keyX][keyY] != " E")
		    	 			if(map[keyX-1][keyY] != " D")
		    	 				if(map[keyX+1][keyY] != " D")
		    	 					if(map[keyX][keyY+1] != " D")
		    	 						if(map[keyX][keyY-1] != " D")
		    	 							if(map[keyX][keyY] != " H")
		    	 								if(map[keyX][keyY] != " D")
		    	 								break;
		      }
		      
		      map[keyX][keyY] = " K";
	
		}
		
		public void printMap() {
			
			   for (int i = 0; i < map.length; i++) {

				   for(int k= 0; k < map.length; k++) 
					  		System.out.print(map[i][k]);
				  
				   System.out.println("");
			   
			   }
			
		}
		
		public int getMove(String direction) {

			if(direction.equals("w")) {
				   heroY--;	   
				   if(map[heroY][heroX] == " X") { 
					   heroY++;
					   return -1;
				   }
				   else if(map[heroY][heroX] == " K") {
					   map[heroY+1][heroX] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 1;		   
				   }
				   
				   else if(map[heroY-1][heroX] == " D" || map[heroY+1][heroX] == " D" || map[heroY][heroX-1] == " D" || map[heroY][heroX+1] == " D") {
					   map[heroY+1][heroX] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return -2;	   
				   }
				   
				   else if(map[heroY][heroX] == " E") {
					   	
					   if(keyFlag == 1) {
						   map[heroY+1][heroX] = "  ";
						   map[heroY][heroX] = " H";
						   printMap();
						   return 2;
					   }
					   else {
						   heroY++;
						   return -3;  
					   }
				   }
				   
				   else {
					   map[heroY+1][heroX] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 0;
				   }	   
			}
			   
			else if( direction.equals("s")) {
				   heroY++;			   
				   if(map[heroY][heroX] == " X") {
					   heroY--;
					   return -1;
				   }   
				   else if(map[heroY][heroX] == " K") {
					   map[heroY-1][heroX] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 1;
				   }  
				   
				   else if(map[heroY-1][heroX] == " D" || map[heroY+1][heroX] == " D" || map[heroY][heroX-1] == " D" || map[heroY][heroX+1] == " D") {
					   map[heroY-1][heroX] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return -2;	   
				   }
				   
				   else if(map[heroY][heroX] == " E") {
					   	
					   if(keyFlag == 1) {
						   map[heroY-1][heroX] = "  ";
						   map[heroY][heroX] = " H";
						   printMap();
						   return 2;
					   }
					   else {
						   heroY--;
						   return -3;  
					   }
				   }
				   else {
					   map[heroY-1][heroX] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 0;
				   }
			   }
			   
			else if( direction.equals("a")) {
				   heroX--;
				   if(map[heroY][heroX] == " X") {
					   heroX++;
					   return -1;
				   }
				   else if(map[heroY][heroX] == " K") {
					   map[heroY][heroX+1] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 1;
				   }
				   else if(map[heroY-1][heroX] == " D" || map[heroY+1][heroX] == " D" || map[heroY][heroX-1] == " D" || map[heroY][heroX+1] == " D") {
					   map[heroY][heroX+1] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return -2;	   
				   }
				   else if(map[heroY][heroX] == " E") {
					   	
					   if(keyFlag == 1) {
						   map[heroY][heroX+1] = "  ";
						   map[heroY][heroX] = " H";
						   printMap();
						   return 2;
					   }
					   else {
						   heroX--;
						   return -3;  
					   }
				   }
				   else {
					   map[heroY][heroX+1] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 0;
				   }
			   }
			   
			else if( direction.equals("d")){
				   heroX++;
				   if(map[heroY][heroX] == " X") {
					   heroX--;
					   return -1;
				   }
				   
				   else if(map[heroY][heroX] == " K") {
					   map[heroY][heroX-1] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 1;
				   }
				   else if(map[heroY][heroX] == " E") {
					   	
					   if(keyFlag == 1) {
						   map[heroY][heroX-1] = "  ";
						   map[heroY][heroX] = " H";
						   printMap();
						   return 2;
					   }
					   else {
						   heroX--;
						   return -3;  
					   }
				   }
				   
				   else if(map[heroY-1][heroX] == " D" || map[heroY+1][heroX] == " D" || map[heroY][heroX-1] == " D" || map[heroY][heroX+1] == " D") {
					   map[heroY][heroX-1] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return -2;	   
				   }

				   else {
					   map[heroY][heroX-1] = "  ";
					   map[heroY][heroX] = " H";
					   printMap();
					   return 0;
				   }
			   }
	
			return 0;
		}
		

	   public static void main(String []args) {
		    
		   
		   
		  System.out.println("Welcome!"); // prints Hello World
		  System.out.println("Loading Map, please wait"); // prints Hello World
		  System.out.println("-----------------"); // prints Hello World
		  System.out.println("-----------------"); // prints Hello World
		  System.out.println("-----------------"); // prints Hello World
		  System.out.println("-----------------"); // prints Hello World
		  System.out.println("Use the Keyboard arrows to control Hero"); // prints Hello World
		  System.out.println("Watch out the dragon...");
		  System.out.println("And dont forget the key!");
		  System.out.println(""); 
		  System.out.println("");

		 HereBeDragons handle = new  HereBeDragons();
		 
		 handle.map=drawMap();
		 handle.createHero();
		 handle.createDragon();
		 handle.createKey(); 
		 handle.printMap();
		 
		 
		 int status;
		 handle.keyFlag = 0;
		 
		 while(true) {
			 
			  scanner = new java.util.Scanner(System.in);
			  String direction = scanner.next();
			   
			  status = handle.getMove(direction);
			  System.out.println("");
			  
			  if(status == 0); // Jogada válida
	
			  else if(status == -1) //Jogada inválida
				  	System.out.println("Invalid move");
			  
			  else if(status == 1) {
				  System.out.println("You just found the key!");
				  handle.keyFlag = 1;
			  }
			  
			  else if(status == -2) {//game over - dragon
				  System.out.println("Game over");
				  break;
			  }
			  
			  else if(status == -3) {//Key miss
				  System.out.println("Pick up the key first!");
		
			  }
			  
			  else if(status == 2) {//win
				  System.out.println("Congratulations! You completed the mmaze");
				  break;
			  }
		 
		 }
	}   
		   
		  
	
}
