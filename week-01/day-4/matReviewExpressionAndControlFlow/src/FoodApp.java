public class FoodApp {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        int flour = 100;
        int water = 200;
        int saltAndSugar = 20;
        int yeast = 50;
        String foodName = "Bread";

        if (water < 100 || flour < 200) {
            System.out.println("Not enough ingredients!");
            if (water < 100) {
                water = 100;
                System.out.println("Water level set to: " + water);
            }
            if (flour < 200){
                flour = 200;
                System.out.println("Flour level set to: " + flour);
            }
        } else{
            System.out.println("Enough ingredients!");
        }


        for (int i = 0; i < 50; i+=10){
            System.out.println("We added 10 gramms of flour to the bowl");
            flour-=10;
            System.out.println("Flour remaining is " +  flour);
        }

        int filledWater = 0;
        while (filledWater <= 50) {
            filledWater+=10;
            water-=10;
            System.out.println("I added water of 10ml");
        }

        for (int i = 0; i < 3; i+=10) {
            water-=10;
            System.out.println();
            for (int j = 0; j < 3; j++){
                flour -=10;
            }
        }

    }
}
