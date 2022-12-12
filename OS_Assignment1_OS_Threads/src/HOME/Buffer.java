package HOME;

import java.io.IOException;


public class Buffer {
    private final int size;
    private final int[] buff;

    private int inptr = 0;
    private int outptr = 0;

    Semaphore spaces;
    Semaphore elements;


    public Buffer(int size) {
        this.size = size;
        buff = new int[size];
        spaces = new Semaphore(size);
        elements = new Semaphore(0);
    }


    public void produce(int value) {
        spaces.P();
//        System.out.println("value "+value);
        buff[inptr] = value;
        inptr = (inptr + 1) % size;
        elements.V();
    }

    public synchronized int consume() {

        int value;
        elements.P();
        value = buff[outptr];
//        System.out.println("value out "+value);
        outptr = (outptr + 1) % size;
        spaces.V();
        return value;

    }


}
