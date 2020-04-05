package fileCopy;

import java.io.*;
import java.nio.channels.FileChannel;

public interface CopyFile {

    void copy(File sourceFile, File targetFile) throws IOException;

    CopyFile useIOStream = (source, target) -> {
        try(FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(target)){
            int anotherByte;
            while(((anotherByte = in.read()) != -1)) {
                out.write(anotherByte);
            }
        }
    };
    CopyFile useStandard = (source, target) -> {
        try (
                FileChannel readFile = new FileInputStream(source).getChannel();
                FileChannel writeFile = new FileOutputStream(target).getChannel()) {

            writeFile.transferFrom(readFile, 0, readFile.size());
        }
    };
    CopyFile useRAF = (source, target) -> {
        var readFile = new RandomAccessFile(source, "r");
        var writeFile = new RandomAccessFile(target, "rw");

        try (var sourceFileChannel = readFile.getChannel();
             var targetFileChannel = writeFile.getChannel()) {

            targetFileChannel.transferFrom(sourceFileChannel, 0, sourceFileChannel.size());
        }
    };



}