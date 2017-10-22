package dkeep.cli;

import dkeep.logic.*;

import java.util.*;

public class GameLoop {
	
    static int status=0;   // global variavel

private static Scanner scanner;
static String direction;

public int win_lose(String [][] map, Dragon dragon, Hero hero, StateOfTheGame state){
 
	int X = hero.hero_X(map, hero.curretState());  //??????
 	int Y = hero.hero_Y(map, hero.curretState());  //?????
 	
   // situaçao pos-move
	if(map[Y-1][X] == " D" || map[Y+1][X] == " D" || map[Y][X-1] == " D" || map[Y][X+1] == " D" ||
	   map[Y-1][X] == " F" || map[Y+1][X] == " F" || map[Y][X-1] == " F" || map[Y][X+1] == " F"||
	   map[Y-1][X] == " d" || map[Y+1][X] == " d" || map[Y][X-1] == " d" || map[Y][X+1] == " d") {
		  System.out.println("inside win lose down");
		
		  if(map[Y][X]==" A") {
			  dragon.State(0);  // dragon dead
			  state.NumberOfDeadDragons();
			  System.out.println("inside win lose");
			  
			  if(map[Y-1][X] == " D" || map[Y-1][X] == " d") {
				  map[Y-1][X] = "  ";
				  return status = 3; 
			  	}
			  else if(map[Y+1][X] == " D" || map[Y+1][X] == " d") {
				  map[Y+1][X] = "  ";
				  return  status = 3; 
		  		}
			  else if(map[Y][X-1] == " D" || map[Y][X-1] == " d") {
				  map[Y][X-1] = "  ";
		  		  return  status = 3; 
	  			}
			  else if(map[Y][X+1] == " D" || map[Y][X+1] == " d") {
				  map[Y][X+1] = "  ";
	   			  return status = 3; 
					}
				}		
		  else if(map[Y][X]==" H") {
			  
			  if(map[Y-1][X] == " D" || map[Y-1][X] == " F") {
				  hero.State(0);  //hero dead
				  return status = -2; 	// match with the dragon -> game over
			  	}
			  else if(map[Y+1][X] == " D" || map[Y+1][X] == " F") {
				  hero.State(0);  //hero dead
				  return status = -2; 	// match with the dragon -> game over 
		  		}
			  else if(map[Y][X-1] == " D" || map[Y][X-1] == " F") {
				  hero.State(0);  //hero dead
				  return status = -2; 	// match with the dragon -> game over 
	  			}
			  else if(map[Y][X+1] == " D" || map[Y][X+1] == " F") {
				  hero.State(0);  //hero dead
				  return status = -2; 	// match with the dragon -> game over
						}
				  }
			  
		   }
	
 	return 0;
 
   }



public int armedHero(String [][] map , int Y, int X, Hero hero) {
	
	 int heroX = hero.hero_X(map, hero.curretState());
	 int heroY = hero.hero_Y(map, hero.curretState()); 
	 
	
		if(map[Y-1][X] == " D" || map[Y-1][X] == " d") {
		   map[Y-1][X] = "  ";
		   map[heroY][heroX] = "  ";
		   map[Y][X] = " A";
		    return status = 3; 
	   	}

	   	else if(map[Y+1][X] == " D" || map[Y+1][X] == " d") {
	   		map[Y+1][X] = "  ";
	   		map[heroY][heroX] = "  ";
	   		map[Y][X] = " A";
	   		return status = 3; 
	   	}
 
	   	else if(map[Y][X-1] == " D" || map[Y][X-1] == " d") {
	   		map[Y][X-1] = "  ";
	   		map[heroY][heroX] = "  ";
	   		map[Y][X] = " A";
	   		return status = 3; 
	    }
	   	
	   	else if(map[Y][X+1] == " D" || map[Y][X+1] == " d") {
	   		map[Y][X+1] = "  ";
	   		map[heroY][heroX] = "  ";
	   		map[Y][X] = " A";
	   		return status = 3; 
		}
	
	return 0;
} 
public void killOrDie(String [][] map, int Y, int X, ArrayList<Dragon> dragon, StateOfTheGame state, Hero hero ) {
	
	 int heroX = hero.hero_X(map, hero.curretState());
	 int heroY = hero.hero_Y(map, hero.curretState());
	 
	  // x and Y desired positions-> heroY+moveY=Y  : heroX+moveX=X 
	 
	 if(map[heroY][heroX]==" A") {
		 for(int i=0; i <dragon.size(); i++ ) {
			 if(dragon.get(i).getPositonX()==X || dragon.get(i).getPositonY()==Y) {//?????
			   dragon.get(i).State(0);  // dragon dead
			   dragon.remove(i);  // mal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			   state.NumberOfDeadDragons();
			   armedHero(map,Y, X, hero); 
			   break;
			 }
			 else {
				 System.out.println("dragon.get(i).getPositonX() " + dragon.get(i).getPositonX());
			 	 System.out.println("dragon.get(i).getPositonY() " + dragon.get(i).getPositonY());
			 }
			  
			  
		 }
	 	}		
	  
	 	else if(map[heroY][heroX]==" H") {
	 			map[heroY][heroX] = "  ";
	 			map[Y][X] = " H";
	 			hero.State(0);  //hero dead
	 			status = -2;
	 	}
		   
	}
public void killOrDieWithAsleepDragon(String [][] map, int Y, int X, ArrayList<Dragon> dragon, StateOfTheGame state, Hero hero ) {
	
	 int heroX = hero.hero_X(map, hero.curretState());
	 int heroY = hero.hero_Y(map, hero.curretState());
	 
	  // x and Y desired positions-> heroY+moveY=Y  : heroX+moveX=X 
	 
	 if(map[heroY][heroX]==" A") {
		 for(int i=0; i <dragon.size(); i++ ) {
			 if((dragon.get(i).getPositonY()==(Y+1)) && (dragon.get(i).getPositonX()==X)) {//?????
				System.out.println("inside if");
			   dragon.get(i).State(0);  // dragon dead
			   dragon.remove(i);  // mal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			   state.NumberOfDeadDragons();
			   armedHero(map,Y, X, hero); 
			   break;
			 }
			 else if((dragon.get(i).getPositonY()==(Y-1)) && (dragon.get(i).getPositonX()==X)) {//?????
					System.out.println("inside if");
					   dragon.get(i).State(0);  // dragon dead
					   dragon.remove(i);  // mal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					   state.NumberOfDeadDragons();
					   armedHero(map,Y, X, hero); 
					   break;
					 }
			 else if((dragon.get(i).getPositonY()==Y) && (dragon.get(i).getPositonX()==(X+1))) {//?????
					System.out.println("inside if");
					   dragon.get(i).State(0);  // dragon dead
					   dragon.remove(i);  // mal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					   state.NumberOfDeadDragons();
					   armedHero(map,Y, X, hero); 
					   break;
					 }
			 else if((dragon.get(i).getPositonY()==Y) && (dragon.get(i).getPositonX()==(X-1))) {//?????
					System.out.println("inside if");
					   dragon.get(i).State(0);  // dragon dead
					   dragon.remove(i);  // mal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					   state.NumberOfDeadDragons();
					   armedHero(map,Y, X, hero); 
					   break;
					 }
			 else {
				 System.out.println("dragon.get(i).getPositonX() " + dragon.get(i).getPositonX());
			 	 System.out.println("dragon.get(i).getPositonY() " + dragon.get(i).getPositonY());
			 }
			  
		 }
	 	}		
	  
	 	else if(map[heroY][heroX]==" H") {
	 			map[heroY][heroX] = "  ";
	 			map[Y][X] = " H";
	 			//hero.State(0);  //hero dead
	 			//status = -2;
	 	}
		   
	}

    public String[][] getMove(String direction,  String[][] map, Hero hero, StateOfTheGame state, ArrayList<Dragon> dragon) {   // tem de receber como argumento o mapa
		
	 int X = hero.hero_X(map, hero.curretState());
	 int Y = hero.hero_Y(map, hero.curretState()); 
	 
		if(direction.equals("w")) {
			   Y--;
			   if(map[Y][X] == " X" || map[Y][X] == " d") {  // if wall
				   Y++;  // nao mexer
				   
				   status = -1;
				   return map;  
			   }
			   else if(map[Y][X] == " S") {  //  if hero find the sword
				   map[Y+1][X] = "  ";
				   map[Y][X] = " A";
				   hero.State(2);
				   
				  for(int i=0; i <dragon.size(); i++ ) { 

					  if(win_lose(map,dragon.get(i),hero, state)!=0) {
						  if(status==3) 
							  dragon.remove(i);
						  
					   return map;  
					   }
				  }
					
				  for(int i=0; i <dragon.size(); i++ ) {
					  map=dragon.get(i).moveDragon(map);
				   
					  if(win_lose(map,dragon.get(i),hero, state)!=0) {
						  if(status==3) 
							  dragon.remove(i);

						  return map;  //???????  if kill 2 dragons in the same position
					   }
				  } 
				status = 1;
				return map;  //  valid move
				  
			   }
			   
			   else if(map[Y-1][X] == " D" || map[Y+1][X] == " D" || map[Y][X-1] == " D" || map[Y][X+1] == " D" ||
					   map[Y-1][X] == " F" || map[Y+1][X] == " F" || map[Y][X-1] == " F" || map[Y][X+1] == " F") {
				  
				   killOrDie(map,Y,X, dragon, state, hero);
			   }
		   
			   else if( map[Y-1][X] == " d" || map[Y+1][X] == " d" || map[Y][X-1] == " d" || map[Y][X+1] == " d") {
				   System.out.println("ddddddddddddddddddd");
				   killOrDieWithAsleepDragon(map, Y, X, dragon, state, hero );
				
			   }
			   else if(map[Y][X] == " E") {
			   
				   if(state.getNumberOfDragons()==0) {  // if have the killed the dragon and reach the exit
					   map[Y+1][X] = "  ";
					   map[Y][X] = " A";
					   status = 2;
					   return map;  // win
				   }
				   else {
					   Y++;
					   status = -3;
					   return map;  // kill the dragon first, before exit  
				   }
			   
			}
			   
			else {
				
				if(map[Y+1][X] == " A") {
					   map[Y+1][X] = "  ";
					   map[Y][X] = " A";
					   
					   for(int i=0; i <dragon.size(); i++ ) { 
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3) {
								   dragon.remove(i);
							   }
								   
							   //return map;
						   }
					   }
					   System.out.println("ddddddddddddddddddd");
					   
					   for(int i=0; i <dragon.size(); i++ ) { 
						   map=dragon.get(i).moveDragon(map);
						   
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   //return map;
						   }
					   }
					   status = 0;
					   return map;  // going on
				   	}
				
				   else if(map[Y+1][X] == " H") {
					   map[Y+1][X] = "  ";
					   map[Y][X] = " H";
					   
					   for(int i=0; i <dragon.size(); i++ ) { 
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   for(int i=0; i <dragon.size(); i++ ) { 
						   map=dragon.get(i).moveDragon(map);
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   status = 0;
					   return map;  // going on
					   
				   }
			   }	   
		}
		   
		else if( direction.equals("s")) {    // move back
			   Y++;			   
			   if(map[Y][X] == " X" || map[Y][X] == " d") {
				   Y--;  // nao mexer
				   status = -1;
				   return map;  // find wall
			   }   
			   else if(map[Y][X] == " S") { // if find the key
				   map[Y-1][X] = "  ";
				   map[Y][X] = " A";
				   hero.State(2);
				   
				   for(int i=0; i <dragon.size(); i++ ) { 
					   if(win_lose(map,dragon.get(i),hero, state)!=0) {
						   
						   if(status==3)
							   dragon.remove(i);
							   
						   return map;
					   }
				   }
				   
				   for(int i=0; i <dragon.size(); i++ ) { 
					   map=dragon.get(i).moveDragon(map);

					   if(win_lose(map,dragon.get(i),hero, state)!=0) {
						   
						   if(status==3)
							   dragon.remove(i);
							   
						   return map;
					   }
				   }
				   status = 1;
				   return map;  // continue the game
			   }  
			   
			   else if(map[Y-1][X] == " D" || map[Y+1][X] == " D" || map[Y][X-1] == " D" || map[Y][X+1] == " D" ||
					   map[Y-1][X] == " F" || map[Y+1][X] == " F" || map[Y][X-1] == " F" || map[Y][X+1] == " F" ) {
				  
				   killOrDie(map,Y,X, dragon, state, hero);
			   }
			   else if( map[Y-1][X] == " d" || map[Y+1][X] == " d" || map[Y][X-1] == " d" || map[Y][X+1] == " d") {
				   System.out.println("ddddddddddddddddddd");
				   killOrDieWithAsleepDragon(map, Y, X, dragon, state, hero );
					
				}
			   else if(map[Y][X] == " E") {  // if exit
				   if(state.getNumberOfDragons()==0) {
					   map[Y-1][X] = "  ";
					   map[Y][X] = " A";
					   status = 2;
					   return map;
				   }
				   else {
					   Y--;
					   status = -3;
					   return map;
					   
				   }
			  }
			   else {   					// empty space
				   if(map[Y-1][X] ==" A") {
					   map[Y-1][X] = "  ";
					   map[Y][X] = " A";
					   
					   for(int i=0; i <dragon.size(); i++ ) { 
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   System.out.println("ddddddddddddddddddd");
					   for(int i=0; i <dragon.size(); i++ ) { 
						   
						   map=dragon.get(i).moveDragon(map);
						   
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					
					   status = 0;
					   return map;  // going on
				   	}
				   else if(map[Y-1][X] ==" H") {
					   map[Y-1][X] = "  ";
					   map[Y][X] = " H";
					   
					   for(int i=0; i <dragon.size(); i++ ) {  	
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   
					   for(int i=0; i <dragon.size(); i++ ) {  
						   map=dragon.get(i).moveDragon(map);
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   status = 0;
					   return map;  // going on
				   }
			   }
		   }
		   
		else if( direction.equals("a")) {  // move left
			   X--;
			   if(map[Y][X] == " X" || map[Y][X] == " d" ) {   // finds a wall 
				   X++;
				   status = -1;
				   return map;
			   }
			   else if(map[Y][X] == " S") {  // find a key
				   map[Y][X+1] = "  ";
				   map[Y][X] = " A";
				   hero.State(2);
				   
				   for(int i=0; i <dragon.size(); i++ ) {  	
					   if(win_lose(map,dragon.get(i),hero, state)!=0) {
						   
						   if(status==3)
							   dragon.remove(i);
							   
						   return map;
					   }
				   }
				
				   for(int i=0; i <dragon.size(); i++ ) {  	
					   map=dragon.get(i).moveDragon(map);
					   if(win_lose(map,dragon.get(i),hero, state)!=0) {
						   
						   if(status==3)
							   dragon.remove(i);
							   
						   return map;
					   }
				   }
				   status = 1;
				   return map;
			   }
			   else if(map[Y-1][X] == " D" || map[Y+1][X] == " D" || map[Y][X-1] == " D" || map[Y][X+1] == " D" ||
					   map[Y-1][X] == " F" || map[Y+1][X] == " F" || map[Y][X-1] == " F" || map[Y][X+1] == " F") {
				  
				   killOrDie(map,Y,X, dragon, state, hero);
			   }
			   else if( map[Y-1][X] == " d" || map[Y+1][X] == " d" || map[Y][X-1] == " d" || map[Y][X+1] == " d") {
				   System.out.println("ddddddddddddddddddd");
				   killOrDieWithAsleepDragon(map, Y, X, dragon, state, hero );
					
				}
			   
			   else if(map[Y][X] == " E") {
				 
				   if(state.getNumberOfDragons()==0) {
					   map[Y][X+1] = "  ";
					   map[Y][X] = " A";
					   status = 2;
					   return map;
				   }
				   else {
					   X--;
					   status = -3;
					   return map;
					   
				   }
			   }
			   else {     // empt
				   if(map[Y][X+1] ==" A") {
					   map[Y][X+1] = "  ";
					   map[Y][X] = " A";
					   
					   for(int i=0; i <dragon.size(); i++ ) { 
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							  // return map;
						   }
					   }
					   
					   System.out.println("ddddddddddddddddddd");
					   for(int i=0; i <dragon.size(); i++ ) { 
						   
						   map=dragon.get(i).moveDragon(map);

						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   //return map;
						   }
					   }
			
					   status = 0;
					   return map;  // going on
				   	}
				   else  if(map[Y][X+1] ==" H") {
					   map[Y][X+1] = "  ";
					   map[Y][X] = " H";
					   
					   for(int i=0; i <dragon.size(); i++ ) {   	
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }

					   for(int i=0; i <dragon.size(); i++ ) {   	
						   map=dragon.get(i).moveDragon(map);
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   
					   status = 0;
					   return map;  // going on
				   }
			   }
		   }
		   
		else if( direction.equals("d")){   // take the right
			   X++;
			   if(map[Y][X] == " X" || map[Y][X] == " d") {
				   X--;
				   status = -1;
				   return map;
			   }
			   
			   else if(map[Y][X] == " S") {
				   map[Y][X-1] = "  ";
				   map[Y][X] = " A";
				   hero.State(2);
				   
				   for(int i=0; i <dragon.size(); i++ ) { 
					   if(win_lose(map,dragon.get(i),hero, state)!=0) {
						   
						   if(status==3)
							   dragon.remove(i);
							   
						   return map;
					   }
				   }
				   
				   for(int i=0; i <dragon.size(); i++ ) { 				   
					   map=dragon.get(i).moveDragon(map);
					   status = 1;  // ??????????????????????????
					   if(win_lose(map,dragon.get(i),hero, state)!=0) {
						   
						   if(status==3)
							   dragon.remove(i);
							   
						   return map;
					   }
				   }
				   return map;
			   }
			   else if(map[Y][X] == " E") {
				  
					   if(state.getNumberOfDragons()==0) {
						   map[Y][X-1] = "  ";
						   map[Y][X] = " A";
						   status = 2;
						   return map;
					   }
					   else {
						   X--;
						   status = -3;
						   return map;
					   }
			   }
			   
			   else if(map[Y-1][X] == " D" || map[Y+1][X] == " D" || map[Y][X-1] == " D" || map[Y][X+1] == " D" ||
					   map[Y-1][X] == " F" || map[Y+1][X] == " F" || map[Y][X-1] == " F" || map[Y][X+1] == " F") {
				
				   killOrDie(map,Y,X, dragon, state, hero);
			   	}
			   else if( map[Y-1][X] == " d" || map[Y+1][X] == " d" || map[Y][X-1] == " d" || map[Y][X+1] == " d") {
				   System.out.println("ddddddddddddddddddd");
				   killOrDieWithAsleepDragon(map, Y, X, dragon, state, hero );
					
				}

			   else {
				   if(map[Y][X-1] ==" A") {
					   map[Y][X-1] = "  ";
					   map[Y][X] = " A";
					   
					   for(int i=0; i <dragon.size(); i++ ) { 
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   if(status==3)
								   dragon.remove(i);
							   //return map;
						   }
					   }
					   System.out.println("ddddddddddddddddddd");
					   for(int i=0; i <dragon.size(); i++ ) { 
						   
						   map=dragon.get(i).moveDragon(map);
						   
						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   if(status==3)
								   dragon.remove(i);
							   //return map;
						   }
					   }
					   status = 0;
					   
					   return map;  // going on
				   	}
				   else   if(map[Y][X-1] ==" H") {
					   map[Y][X-1] = "  ";
					   map[Y][X] = " H";
					   System.out.println("entalado movimento livre  fim");
					   
					   for(int i=0; i <dragon.size(); i++ ) {     

						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   }
					   System.out.println("entalado movimento livre  meio");
					   for(int i=0; i <dragon.size(); i++ ) { 
						   map=dragon.get(i).moveDragon(map);

						   if(win_lose(map,dragon.get(i),hero, state)!=0) {
							   
							   if(status==3)
								   dragon.remove(i);
								   
							   return map;
						   }
					   	
					   }
					   status = 0;
					   System.out.println("entalado movimento livre  fim");
					   return map;  // going on
					   }
				   }
			   }
			return map;
		}		
	


public static void main(String []args) {
    	  
	 scanner = new java.util.Scanner(System.in);
	   
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
  
  
	  GameLoop handle = new  GameLoop();
	  CurrentMapGame maze=new  CurrentMapGame();
	  StateOfTheGame stateGame= new StateOfTheGame();  

	  // cretate a dragon
  
	  Sword sword = new Sword();
	  sword.newObject(maze.drawMap()," S");
  
	  // create a dragon
	  //  new code
	  List<Dragon> dragoes = new ArrayList<Dragon>();
	  System.out.print("how many dragons do you want :  ");
	  String numberDragons=scanner.next();
	  
	  stateGame.numberOfDragons(Integer.parseInt(numberDragons));
  
	  for(int i=0; i<Integer.parseInt(numberDragons); i++) {
		  dragoes.add(new Dragon(i));
	  }
  
	  for(int i=0; i<Integer.parseInt(numberDragons); i++) {
		  Dragon CurrentDragon=dragoes.get(i);
		  CurrentDragon.newObject(maze.drawMap(), " D");
	  }
  
  
	  // create a hero
	  Hero hero = new Hero();
	  hero.newObject(maze.drawMap(), " H");
  
	  System.out.println("current situation"); 
	  //  print initial map of the game
	  maze.printMap(maze.drawMap());

	  while( stateGame.currentStateOfTheGame(status)!=-2 
		  &&  stateGame.currentStateOfTheGame(status)!=2 ) {
		  
		  System.out.print("Next move(a w s d) : ");
		  direction = scanner.next();  // ask for new position
		  //System.out.println(" status: " + status);
		  String [][]currentMap = handle.getMove(direction, maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes);
		  maze.printMap(currentMap);
	  		} 
	  }	
}



