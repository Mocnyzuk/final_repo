package fileCopy;

import java.io.File;
import java.io.IOException;

public class CopyTime {
    public static void main(String[] args) throws IOException {

        File source = new File("src/main/java/fileCopy/source.txt");
        File target = new File("src/main/java/fileCopy/target.txt");


        double copyTime = fileCopyTime(CopyFile.useIOStream, source, target);

        System.out.println("IOS time: " + copyTime);


        copyTime = fileCopyTime(CopyFile.useStandard, source, target);
        System.out.println("Standard time: " + copyTime);


        copyTime = fileCopyTime(CopyFile.useRAF, source, target);
        System.out.println("RAF time: " + copyTime);
    }

    public static double fileCopyTime(CopyFile copyFile, File sourceFile, File targetFile) throws IOException {
        long initialTime = System.currentTimeMillis();

        copyFile.copy(sourceFile, targetFile);

        long finalTime = System.currentTimeMillis();

        return finalTime - initialTime;
    }


}

