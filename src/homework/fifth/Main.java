package homework.fifth;

//Спасибо, что дали возможность сдать позже. Не успеваю из-за работы.

import java.util.Arrays;

public class Main {

    private static final int SIZE = 10_000_000;
    private static float arrayFirst [] = new float[SIZE];
    private static float arraySecond [] = new float[SIZE];

    public static void main(String[] args) {

        firstMethod();
        secondMethod();
        equalityCheck();

    }

    static void equalityCheck() {
        if (Arrays.equals(arrayFirst, arraySecond)) {
            System.out.println("Arrays are equal.");
        }
        else {
            System.out.println("Arrays are not equal.");
        }
    }

    static void firstMethod() {

        final int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        arrayFirst = arr;
    }

    static void secondMethod(){

        final int half = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] ar1 = new float[half];
        float[] ar2 = new float[half];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, ar1, 0, half);
        System.arraycopy(arr, half, ar2, 0, half);

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < ar1.length; i++) {
                ar1[i] = (float)(ar1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 5_000_000; i < ar2.length*2; i++) {
                ar2[i-5_000_000] = (float)(ar2[i-5_000_000] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(ar1, 0, arr, 0, half);
        System.arraycopy(ar2, 0, arr, half, half);
        System.out.println(System.currentTimeMillis() - a);
        arraySecond = arr;

    }

}
