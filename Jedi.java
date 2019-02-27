/*
Jedi.java:1: error: Jedi is not abstract and does not override abstract method normalize() in Protagonist
public class Jedi extends Protagonist { //hw44#3,4
*/

public class Jedi extends SubProtagonist { //hw44#3,4
	//Constructor that simply calls super constructor for initalizing 
    public Jedi( String name) { //hw44#3,4
        super(name); //hw44#3
    }

    public void specialize() { //hw46#moreThinking, overrides specialize from Protagonist
        if (!isSpec) {
            attack *= 3; //hw44#3,4, inherits attack
            defense /= 3; //hw44#3,4 inherits defense
            isSpec = true; //hw44#3,4 inherits isSpec
        }
    }
	
	public void normalize(){ //hw3C#1
        isSpec = false;
        attack = BASE_ATK;
        defense = BASE_DEF;
    }
	
	public String toString(){ //hw46#1,2
		return "==Jedi==" + System.lineSeparator() + super.toString(); //hw46#1,2
		
	}


}
