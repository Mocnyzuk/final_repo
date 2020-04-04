package streamAPI.fileCopying;

import java.io.File;
import java.io.IOException;

public class FileCopying {
    public void testAllMethods() throws IOException {
        File source = new File("src/main/java/streamAPI/fileCopying/source.txt");
        File target = new File("src/main/java/streamAPI/fileCopying/target.txt");

        deleteFile(target);

        double time = streamCopy(FileCopyingInterface.useIOStream, source, target);
        System.out.println("Time IOStream: " + time);

        deleteFile(target);

        time = streamCopy(FileCopyingInterface.useRAF, source, target);
        System.out.println("Time RAF: " + time);

        deleteFile(target);

        time = streamCopy(FileCopyingInterface.useStandard, source, target);
        System.out.println("Time Standard: " + time);

    }

    public static double streamCopy(FileCopyingInterface fileCopy, File source, File target) throws IOException {
        long start = System.currentTimeMillis();

        fileCopy.copy(source, target);

        long end = System.currentTimeMillis();
        return end - start;
    }

    private void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

}
