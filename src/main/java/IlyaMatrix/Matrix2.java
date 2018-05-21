package IlyaMatrix;

import java.util.ArrayList;
import java.util.List;

import workWithFiles.fileIO.ReaderFromFile;
import workWithFiles.fileIO.WriterToFile;

public class Matrix2 {

    public static void main (String[] args) {
        long time = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            calculating("C:/trying/" + i, "C:/trying/" + i + ".txt");
        }
        System.out.println((System.nanoTime() - time) / 1000000000.0);
    }

    private static void calculating (String pathRead, String pathWrite) {
        WriterToFile writer = new WriterToFile(pathWrite);
        ReaderFromFile reader = new ReaderFromFile(pathRead);
        List<int[][]> matrixes = new ArrayList<>();
        String[] line = reader.readLine().split(" ");
        int matrixAmount = Integer.parseInt(line[0]);
        int matrixSize = Integer.parseInt(line[1]);

        line = reader.readLine().split(" ");
        int row = Integer.parseInt(line[0]) - 1;
        int column = Integer.parseInt(line[1]) - 1;

        int simpleNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i < matrixAmount; i++) {
            reader.readLine();
            int[][] elements = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                String[] nextline = reader.readLine().split(" ");
                for (int k = 0; k < nextline.length; k++) {
                    elements[j][k] = Integer.parseInt(nextline[k]);
                }
            }
            matrixes.add(elements);
        }
        reader.close();

        int[][] result = matrixes.get(0);
        for (int i = 0; i < matrixes.size() - 1; i++) {
            int[][] temp = new int[matrixSize][matrixSize];
            int[][] current = matrixes.get(i + 1);
            for (int x = 0; x < current.length; x++) {
                for (int y = 0; y < current.length; y++) {
                    for (int k = 0; k < current.length; k++) {
                        temp[x][y] += result[x][k] * current[k][y];
                    }
                    temp[x][y] %= simpleNumber;
                }
            }
            result = temp;
        }
        writer.writeLine(result[row][column]);
        writer.close();
    }
}
