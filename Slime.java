public class Slime extends Monster{ //hw44#3,4
	//Constructors
    public Slime() { //hw44#3,4
		super(); //hw44#3
        attack /= 3; //hw44#3,4 inherits attack field
        defense *= 3; //hw44#3,4 inherits defense field
    }
	//Methods
	public String toString(){ //hw46#1,2
		return "==Slime==" + System.lineSeparator() + super.toString(); //hw46#1,2
		
	}
}
