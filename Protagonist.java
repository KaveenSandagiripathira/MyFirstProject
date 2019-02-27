/*
Protagonist.java:1: error: Protagonist is not abstract and does not override abstract method normalize() in Protagonist
public class Protagonist extends Character {
       ^
*/

/* UserOfRPG.java:121: error: Protagonist is abstract; cannot be instantiated
        else pat = new Protagonist( name );
*/

/*
I introduced a class SubProtagonist which extends Protagonist and is a superclass of the other prog classes
Because the class does not contain any methods that override the abstract methods in Protagonist it must also be declared abstract.
*/
public abstract class Protagonist extends Character {

    protected String name; 
    protected boolean isSpec; //Is the protagonist in specialized mode
    protected final double BASE_ATK;
    protected final int BASE_DEF; 

    public Protagonist(String name){ 
        this.name = name;
        strength = 35;
        health = 150;
        isSpec = false; //In default, the protagonist is in the unspecialized state
        attack = BASE_ATK = 1;
        defense = BASE_DEF = 20;
    }

    public String toString() { //Basic toString returning stats 
        String tst = super.toString();
        return "Name: " + name + System.lineSeparator()
                + tst + System.lineSeparator()
                + "Base attack: " + BASE_ATK + System.lineSeparator()
                + "Base defense: " + BASE_DEF;
    }

    public String getName(){ 
        return name;
    }

    public abstract void specialize();

    public abstract void normalize();
}
//NEW