package OOPtime;

class Main{
    public static void main(String[] args){
        //creates an object of avengers type, this essentially provides a funnel into the class using the ironMan identifier
        avengers ironMan = new avengers("Tony Stark", 100);
        
        //main can no longer see ironMan's name straight from the class so instead the getter function had to be used to retrieve the name from the object
        System.out.println("This hero's name is "+ironMan.getName());
        //calling the method within avengers 
        ironMan.punch();

        viltrumite vil1 = new viltrumite("OmniMan", 1000);
        int ironManDamage = vil1.headChop(ironMan);
        ironMan.setPower(ironManDamage);
        System.out.println("OmniMan attacked, IronMan's power is now "+ironMan.getPower()+".");
        String ironManStatus = (ironMan.getPower() <= 0) ? "Iron Man is dead" : "Iron Man is still alive";
        System.out.println(ironManStatus);
    }
}

class avengers{
    //define the attributes that an avenger may have, this is also known as constructing the class
    private String name;
    private int power;
    //providing a constructor means that attributes can be passed directly to the class instance rather 
    // than being hard coded in main and exposed, this enforces encapsulation
    avengers(String name, int power){
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
    
    void punch(){
        System.out.println("Ultron takes "+power+" damage.");
        System.out.println("Thanos only takes "+power/2+" damage because he's hench.");
    }
}

class viltrumite{
    String name;
    int power;
    
    viltrumite(String name, int power){
        this.name = name;
        this.power = power;
    }

    //dont use static because otherwise it cannot use its own objects values/ it cannot have "this.power"
    int headChop(avengers a){
        int AvengerPower = a.getPower();
        AvengerPower -= this.power;
        if(AvengerPower < 0){
            AvengerPower = 0;
        }
        return AvengerPower;
        
    }
}