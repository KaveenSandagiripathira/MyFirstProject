public class Vampire extends Monster { //hw44#3,4
	//Constructor
	public Vampire() { //hw44#3,4
		super(); //hw44#3
		health /= 2; //hw44#3,4 inherits health field
    }
	
	//Methods

    public int attack(Character target){ //hw3E#0 //hw46#moreThinking, overrides attack from Character
        int damage = (int)((strength * attack) - target.getDefense()); //hw44#3,4 inherits strength, attack and getDefense
		if (damage < 0)
			damage = 0;
        target.lowerHP(damage); ////hw44#3,4 inherits lowerHP
        lowerHP(-damage); 
        return damage;
    }
	
	
	public String toString(){ //hw46#1,2
		return "==Vampire==" + System.lineSeparator() + super.toString(); //hw46#1,2
	}
	
	
}
