package streamAPI.fileCopying;

import java.io.*;
import java.nio.channels.FileChannel;

public interface FileCopyingInterface {
    void copy(File source, File target) throws IOException;

    FileCopyingInterface useIOStream = (source1, target1) -> {
        try (FileInputStream in = new FileInputStream(source1);
             FileOutputStream out = new FileOutputStream(target1)) {
            int anotherByte;
            while (((anotherByte = in.read()) != -1)) {
                out.write(anotherByte);
            }

        }
    };

    FileCopyingInterface useRAF = (source1, target1) -> {
        var source = new RandomAccessFile(source1, "r");
        var target = new RandomAccessFile(target1, "rw");

        try (var sfc = source.getChannel();
             var dfc = target.getChannel()) {

            dfc.transferFrom(sfc, 0, sfc.size());
        }
    };


    FileCopyingInterface useStandard = (source1, target1) -> {
        try (
                FileChannel in = new FileInputStream(source1).getChannel();
                FileChannel out = new FileOutputStream(target1).getChannel()) {

            out.transferFrom(in, 0, in.size());
        }
    };

}
