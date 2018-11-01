package Classes;

public class Main {

    public static void main(String[] args) {
        Die dice;
        Cash cash;
        dice = new Die();
        cash = new Cash();
        System.out.println("Hello World!");
        System.out.println("nako");
        System.out.println("Kero");
        System.out.println(dice.rollDie());
        cash.setAmount(1500);
        cash.dropCash(500);
        cash.addCash(1000);
        System.out.println(cash.getAmount());
    }
}
