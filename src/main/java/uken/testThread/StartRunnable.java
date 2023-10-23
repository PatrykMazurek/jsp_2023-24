package uken.testThread;

import java.util.Random;

// implementacja wątków wykorzystująca interfejs Runnable
public class StartRunnable implements Runnable {

    Bank bank;

    public StartRunnable(){
        this.bank = new Bank();
        System.out.println("Saldo na początku " + this.bank.pobierzSaldo());
    }

    @Override
    public void run() {
        Random rand = new Random();
        if(rand.nextBoolean()){
            this.bank.wplata(rand.nextInt(100));
        }else{
            this.bank.wyplata(rand.nextInt(50));
        }
    }
}
