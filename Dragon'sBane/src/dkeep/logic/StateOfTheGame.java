package dkeep.logic;

public class StateOfTheGame {
	//1-> means alive
	//0-> means dead
	private int dragon_alive=1;
	private int hero=1; //hero=0  hero dead
	private int numberOfDragons=0;	
	private int status;
	
	
	public void  numberOfDragons(int number) {
		 this.numberOfDragons=number;
	}
	
	public int getNumberOfDragons() {
		return this.numberOfDragons;
	}
	
	public int NumberOfDeadDragons() {
		return this.numberOfDragons--;
	}
	
	public int getStatusGame(){
		return this.status;
	}
	
	
	
	
	 
	public int currentStateOfTheGame(int status){
	
		  System.out.println("");
		  
		  if(status == 0); 
		  				
		  	else if(status == -1){ //Jogada inválida, 
		  			System.out.println("Invalid move");
		  			return this.status=-1;
		  		}
		  			
		  		else if(status == 1) {
		  			System.out.println("You just found the your sword! Fight!!");
		  			this.hero=2;
		  			return this.status=1;
		  			}
		  
		  			else if(status == -2) {//game over - dragon
		  				System.out.println("Game over :(");
		  				this.hero=0;
		  				return this.status=-2;
		  				}
		  
		  				else if(status == -3) {//Key miss
		  					System.out.println("Kill the dragon before leave! ");
		  					}
		  				
		  					else if(status == 2) {//win
		  						System.out.println("Congratulations! You completed the mmaze :)");
		  						return this.status=2;
		  						}
		  						
		  						else if(status == 3) {
		  						System.out.println("Congratulations! You killed the dragon");
		  						this.dragon_alive=0;
	  							return this.status=3;
		  							}
		  						
		  							else
		  								System.out.println("Carefull!! something went outside the range of the game");
		  								return this.status=0;
	 	}
	
	
	public static void main(String []args) {
		
		
	}

}
