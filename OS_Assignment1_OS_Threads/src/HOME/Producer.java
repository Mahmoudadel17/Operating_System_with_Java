package HOME;


class producer extends Thread {
    Buffer buf;

    private synchronized Boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        Primes.totalPrimes++;
        Primes.largeNumber = num;
        Frame.jLabel10.setText(Integer.toString(Primes.largeNumber));
        Frame.jLabel6.setText(Integer.toString(Primes.totalPrimes));
        return true;
    }
    private void c(){
        for (int i = 1; i <=  Primes.Number; i++) {
            if (isPrime(i)) {
                buf.produce(i);
            }
        }
    }


    public producer(Buffer buf) {
        this.buf = buf;
    }

    public void run() {
        c();
        Primes.check = true;
        // set in GUI
        Primes.end = System.currentTimeMillis();
        Frame.jLabel11.setText(Long.toString((Primes.end - Primes.start)));


    }
}

