package homework.fifth;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Multithreading {

    static final int arrayLength = 1000000;
    static final int half = arrayLength / 2;

    protected void methodFirst () {

        float[] arr = new float[arrayLength];
        Arrays.fill(arr, 1);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        double duration = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - duration);

    }

    protected void methodSecond () {

        float[] arr = new float[arrayLength];
        Arrays.fill(arr, 1);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        double duration = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - duration);

    }



    }

