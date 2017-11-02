package dkeep.logic;

import java.awt.Point;

public class Hero extends NewObject {
	private int X;
    private int Y;
	private String hero = " H";
	private String hero_armed = " A";
	private int heroState=1;  //0 -> dead | 1-> hero | 2 -> armed_sword
	int state=1;
	
	
	
	public void  State(int dead ) {
		  this.heroState=dead;	
		}
	
	public int curretState() {
			return this.heroState;
			
		}
	
	public String statusHero() {
		
		if(curretState()==2) 
			return " A";
			
		else if(curretState()==1) 
			return " H";
			
		else
			return "  ";
	}
	
	
	
	
	public int hero_X (String[][] map, int keyflag ) { // nao esta a funcionar bem  !!!!!!!!!!!!!!!!!
		
		
		if(keyflag==2) {
			this.X=get_X( map, hero_armed);
			return this.X;
		}
		else { 
			this.X=get_X( map, hero);
			return this.X;
		}
		
	}
		
	public int hero_Y (String[][] map, int keyflag) {  // nao esta a funcionar bem  !!!!!!!!!!!!!!!!! 
	
		
		if(keyflag==2) {
			this.Y=get_Y( map, hero_armed);
			return this.Y;
		}
		else { 
			this.Y=get_Y( map, hero);
			return this.Y;	
			}
		}

	
 public void  heroMovesIntoFreeCell(String[][] map, Point point){
		
		int Y=point.y;
		int X=point.x;
		
		if(map[Y][X] == "  " ) {  // if wall
			map[Y][X]=statusHero(); 
			//return 1;
		}

			//return 0;
			
	}
	
	
		
		
}	
