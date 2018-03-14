package IlyaMatrix;

import java.util.ArrayList;
import java.util.List;

import fileOperation.ReaderFromFile;
import fileOperation.WriterToFile;

public class Matrix {

    public static void main (String[] args) {
        long time = System.nanoTime();
        WriterToFile writer = new WriterToFile("C:/output.txt");
        ReaderFromFile reader = new ReaderFromFile("C:/input.txt");

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
        System.out.println((System.nanoTime() - time) / 1000000000.0);

        int[][] result = matrixes.get(0);
        for (int i = 0; i < matrixes.size() - 1; i++) {
            int[][] temp = new int[matrixSize][matrixSize];
            int[][] current = matrixes.get(i + 1);
            for (int x = 0; x < current.length; x++) {
                for (int y = 0; y < current.length; y++) {
                    for (int k = 0; k < current.length; k++) {
                        temp[x][y] += (result[x][k] * current[k][y]) % simpleNumber;
                    }
                }
            }
            print(temp);
            System.out.println();
            result = temp;
        }
        writer.writeLine(result[row][column]);
        writer.close();
        System.out.println((System.nanoTime() - time) / 1000000000.0);
    }

    private static void print (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
