package listFiles;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class CompareListFiles {

    private static final String FOLDER2 = "d:\\C++\\5645654\\JAVA\\JAVA\\.metadata\\.plugins\\";
    private static final String FOLDER1 = "d:\\Java\\.metadata\\.plugins\\";

    public static void main (String[] args) {
        File[] folderOne = new File(FOLDER1).listFiles();
        File[] folderTwo = new File(FOLDER2).listFiles();
        
        Set<String> inD = new TreeSet<>();

        for (int i = 0; i < folderOne.length; i++) {
            inD.add(folderOne[i].getName());
        }
        
        for (int i = 0; i < folderTwo.length; i++) {
            String name = folderTwo[i].getName();
            if (inD.add(name)) {
                System.out.println(name);
            }
        }
    }

}
