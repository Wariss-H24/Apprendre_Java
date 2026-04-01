public class POO {
    //  static void myMethode(){
    //     System.out.println("Hello world");
    //  }
    int modelYear;
    String  modelName;
      public POO(int y, String name) {
        modelYear = y;
        modelName = name;
     }
    

     public static void main(String[] args) {
    //     myMethode();
    //     POO myCar = new POO();
    //     myCar.fullThrottle();
    //     myCar.speed(200);
            POO construct= new POO(5, "wariss");
            System.out.println(construct.modelYear+ construct.modelName);

     }

    //  public void fullThrottle(){
    //     System.out.println("The car is going as fast as it can!");
    //  }

    //  public void speed(int maxSpeed){
    //     System.out.println("Max speed is: " + maxSpeed);
    //  }


}
