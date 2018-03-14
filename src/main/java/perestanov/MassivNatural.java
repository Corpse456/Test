package perestanov;

import java.util.Arrays;

import fileOperation.ReaderFromFile;

public class MassivNatural {

    public static void main(String[] args) {
        ReaderFromFile reader = new ReaderFromFile("MassivNatural.csv");
        String[] array = reader.readLine().split(",");
        int[] numbers = new int[array.length];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        
        long time = System.nanoTime();
        System.out.println(findReplacment(numbers));
        System.out.println("\n" + (System.nanoTime() - time) / 1000000000.0);
    }

    private static int findReplacment(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 != numbers[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
