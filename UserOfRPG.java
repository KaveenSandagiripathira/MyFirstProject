/* In the following game, the player fights
a horde of monsters one by one. The horde is a colleciton of monsters
which is randomly populated with subclasses of monster.
The size of the horde (Length of the collection) depends on the difficulty. 
	*/



import java.io.*;
import java.util.*;

public class UserOfRPG //hw3C#0
{
	//Initializing three main "game" variables.
    private Protagonist pat; 
	private Monster[] horde; 
	private Monster hordeBoss;  
	
	//Game Settings
    private int moveCount;
    private boolean gameOver;
    private int difficulty;

	//Scanner Settings
    private InputStreamReader isr;
    private BufferedReader in;
	
    public UserOfRPG() {
        moveCount = 0;
        gameOver = false;
        isr = new InputStreamReader( System.in );
        in = new BufferedReader( isr );
        newGame();
    }
	
    public static void main( String[] args ) {
        UserOfRPG game = new UserOfRPG(); //Stores reference to new 'game' in game

        int encounters = 0; //Tracking the amount of monster encounters the player has had
		
		/* The following while loop makes sure the game doesn't end until the horde
		, the colleciton of monsters, has been defeated */
        while(encounters < game.horde.length && game.pat.isAlive()){  //Checks if horde is empty and if protagonist is alive
            game.playTurn(game.horde[encounters]); //hw3E#0
            encounters++; 
            System.out.println();
        }
		
		/* Every game has a boss (leader) monster which is of variable type Monster. 
		After the collection of monsters has been defeated, the player has a chance
		based on the difficulty to fight a boss monster which can be of object type any
		subclass of monster but with more health. This demonstrates polymorphism because
        the boss monster may either be a Slime,Dragon or Vampire depending on the output
        of Math.random()		*/
		
		if(Math.random() <= ( game.difficulty / 5.0 ) && game.pat.isAlive()){ //Random chance for a boss monster to appear, also protagonist must be alive
			System.out.println("Just as thou thought thou won the broil the leader of the horde appears stronger than any monster thou fought ere");
			int encounterChoice = (int)(Math.random() * 11);
			if (encounterChoice <= 11)
				game.hordeBoss = new Dragon(); 
			else if (encounterChoice <= 22)
				game.hordeBoss = new Slime(); 
			else 
				game.hordeBoss = new Vampire(); 
			
			game.hordeBoss.lowerHP(-100); //Gives boss monster more health thus making it stronger //hw44#3,4 Inherits lowerHP
			game.playTurn(game.hordeBoss); //Iniates battle with a subclass boss monster. //hw3E#0
		}
        System.out.println( "Thy game doth be over"	); 
    }
	/* 
	===============================
	Sets up game including asking for the users role, the difficulty
	and randomly generating the monsters in the horde.
	
	Is called automatically by the constructor of UserOfRPG as in the original code.
	===============================
	*/
    public void newGame() {
        String s;
        String name = "";
        s = "~~~ Welcome to Ye Olde RPG! ~~~\n";
		/* The difficulty selected by the user will determine the size of the horde
		collection and thus how many monsters the player will need to fight before
		winning */
        s += "\nChoose your difficulty: \n";
        s += "\t1: A Small horde you face\n";
        s += "\t2: Not so easy\n";
        s += "\t3: Tis a big horde, prepare yourself\n";
		s += "\t4: Thy should prepare to be slain\n";
        s += "Selection: ";
        System.out.print( s );

        try {
            difficulty = Integer.parseInt( in.readLine() );
        } catch ( IOException e ) { }
		//Gets Name
        s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
        System.out.print( s );

        try {
            name = in.readLine();
        } catch ( IOException e ) { }
		
		/* Allows player to choose a subclass of Protagonist to play as.
		Because pat is of variable type Protagonist, the object type of pat 
		may either be Jedi, TurtleMan or DragonBorn depending on user input.*/
		
        s = "What speciality doth thy prefer?\n";  //hw44#6
        s += "\t1: Jedi, a valiant fighter" + System.lineSeparator();
        s += "\t2: TurtleMan, good at hiding not much at attacking" + System.lineSeparator();
        s += "\t3: DragonBorn, beefy and with the strength of a dragon" + System.lineSeparator();
        System.out.println( s );
        int protype = 0;
        try {
            protype = Integer.parseInt( in.readLine() );
        } catch( IOException e) {}

       //Assigning the player the role he has chosen
        if (protype == 1) pat = new Jedi( name );
        else if (protype == 2) pat = new TurtleMan( name );
        else pat = new DragonBorn( name );
		
		System.out.println(pat); //hw46#1,2
		
		horde = new Monster[difficulty]; //Creates collection of monsters with size equal to difficulty
		/* Since the variable type or horde is Monster[] it may be populated of Dragons, Slimes or Vampires.
		This is one of the many uses of polymorphism and its flexibility */
		for (int i = 0; i < horde.length; i++){ //Randomly populates monster array.
			int encounterChoice = (int)(Math.random() * 33);
			if (encounterChoice <= 11)
				horde[i] = new Dragon();
			else if (encounterChoice <= 22)
				horde[i] = new Slime();
			else 
				horde[i] = new Vampire(); 	
		}
		
    }
	/* 
	===============================
	Simulates a battle with one monster. Here again polymorphism is used in the parameter.
	The parameter is of variable type Monster type but can contain a reference to any of 
	the subclasses of monsters. Thus this method can simulate battles with Dragons, Slimes and Vampires.
	
	This method unlike in the orginal version does not return anything. It simply simulates a battle.
	pre-condition: The protagonist is alive
	post-condition: Nothing
	===============================
	*/
    public void playTurn(Monster opponent) { //hw3E#0 
        int i = 1;
        int d1, d2;

		System.out.println( "\nLo, yonder the horde approacheth!" );
		System.out.println("");
		System.out.println(opponent); //Prints status of opponent monster. //hw46#1,2
		//The JVM makes sure the correct toString is called.
		
		//While loop for battle
        while( opponent.isAlive() && pat.isAlive() ) { // hw44#3,4 Inherits isAlive
			//Option to specialize or normalize
			try {
				System.out.println( "\nDo you feel lucky?" );
				System.out.println( "\t1: Nay.\n\t2: Aye!" );
				i = Integer.parseInt( in.readLine() );
			}catch ( IOException e ) { }

            if ( i == 2 )
                pat.specialize(); 
            else
                pat.normalize();

            d1 = pat.attack( opponent ); //hw44#3,4, inherits attack
            d2 = opponent.attack( pat ); //hw44#3,4, inherits attack

			System.out.println("===========================");
            System.out.println( "\n" + pat.getName() + " dealt "+ d1 + " points of damage.");
            System.out.println( "\n" + "Ye Olde Monster smacked "+ pat.getName() + " for "+ d2 + " points of damage.");
								  
			System.out.println("");				  
			System.out.println(pat); //Prints protagonist after every attack 
			System.out.println("");
			System.out.println(opponent); //Prints antagonist after every attack //hw46#1,2
            }

			//Both die at the same time...
            if ( !opponent.isAlive() && !pat.isAlive() ) { 
                System.out.println( "\n'Twas an epic battle, to be sure... " +
                "You cut ye olde monster down, but " +
                "with its dying breath ye olde monster. " +
                "laid a fatal blow upon thy skull." );
            }
			//Only the monster dies...
            else if ( !opponent.isAlive() ) {
                System.out.println("\nHuzzaaH! Ye olde monster hath been slain!" );
            }
			
			//Only the protagonist dies...
            else if ( !pat.isAlive() ) {
                System.out.println( "\nYe olde self hath expired. You got dead." );
            }
    }




}
