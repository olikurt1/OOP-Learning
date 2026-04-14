package OOPtime;

class Main{
    public static void main(String[] args){
        //creates an object of avengers type, this essentially provides a funnel into the class using the ironMan identifier
        hero ironMan = new avengers("Tony Stark", 100);
        hero vil1 = new viltrumite("OmniMan", 1000, ironMan);
        
        //main can no longer see ironMan's name straight from the class so instead the getter function had to be used to retrieve the name from the object
        System.out.println("This hero's name is "+ironMan.getName());
        //calling the method within avengers 
        ironMan.attack();

        
        int ironManDamage = vil1.attack(ironMan);
        ironMan.setPower(ironManDamage);
        System.out.println("OmniMan attacked, IronMan's power is now "+ironMan.getPower()+".");
        String ironManStatus = (ironMan.getPower() <= 0) ? "Iron Man is dead" : "Iron Man is still alive";
        System.out.println(ironManStatus);
        
    }
}
abstract class hero{
    //defines the attributes a hero may have, use the protected keyword because it modifies access by only allowing access 
    // to them by hero itself or classes that inherit hero
    protected String name;
    protected int power;
    protected hero hero;
    //class constructor means that attribute values can be directly passed to object rather than hardcoded to main
    //allowing encapsulation
    hero(String name, int power){
        this.name = name;
        this.power = power;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPower(int power){
        this.power = power;
    }
    public int getPower(){
        return power;
    }
    abstract int attack();   
}

class avengers extends hero{
    //constructor for avengers
    avengers(String name, int power){
        //keyword tells constructor take values up to hero constructor and initialise there
        super(name, power);
    }
    //uses the hero attack method but overrides it with its own, this way, can be initialised as a hero type but an avenger object 
    //this is a use case of polymorphism where the parent/hero class steps in for the child/avengers or viltrumite class
    @Override //this keyword strictly tells the program that the method is overriding its original in the parent class
    int attack(){
        System.out.println("Ultron takes "+power+" damage.");
        System.out.println("Thanos only takes "+power/2+" damage because he's hench.");
        return 0;
    }
}

class viltrumite extends hero{
    viltrumite(String name, int power, hero hero){
        super(name, power);
        this.hero = hero;
    }
    public void setTargetToAttack(hero h){
        this.hero = h;
    }
    //dont use static because otherwise it cannot use its own objects values/ it cannot have "this.power"
    @Override
    int attack(hero h){
        int heroPower = h.getPower();
        heroPower -= this.power;
        if(heroPower < 0){
            heroPower = 0;
        }
        return heroPower;
        
    }
}