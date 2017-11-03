package dkeep.logic;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dkeep.cli.GameLoop;

public class HeroTest {
	
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

	/*private String[][] map = { 
			   {" X", " X", " X", " X", " X", " X", " X", " X", " X", " X",} ,
			   {" X", "  ", "  ", "  ", "  ", "  ", "  ", "  ", " H", " X",} ,
			   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
			   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
			   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
			   {" X", "  ", "  ", "  ", "  ", "  ", "  ", " X", "  ", " E",} ,
			   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} ,
			   {" X", "  ", " X", " X", "  ", " X", "  ", " X", "  ", " X",} , 
			   {" X", " S", " X", " X", "  ", "  ", "  ", " D", "  ", " X",} ,
			   {" X", " X", " X", " X", " X", " X", " X", " X", " X", " X",} , };
	*/
	
	private CurrentMapGame maze=new  CurrentMapGame();
	private Sword sword = new Sword();
	private StateOfTheGame stateGame= new StateOfTheGame();
	private Hero hero = new Hero();
	private GameLoop gameLogic = new  GameLoop();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		

		/*CurrentMapGame maze=new  CurrentMapGame();
		maze.updateMap(map);
		
		StateOfTheGame stateGame= new StateOfTheGame();
		
		// Create a sword 
		Sword sword = new Sword();
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(7,8));

		//create a hero in current possition	
		Hero hero = new Hero();
		hero.updateCoordinates(map, " H",new Point(8,1));
	  
		System.out.println("current situation"); 
		maze.printMap(maze.drawMap());
		*/
 
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHeroMovesToFreeCell() {

		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(7,8));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,1));
	  
		System.out.println("current situation"); 
		//maze.printMap(maze.drawMap());
		
		assertEquals(new Point(8,1),hero.getCoordinates());
		gameLogic.getMove("a", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		//maze.printMap(maze.drawMap());
		assertEquals(new Point(7,1),hero.getCoordinates());  //move to another cell
	}
	

	@Test
	public void testHeroMovesToWall() {
		
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(7,8));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,1));
	  
		System.out.println("current situation"); 
		maze.printMap(maze.drawMap());
		
		
		assertEquals(new Point(8,1),hero.getCoordinates());
		gameLogic.getMove("d", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		assertEquals(new Point(8,1),hero.getCoordinates());  // stay in the same cell
		
	}

	@Test
	public void testHeroReachSword() {
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(7,1));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(7,8));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,1));
	  
		System.out.println("current situation"); 
		//maze.printMap(maze.drawMap());
		
		assertEquals(" H",hero.statusHero());
		gameLogic.getMove("a", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		//maze.printMap(maze.drawMap());
		assertEquals(" A",hero.statusHero());  // stay in the same cell
		
	}

	@Test
	public void testHeroUnarmedFindDragon() {
		
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(6,1));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,1));
	  
		System.out.println("current situation"); 
		//maze.printMap(maze.drawMap());
		
		assertEquals(1,hero.curretState());
		gameLogic.getMove("a", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		//maze.printMap(maze.drawMap());
		assertEquals(0,hero.curretState());// hero dead
		
	}

	@Test
	public void testHeroArmedSlaysDragon() {
maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(6,1));

		//create a hero in current possition	
		hero.updateCoordinates(map, " A", new Point(8,1));
	  
		System.out.println("current situation"); 
		//maze.printMap(maze.drawMap());
		
		assertEquals(1,CurrentDragon.curretState());  //dragon state=1 
		gameLogic.getMove("a", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		//maze.printMap(maze.drawMap());
		assertEquals(0,CurrentDragon.curretState());// dragon dead -> state=0
		
	}

	@Test
	public void testHeroArmedMovesToExitAfterKillDragon() {
		
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(8,4));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(8,3));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,5));
	  
		System.out.println("current situation .........................."); 
		maze.printMap(maze.drawMap());
		
		
		assertEquals(1,stateGame.getNumberOfDragons());  //dragon state=1 
		gameLogic.getMove("w", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		assertEquals(0,stateGame.getNumberOfDragons());  //dragon state=1 
		gameLogic.getMove("s", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		gameLogic.getMove("d", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		//assertEquals(0,CurrentDragon.curretState());// dragon dead -> state=0
		assertEquals(2,gameLogic.getStatusGame());  // if win satus equal to 2
	}

	@Test
	public void testHeroExitWithoutSword() {
		
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(8,3));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,5));
	  
		System.out.println("current situation .........................."); 
		maze.printMap(maze.drawMap());
		
		
		assertEquals(1,sword.getState());  //dragon state=1 
		gameLogic.getMove("d", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		//assertEquals(0,CurrentDragon.curretState());// dragon dead -> state=0
		assertEquals(-3,gameLogic.getStatusGame());  // if win status=-3 without kill dragons or without sword
		assertEquals(1,sword.getState());  //dragon state=1 
	}

	@Test
	public void testHeroArmedWithoutKillDragons() {
	
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(8,4));
				
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
				
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
				
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " D", new Point(8,1));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,5));
			  
		System.out.println("current situation .........................."); 
		//maze.printMap(maze.drawMap());
				
		assertEquals(1,stateGame.getNumberOfDragons());    //dragon state=1 
		assertEquals(1,sword.getState());  //dragon state=1 
		gameLogic.getMove("w", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		gameLogic.getMove("s", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		gameLogic.getMove("d", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		//assertEquals(0,CurrentDragon.curretState());// dragon dead -> state=0
		assertEquals(-3,gameLogic.getStatusGame());  // if win status=-3 without kill dragons or without sword
		assertEquals(1,stateGame.getNumberOfDragons());  
		assertEquals(0,sword.getState());  //dragon state=1 
			}

	@Test
	public void testHeroMovesToSleepyDradon() {
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(1,8));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " d", new Point(8,3));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,5));
	  
		System.out.println("current situation .........................."); 
		maze.printMap(maze.drawMap());
		
		
		assertEquals(1,hero.curretState());  //dragon state=1 
		gameLogic.getMove("w", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		assertEquals(1,hero.curretState());  //dragon state=1 
	}

	@Test
	public void testArmedHeroKillSleepyDragon() {
		maze.updateMap(map);
		
		// Create a sword 
		sword.updateCoordinates(map, " S", new Point(8,4));
		
		//Create a dragon in current possition
		List<Dragon> dragoes = new ArrayList<Dragon>();
		String numberDragons="1";
		
		stateGame.numberOfDragons(Integer.parseInt(numberDragons));
		dragoes.add(new Dragon(0));
		
		Dragon CurrentDragon=dragoes.get(0);
		CurrentDragon.updateCoordinates(map, " d", new Point(8,3));

		//create a hero in current possition	
		hero.updateCoordinates(map, " H", new Point(8,5));
	  
		System.out.println("current situation .........................."); 
		maze.printMap(maze.drawMap());
		
		
		assertEquals(1,stateGame.getNumberOfDragons());  //dragon state=1 
		assertEquals(1,CurrentDragon.curretState());
		gameLogic.getMove("w", maze.drawMap(), hero, stateGame, (ArrayList<Dragon>) dragoes, sword);
		maze.printMap(maze.drawMap());
		assertEquals(0,stateGame.getNumberOfDragons());  //dragon state=1  
		assertEquals(0,CurrentDragon.curretState());//dragon state=1  
	}


}
