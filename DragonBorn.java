/*
DragonBorn.java:1: error: DragonBorn is not abstract and does not override abstract method normalize() in Protagonist
public class DragonBorn extends Protagonist { //hw44#3,4
*/

public class DragonBorn extends SubProtagonist { //hw44#3,4
	//Specialized Constructor
    public DragonBorn( String name) { //hw44#3,4
        super(name); //hw44#3
		health *= 2; //hw44#3,4, inherits health field
    }
	
	public String toString(){ //hw46#1,2
		return "==DragonBorn==" + System.lineSeparator() + super.toString(); //hw46#1,2
		
	}
	
	public void normalize(){ //hw3C#1
        isSpec = false;
        attack = BASE_ATK;
        defense = BASE_DEF;
    }
	
    public void specialize(){ //hw3C#1
        if (!isSpec) {
            isSpec = true;
            attack *= 2;
            defense /= 2;
        }
    }
	

}
