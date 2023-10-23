package uken.testThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final Lock lock = new ReentrantLock();
    private int saldo = 0;

    // synchronizacja wątków przy użyciu słówka synchonized
    public synchronized void wplata(int kwota){
        // synchronizacja wątków z wykorzystaniem blokad (lock / unlock)
//        lock.lock();
//        try{
            System.out.println("watek " + Thread.currentThread().getName()
                    +" wpłaca: " + kwota + " saldo: " + this.saldo);
            saldo += kwota;
//        }finally {
//            lock.unlock();
//        }
    }
    // synchronizacja wątków przy użyciu słówka synchonized
    public synchronized void wyplata(int kwota){
        // synchronizacja wątków z wykorzystaniem blokad (lock / unlock)
//        lock.lock();
//        try{
            System.out.println("watek " + Thread.currentThread().getName()
                    +" wypłaca: " + kwota + " saldo: " + this.saldo);
            saldo -= kwota;
//        }finally {
//            lock.unlock();
//        }
    }
    public int pobierzSaldo(){
        return saldo;
    }

}
