package bankproject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class threadclass extends Thread implements Runnable {

private thread person;

public threadclass(thread p) {
    this.person = p;
}

public static void main(String[] args) {

	threadclass ts1 = new threadclass(new thread("John"));
    ts1.start();
    threadclass ts2 = new threadclass(new thread("Charco"));
    ts2.start();
    threadclass ts3 = new threadclass(new thread("Peter"));
    ts3.start();

}

@Override
public void run() {
    for (int i = 0; i < 3; i++) {
        try {
            accountdetails acc = accountdetails.getAccount(person);
            acc.withdraw(100);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(threadclass.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (acc.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            acc.deposit(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    System.out.println("Final Acc balance is Rs." + accountdetails.getBal());
}}