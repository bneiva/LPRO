package dkeep.logic;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NewObject {
	protected  int X; 
	protected  int Y;
	
 	int[] positions = null;
 	
 	
 	public int getPositonX() {
 		return this.X;
 	}
 	
 	public int getPositonY() {
 		return this.Y;
 	}

 	
 		
 	
	public  String[][] newObject( String[][] map, String object){
			
		Random randomGenerator = new Random();
		
		while(true) {
    	  int  X = randomGenerator.nextInt(9);
    	  int  Y = randomGenerator.nextInt(9);
      	  	
    	  	if(map[Y][X] != " X")     				 //Wall
    	  		if(map[Y][X] != " S")  				 //Key
    	  			if(map[Y][X] != " E")			 //Exit
    	  				if(map[Y][X] != " H")        //Hero
    	  					if(map[Y-1][X] != " D")	 //Dragon
    	  						if(map[Y+1][X] != " D")
    	  							if(map[Y][X+1] != " D")
    	  								if(map[Y][X-1] != " D")
    	  									if(map[Y][X] != " D") {
    	  										map[Y][X]=object;
    	  										this.X=X;
    	  										this.Y=Y;
    	  										break;
    	  										}
    	 							}
		return map;	
	
		}
	
	
	public int get_X(String[][] map, String Element) {
		for (int i = 0; i < map.length; i++) {
				   for(int k= 0; k < map.length; k++) { 
					  	if(Element.equals(map[i][k])) {
					  		this.X=k;
					  		break;
					  		}
					  	}

				}
			
			if(this.X <0)
				System.out.println("Position Error " + this.X );

			
		return this.X;	
	}
	
	public int get_Y(String[][] map,String Element) {
   
		for (int y = 0; y < map.length; y++) {
			   for(int k= 0; k < map.length; k++) { 
				  	if(Element.equals(map[y][k])) {
				  		this.Y=y;
				  		break;
				  		}
				  	}
		}		
		if(this.Y <0)
			System.out.println("Position Error: " + this.Y );
				
		return this.Y;
	}
	
   public void updatePosition(int X, int Y) {
	   this.X=X;
	   this.Y=Y;
   }
	
	
   public void currentPosition(String[][] map, String object) {
		
		   for (int y = 0; y < map.length; y++) {
			   for(int x= 0; x < map.length; x++) { 
				  	if(map[y][x].equals(object)) {
				  		  this.X=y;
				  		  this.Y=x;
				  		 break;
				  	}
			   }
		   }
   }
				   

}
