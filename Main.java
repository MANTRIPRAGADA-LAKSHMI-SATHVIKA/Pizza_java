
import java.util.Scanner;

class Pizza {

    protected int price;
    private boolean veg;

    protected int extraCheesePrice = 100;
    protected int extraToppingPrice = 150;
    protected int backPackPrice = 20;

    protected int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isOptedForTakeaway = false;

    Scanner in = new Scanner(System.in);

    public Pizza(boolean veg) {
        this.veg = veg;

        if (this.veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }
        basePizzaPrice = this.price;
    }

    public void addExtraCheese() {
        System.out.println("Extra cheese (y/n)? =>");
        char ch = in.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            isExtraCheeseAdded = true;
            this.price += extraCheesePrice;
        }
    }

    public void addExtraToppings() {
        System.out.println("Want Extra Topping (y/n)? =>");
        char ch = in.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            isExtraToppingsAdded = true;
            this.price += extraToppingPrice;
        }
    }

    public void takeAway() {
        System.out.println("Want TakeAway (y/n)? =>");
        char ch = in.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            isOptedForTakeaway = true;
            this.price += backPackPrice;
        }
    }

    public void getBill() {
        System.out.println("Pizza : " + basePizzaPrice);
        if (isExtraCheeseAdded) {
            System.out.println("Extra Cheese : " + extraCheesePrice);
        }
        if (isExtraToppingsAdded) {
            System.out.println("Extra Toppings : " + extraToppingPrice);
        }
        if (isOptedForTakeaway) {
            System.out.println("Take away : " + backPackPrice);
        }
        System.out.println("Total Amount: " + this.price);
        System.out.println("\nThank You! Visit Again...");
        System.out.println("------------------------------------------------");
    }
}

class DeluxPizza extends Pizza {

    public DeluxPizza(boolean veg) {
        super(veg);
        // Deluxe pizzas automatically include extra cheese and toppings
        addExtraCheese();
        addExtraToppings();
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("-------------------------------------WELCOME TO PIZZAMANIA-------------------------------------\n");
        System.out.println("Which pizza would you like? (1. Veg Pizza  2. Non-Veg Pizza  3. Deluxe Veg Pizza  4. Deluxe Non-Veg Pizza)");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        switch (ch) {
            case 1: {
                Pizza vegPizza = new Pizza(true); // Veg pizza
                vegPizza.addExtraCheese();
                vegPizza.addExtraToppings();
                vegPizza.takeAway();
                vegPizza.getBill();
                break;
            }
            case 2: {
                Pizza nonVegPizza = new Pizza(false); // Non-veg pizza
                nonVegPizza.addExtraCheese();
                nonVegPizza.addExtraToppings();
                nonVegPizza.takeAway();
                nonVegPizza.getBill();
                break;
            }
            case 3: {
                DeluxPizza vegDeluxePizza = new DeluxPizza(true); // Deluxe veg pizza
                vegDeluxePizza.takeAway();
                vegDeluxePizza.getBill();
                break;
            }
            case 4: {
                DeluxPizza nonVegDeluxePizza = new DeluxPizza(false); // Deluxe non-veg pizza
                nonVegDeluxePizza.takeAway();
                nonVegDeluxePizza.getBill();
                break;
            }
            default:
                System.out.println("Invalid choice! Please select a valid option.");
        }

        sc.close();
    }
}
