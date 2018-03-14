package IlyaMatrix;

import fileOperation.WriterToFile;

public class TaskCreator {
    public static void main (String[] args) {
        long time = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            creator("C:/trying/" + i);
        }
        System.out.println((System.nanoTime() - time) / 1000000000.0);
    }

    private static void creator (String path) {
        WriterToFile writer = new WriterToFile(path);
        int matrixAmount = (int) (Math.random() * 130 + 1);
        int matrixSize = (int) (Math.random() * 130 + 1);
        int row = (int) (Math.random() * matrixSize + 1);
        int column = (int) (Math.random() * matrixSize + 1);
        int simpleNumber = (int) (Math.random() * 1000);

        writer.writeLine(matrixAmount + " " + matrixSize);
        writer.writeLine(row + " " + column);
        writer.writeLine(simpleNumber);
        writer.writeLine();

        for (int i = 0; i < matrixAmount; i++) {
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    writer.write((int) (Math.random() * 9 + 1));
                    if (k != matrixSize - 1) writer.write(" ");
                    else writer.writeLine();
                }
            }
            writer.writeLine();
        }
        writer.close();
    }
}
