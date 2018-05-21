package perestanov;

import java.util.ArrayList;
import java.util.List;

import workWithFiles.fileIO.WriterToFile;

public class TaskCreator {
    public static void main(String[] args) {
        int amount = (int) (Math.random() * 10000);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            numbers.add(i);
        }
        
        WriterToFile writer = new WriterToFile("MassivNatural.csv");
        for (int i = 0; i < (int) (Math.random() * amount) - 1; i++) {
            int index = (int) (Math.random() * numbers.size());
            writer.write(numbers.get(index));
            if (i < amount - 1) writer.write(",");
            numbers.remove(index);
        }
        writer.close();
    }
}
