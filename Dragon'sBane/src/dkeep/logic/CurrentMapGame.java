package dkeep.logic;

import java.util.HashMap;
import java.util.Map;

public class CurrentMapGame {
	
	private String[][] map = { 
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

	 
	
	public  String[][] drawMap() {
		 return this.map;
	 }

	public  String[][] updateMap(String[][] map) {
		 return this.map=map;
	 }
	

	public String[][] printMap(String[][] map) {
		
		   for (int i = 0; i < map.length; i++) {

			   for(int k= 0; k < map.length; k++) 
				  		System.out.print(map[i][k]);
			  
			   System.out.println("");
		   
		   }
		   
		return map;   
	}
	
	public void printStoredMap() {
			
			   for (int i = 0; i < map.length; i++) {

				   for(int k= 0; k < map.length; k++) 
					  		System.out.print(map[i][k]);
				  
				   System.out.println("");
			   }
		}
	
	
	
	public static void main(String []args) {
		
		
		
	}

	
}
