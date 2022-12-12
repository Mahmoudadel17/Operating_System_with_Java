package HOME;


import java.io.*;

class consumer extends Thread {
    Buffer buf;

    public consumer(Buffer buf) {
        this.buf = buf;
    }
    private void writeInFile(){
        int value = buf.consume();
        Primes.COUNTER++;
        try (FileWriter f = new FileWriter(Primes.fileName, true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
        {p.print("\""+value+"\" ");}
        catch (IOException i) { i.printStackTrace(); }
    }

    public void run() {
        // check is false if producer finish
        while ((!Primes.check)){writeInFile();}
        while (Primes.COUNTER != Primes.totalPrimes){writeInFile();}
        Primes.totalPrimes = 0;
        Primes.COUNTER = 0;
        Primes.check=false;
        System.out.println("finish-_-");
}
}