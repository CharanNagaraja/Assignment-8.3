package bankproject;

public class accountdetails {
public static accountdetails account;
private static int balance = 1000;
private static thread person;

private accountdetails() {
}

public static accountdetails getAccount(thread p) {
    if (account == null) {
        account = new accountdetails();
    }
    accountdetails.person = p;
    return account;
}

public static int getBal() {
    return balance;
}

public synchronized void withdraw(int bal) {
    try {

        if (balance >= bal) {
            System.out.println(person.getName() + " " + "is try to withdraw");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            balance = balance - bal;
            System.out.println(person.getName() + " " + "is complete the withdraw");
        } else {
            System.out.println(person.getName() + " " + "doesn't have enough money for withdraw ");
        }
        System.out.println(person.getName() + " " + " withdraw Rs." + balance);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public synchronized void deposit(int bal) {
    try {
        if (bal > 0) {
            System.out.println(person.getName() + " " + " is try to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            balance = balance + bal;
            System.out.println(person.getName() + " " + "is complete the deposit");
        } else {
            System.out.println(person.getName() + " " + "doesn't have enough money for deposit");
        }
        System.out.println(person.getName() + " " + " deposit Rs." + balance);
    } catch (Exception e) {
        e.printStackTrace();
    }
}}