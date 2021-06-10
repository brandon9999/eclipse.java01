package Ai1_4;

public class Bank {
    private int money;
    private String name;
    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }
    public void deposit(int m) {
        money += m;
    }
    public boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            check();
            return true;
        } else {
            return false;
        }
    }
    public String getName() {
        return name;
    }
    private void check() {
        if (money < 0) {
            System.out.println("뾞뗠럄뛼궕�귽긥긚궳궥! money = " + money);
        }
    }
}
