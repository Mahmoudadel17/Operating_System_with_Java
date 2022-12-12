package HOME;

public class Semaphore {
    protected int value = 0 ;
    protected Semaphore() { value = 0 ; }
    protected Semaphore(int initial) { value = initial ; }
    public synchronized void P() {
        value-- ;
        if (value < 0)
            try { wait() ; } catch( InterruptedException e ) { }
    }
    public synchronized void V() {
        value++ ; if (value <= 0) notify() ;
    }
}