package day47;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class day47 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Compress? Y(yes) / N(No)");
        boolean isToCompress = scan.next().toLowerCase().equals("y");

        if (isToCompress) {
            System.out.print("Type the file path you want to compress:");
            String filePath = scan.next();

            System.out.print("Type the file path after compressing:");
            String targetPath = scan.next();

            Compress(filePath, targetPath);
        } else {
            System.out.print("Uncompress? Y(yes) / N(No)");
            boolean isToUnCompress = scan.next().toLowerCase().equals("y");

            if (isToUnCompress) {
                System.out.print("Type the compressed file path:");
                String filePath = scan.next();

                System.out.print("Type the file path after uncompressing:");
                String targetPath = scan.next();

                UnCompress(filePath, targetPath);
            } else {
                System.out.print("Exiting...");
            }
        }
    }

    public static void Compress (String sourceFileName, String targetFileName) throws IOException {

        //reading original data
        FileInputStream originalFile = new FileInputStream(sourceFileName);

        //the new generated file
        FileOutputStream targetFile = new FileOutputStream(targetFileName);

        /*
         * DeflaterOutputStream is used to compress the data and sent it to the
         * FileOutputStream
         */
        DeflaterOutputStream finalFile = new DeflaterOutputStream(targetFile);

        int data;

        while ((data = originalFile.read())!=-1) {
            finalFile.write(data);
        }

        originalFile.close();
        finalFile.close();
    }

    public static void UnCompress (String sourceFileName, String targetFileName) throws IOException {

        FileInputStream originalFile = new FileInputStream(sourceFileName);
        FileOutputStream targetFile = new FileOutputStream(targetFileName);
        InflaterInputStream compressedFile = new InflaterInputStream(originalFile);

        int data;

        while((data=compressedFile.read())!=-1)
        {
            targetFile.write(data);
        }

        targetFile.close();
        compressedFile.close();
    }
}
