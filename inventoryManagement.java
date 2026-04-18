import java.util.Scanner;
import java.util.ArrayList;

class product { 
    String name;
    int price;
    int quantity;
    public product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class inventoryManagement {

    public static void main(String[] args) {
        ArrayList<product> inventory = new ArrayList<product>();

        boolean flag = true;
        while (flag) {
            Scanner input = new Scanner (System.in);
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Product info");
            System.out.println("3. View Products");
            System.out.println("4. Sell Product");
            System.out.println("5. Restock Product");
            System.out.println("6. Exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter product name:");
                    String name = input.next();
                    System.out.println("Enter product price:");
                    int price = input.nextInt();
                    System.out.println("Enter product quantity:");
                    int quantity = input.nextInt();
                    product newProduct = new product(name, price, quantity);
                    inventory.add(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.println("Enter product name:");
                    String searchName = input.next();
                    boolean found = false;
                    for (product p : inventory) {
                        if (p.getName().equalsIgnoreCase(searchName)) {
                            p.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Product not found.");
                    
                    break;

                case 3:
                    System.out.println("Viewing all products:");
                    for (product p : inventory) {
                        p.displayInfo();
                        System.out.println("--------");
                    }
                    break;

                case 4:
                    System.out.println("Enter product name:");
                    String sellName = input.next();
                    boolean sellFound = false;
                    for (product p : inventory) {
                        if (p.getName().equalsIgnoreCase(sellName)) {
                            System.out.println("Enter quantity to sell:");
                            int sellQuantity = input.nextInt();
                            if (sellQuantity <= p.getQuantity()) {
                                p.setQuantity(p.getQuantity() - sellQuantity);
                                System.out.println("Product sold successfully.");
                            } else {
                                System.out.println("Insufficient quantity.");
                            }
                            sellFound = true;
                            break;
                        }
                    }
                    if (!sellFound) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.println("Enter product name: ");
                    String restockName = input.next();
                    boolean restockFound = false;
                    for (product p : inventory){
                        if (p.getName().equalsIgnoreCase(restockName)){
                            System.out.println("Enter quantity to restock: ");
                            int restockQuantity = input.nextInt();
                            p.setQuantity(p.getQuantity() + restockQuantity);
                        }
                        restockFound = true;
                        break;
                    }
                    if (!restockFound) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 6:
                    flag = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}   