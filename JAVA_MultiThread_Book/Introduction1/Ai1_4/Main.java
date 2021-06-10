package Ai1_4;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);   // 1000�궻뗢뛱뚿띆귩띿귡
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
