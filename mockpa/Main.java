import java.util.Scanner;
import java.util.ArrayList;

class Main {
    static ArrayList<Food> menu = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArrayList<Food> menu = new ArrayList<>();
        ArrayList<Combo> combos = new ArrayList<>();

       int ID = 0;
       while(sc.next().equals("add")) {
            String type = sc.next();
            if(type.equals("Combo")) {
               int burger = sc.nextInt();
               int snack = sc.nextInt();
               int drink = sc.nextInt();
               boolean valid = false;
               for(Food b: menu) {
                 if (b.ID == burger && b.type.equals("Burger")) {
                   for(Food s: menu) {
                     if (s.ID == snack && s.type.equals("Snack")) {
                       for(Food d: menu) {
                         if (d.ID == drink && d.type.equals("Drink")) {
                           valid = true;
                         }
                       }
                     }
                   }
                 }
               }
               /*burger > menu.size() - 1 || snack > menu.size()    - 1 ||
                    drink > menu.size() - 1 || !(menu.get(burger).type.equals("Burger")) ||
                    !(menu.get(snack).type.equals("Snack")) || !(menu.get(drink).type.equals("Drink"))*/

               if (!valid) {
                   System.out.println("Error: Invalid combo input " + burger + " " + snack + " " + drink);
               } else {
                   combos.add(new Combo(ID, burger, snack, drink));
                   ID++;
               }
               continue;
            }
            String desc = sc.next();
            int price = sc.nextInt();
            Food food = new Food(ID, type, desc, price);
            menu.add(food);

            ID++;

        }
        for (int h = 0; h < menu.size(); h++) {
          Food e = menu.get(h);
          if (e.type.equals("Burger")) {
              System.out.println("#" + e.ID + " " +  e.type + ": " + e.desc + " (" + e.price + ")");
          }
        }
        for (int i = 0; i < menu.size(); i++) {
            Food f = menu.get(i);
            if (f.type.equals("Snack")) {
                System.out.println("#" + f.ID + " " + f.type + ": " + f.desc + " (" + f.price + ")");
            }
        }
        for (int j = 0; j < menu.size(); j++) {
            Food g = menu.get(j);
            if (g.type.equals("Drink")) {
                System.out.println("#" +g.ID + " " + g.type + ": " + g.desc + " (" + g.price + ")");
            }
        }

        for(Combo c: combos) {
          c.comboPrint();
        }
        System.out.println("--- Order ---");
        int total = 0;
        while(sc.hasNext()) {
            int order = sc.nextInt();
            for(Combo c: combos) {
               if (order == c.ID) {
                  total += c.comboPrice();
                  c.comboPrint();
                  continue;
               }
            }
            for(Food f: menu) {
                if (f.ID == order) {
                   System.out.println("#" + f.ID + " " + f.type + ": " +f.desc + " (" + f.price + ")");
                   total += f.price;
                }
            }
         }
         System.out.println("Total: " + total);
     }
}
