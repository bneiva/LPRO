package dkeep.logic;

import java.util.Random;

public class Dragon extends NewObject  {
   
	private int dragon=1; //dragon = 0 is dead 	
	private int number;
	private int asleep=0;
	
	
	
	public Dragon(int number ) {
		this.number=number;
	}

	public int getDragonNumber() {
		return this.number;
	}

	public void  State(int dead ) {
	  this.dragon=dead;	
	}
	public int curretState() {
		return this.dragon;
		
	}
	
	public int  availableMovement(String [][] map ) {
		
		if(map[this.Y][this.X+1]=="  ")
			return 1;
		else if (map[this.Y][this.X-1]=="  ")
			return 1;
		else if(map[this.Y+1][this.X]=="  ")
			return 1;
		else if (map[this.Y-1][this.X]=="  ")
			return 1;
		else
			return 0;

	}
	
	public int asleepDragon() {
		Random randomGenerator = new Random();
		return this.asleep=  randomGenerator.nextInt(3) ;
	}
	

    public String [][] moveDragon(String [][] map){
     int dragonNotMove=1;
    	 
     if(this.dragon==1 && dragonNotMove==0){    	
    	 Random randomGenerator = new Random();
    
    	 if(availableMovement(map)==1 && (this.asleep==0 || map[this.Y][this.X]==" F")) {
    		asleepDragon(); 
    	 	while(true) {
    	 
    	 		int x_radom= 1 - randomGenerator.nextInt(3);
    	 		int y_radom= 1 - randomGenerator.nextInt(3);
    		 
    	 		if( (x_radom==0 && y_radom!=0) || (x_radom!=0 && y_radom==0)) {
    			
    	 			if(map[this.Y+y_radom][this.X+x_radom]=="  ") {
    	 				if(map[this.Y][this.X]==" D") {
    	 					map[this.Y][this.X]="  ";
    	 					map[this.Y+y_radom][this.X+x_radom]=" D";
    	 					this.Y=this.Y+y_radom;
    	 					this.X=this.X+x_radom;
    	 					break;
    	 					}
    	 				else if(map[this.Y][this.X]==" F") {
    	 					map[this.Y][this.X]=" S";
    	 					map[this.Y+y_radom][this.X+x_radom]=" D";
    	 					this.Y=this.Y+y_radom;
    	 					this.X=this.X+x_radom;
    	 					break;
    		 				}
    	 				else if(map[this.Y][this.X]==" d") {
    	 					map[this.Y][this.X]="  ";
    	 					map[this.Y+y_radom][this.X+x_radom]=" D";
    	 					this.Y=this.Y+y_radom;
    	 					this.X=this.X+x_radom;
    	 					break;
    		 				}
    	 			}
    		 	
    	 			else if(map[this.Y+y_radom][this.X+x_radom]==" S") {
    	 				map[this.Y][this.X]="  ";
    	 				map[this.Y+y_radom][this.X+x_radom]=" F";
    	 				this.Y=this.Y+y_radom;
    	 				this.X=this.X+x_radom;
    	 				break;
    		 			}
    	 		}
    	 	}
    	 }
    	 else if(this.asleep>0 && map[this.Y][this.X]!=" F" ) {
    	
    		   
    		 	map[this.Y][this.X]= " d";
    		 	
    		 	this.asleep--;
    	 }
    		 
    	 else
    		 System.out.println("Dragon cannot move ;) ");
    	 
    	 
     	}
     return map;
    }
    
}