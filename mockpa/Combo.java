import java.util.ArrayList;

class Combo {
   int ID;
   int burger;
   int snack;
   int drink;
   static ArrayList<Food> menu = Main.menu;
   Food comboBurger = null;
   Food comboSnack = null;
   Food comboDrink = null;

   public Combo(int ID, int burger, int snack, int drink) {
      this.ID = ID;
      this.burger = burger;
      this.snack = snack;
      this.drink = drink;
   }

   public int comboPrice() {

      int sum = 0;

      for(Food b: menu) {
        if (b.ID == burger) {
          comboBurger = b;
        } else if (b.ID == snack) {
          comboSnack = b;
        } else if (b.ID == drink) {
          comboDrink = b;
        }
      }
      sum = sum + comboBurger.price + comboSnack.price + comboDrink.price - 50;
      return sum;
   }

   public void comboPrint() {
      System.out.println("#" + ID + " Combo (" + comboPrice() + ")");
      System.out.println("   #" + comboBurger.ID + " " + comboBurger.type + ": " + comboBurger.desc + " (" + comboBurger.price + ")");
      System.out.println("   #" + comboSnack.ID + " " + comboSnack.type + ": " + comboSnack.desc + " (" + comboSnack.price + ")");
      System.out.println("   #" + comboDrink.ID + " " + comboDrink.type + ": " + comboDrink.desc + " (" + comboDrink.price + ")");
   }
}
