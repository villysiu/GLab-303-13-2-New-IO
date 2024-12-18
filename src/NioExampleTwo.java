import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
public class NioExampleTwo{
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //Input files
        String[] inputFiles = {"/Users/villysiu/Documents/Coding/JAVA Projects/GLab-303-13-2-New-IO/file1.txt",
                "/Users/villysiu/Documents/Coding/JAVA Projects/GLab-303-13-2-New-IO/file2.txt"};

        //Files contents will be written in these files
        String outputFile = "/Users/villysiu/Documents/Coding/JAVA Projects/GLab-303-13-2-New-IO/OutputExampleTwo.txt";
        //Get channel for output file

        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();
        for (int i = 0; i < inputFiles.length; i++)
        {
            //Get channel for input files
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            //Transfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close the input channel
            inputChannel.close();
            fis.close();
        }

        //finally close the target channel
        targetChannel.close();
        fos.close();
    }
}

