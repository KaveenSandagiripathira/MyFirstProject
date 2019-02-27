public class Dragon extends Monster { //hw44#3,4
	//Constructors
    public Dragon() { //hw44#3,4
		super(); //hw44#3
        attack *= 3; //hw44#3,4 inherits attack field
        defense /= 3; //hw44#3,4 inherits defense field
    }
	//Methods
	public String toString(){ //hw46#1,2
		return "==Dragon==" + System.lineSeparator() + super.toString(); //hw46#1,2
		
	}
}
