/*
TurtleMan.java:1: error: TurtleMan is not abstract and does not override abstract method normalize() in Protagonist
public class TurtleMan extends Protagonist { //hw44#3,4
*/
public class TurtleMan extends SubProtagonist { //hw44#3,4

	//Constructor that simply calls super constructor for initalizing 
    public TurtleMan( String name) { //hw44#3,4
        super(name); //hw44#3, 
    }

    public void specialize(){  //hw46#moreThinking, overrides specialize from Protagonist
        if (!isSpec) { 
			attack /= 3; //hw44#3,4 inherits attack
            defense *= 3; //hw44#3,4 inherits defense
            isSpec = true; //hw44#3,4 inherits isSpec
        }
    }
	
	public void normalize(){ //hw3C#1
        isSpec = false;
        attack = BASE_ATK;
        defense = BASE_DEF;
    }
	
	public String toString(){  //hw46#1,2
		return "==TurtleMan==" + System.lineSeparator() + super.toString(); //hw46#1,2
		
	}


}

//Edit for git

