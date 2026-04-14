package OOPtime;

class Main{
    public static void main(String[] args){
        //creates an object of avengers type, this essentially provides a funnel into the class using the ironMan identifier
        avengers ironMan = new avengers();
        //ironMan accesses the class through the intialiser above and .name specifies that the name attribute is being characterised
        ironMan.name = "Tony Stark";
        ironMan.power = 100;
        System.out.println("This hero's name is "+ironMan.name);
        //calling the method within avengers 
        ironMan.punch();

        viltrumite vil1 = new viltrumite();
        vil1.name = "OmniMan";
        vil1.power = 1000;
        int ironManDamage = vil1.headChop(ironMan);
        ironMan.power = ironManDamage;
        System.out.println("OmniMan attacked, IronMan's power is now "+ironMan.power+".");
        String ironManStatus = (ironMan.power <= 0) ? "Iron Man is dead" : "Iron Man is still alive";
        System.out.println(ironManStatus);
    }
}

class avengers{
    //define the attributes that an avenger may have, this is also known as constructing the class
    String name;
    int power;
    void punch(){
        System.out.println("Ultron takes "+power+" damage or some shit.");
        System.out.println("Thanos only takes "+power/2+" damage because he's hench.");
    }
}

class viltrumite{
    String name;
    int power;
    //dont use static because otherwise it cannot use its own objects values/ it cannot have "this.power"
    int headChop(avengers a){
        int AvengerPower = a.power;
        AvengerPower -= this.power;
        return AvengerPower;
        
    }
}