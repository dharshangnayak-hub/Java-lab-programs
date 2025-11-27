class wrongage extends Exception {
    public wrongage(String mss){
        //System.out.println(mss); or
        super(mss);
    }
}

class father{
    int fage;

    public father(int age) throws wrongage{
        if(age<0){
            throw new wrongage("age cannot be negaive");
        }
        fage=age;
        System.out.println("father's age is"+fage);
    }
}

class son extends father {
    int sage;

    public son(int fage, int sage) throws wrongage {
        super(fage); // Call Father constructor
        if (sage >= fage) {
            throw new wrongage("Son's age cannot be greater than or equal to Father's age!");
        }
        if (sage < 0) {
            throw new wrongage("Son's age cannot be negative!");
        }
        this.sage = sage;
        System.out.println("son's age is"+sage);
    }
}

public class exception
{
    public static void main(String[] args) {
        try {
            son s =new son(45,20);
        } catch (Exception e) {
            System.out.println("Exception "+e.getMessage());
        }
       
        System.out.println();
        
        try {
            son s =new son(40,50);
        } catch (Exception e) {
            System.out.println("Exception "+e.getMessage());
        }

        System.out.println();

        try {
            son s =new son(-30,10);
        } catch (Exception e) {
            System.out.println("Exception "+e.getMessage());
        }
    }
}
