package parallel.fstream;

import java.io.*;
import java.util.List;

import parallel.linq101.datasource.Product;

public class Fstream {
    private final String FILE_NAME = "file.txt";
    private final String FILE_OUT = "out.txt";
    private final String FILE_IN = "in.txt";
    private final int size = 109;

    public static FileInputStream getFileInputStream(String filepath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not existed.");
            e.printStackTrace();
        }
        return fileInputStream;
    }

    public static FileOutputStream getFileOutputStream(String filepath, boolean append) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filepath, append);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not existed.");
            e.printStackTrace();
        }
        return fileOutputStream;
    }

    //Write bytes array to file using FileOutputStream
    public int writeFileBinary(){
        byte[] bytes = {99, 100, 101, 102};
        try{
            File file = new File(FILE_NAME);
            if (!file.exists())
                file.createNewFile();
            FileOutputStream binaryOutFile = new FileOutputStream(file);
            binaryOutFile.write(bytes);
            binaryOutFile.close();
        }catch(IOException exception){
            return -1;
        }
        return 0;
    }

    public int readFileBinary(int length){
        byte[] bytes = new byte[length];
        int n = 0;
        try{
            File file = new File(FILE_NAME);
            FileInputStream binaryInFile = new FileInputStream(file);
            n = binaryInFile.read(bytes);
            binaryInFile.close();
        }catch(IOException exception){
            return -1;
        }
        return n;
    }

    public int countFileSize(){
        int count = 0;
        byte[] bytes = new byte[10];
        try{
            File file = new File(FILE_NAME);
            FileInputStream dataInFile = new FileInputStream(file);
            while(true){
                int n = dataInFile.read(bytes);
                if(n != 10) {
                    count += n;
                    dataInFile.close();
                    break;
                }
                else{
                    count += n;
                }
            }
        }catch(IOException exception){}
        return count;
    }

    private static long copy(String inFilePath, String outFilePath, byte[] buffer){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(inFilePath);
            outputStream = new FileOutputStream(outFilePath);
            long total = 0;
            for (;;) {
                int res = inputStream.read(buffer);
                if (res == -1) {
                    break;
                }
                if (res > 0) {
                    total += res;
                    if (outputStream != null) {
                        outputStream.write(buffer, 0, res);
                    }
                }
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();
            inputStream = null;
            outputStream = null;
            return total;
        }catch(IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int writeProductToFile(String fileName, Product product){
        FileWriter outputStreamWriter = null;
        try{
            outputStreamWriter = new FileWriter(fileName);
            outputStreamWriter.write(product.toString());
            outputStreamWriter.close();
        }catch(IOException e){
            return -1;
        }
        return 0;
    }

    public String readLine(String fileName){
        String str = "";
        FileReader outputStreamWriter = null;
        try{
            outputStreamWriter = new FileReader(fileName);
            while(true){
                int c = outputStreamWriter.read();
                if((char)c == '\r' || (char)c == '\n') break;
                str += (char)c;
            }
        }catch(IOException e){
        }
        return str;
    }

    public void writeData(String fileName){
        try (FileOutputStream binaryOutFile = new FileOutputStream("file.txt");
             DataOutputStream dataOutFile = new DataOutputStream(binaryOutFile)) {
            //write int data in binary
            int intNum = 10;
            dataOutFile.writeInt(intNum);
            //write double data in binary
            double doubleNum = 3.14;
            dataOutFile.writeDouble(doubleNum);
            //close
            dataOutFile.close();
        } catch (IOException exception) {
        }
    }

    public void readData(String fileName){
        File file = new File(fileName);
        try (FileInputStream binaryInFile = new FileInputStream(file);
             DataInputStream dataInFile = new DataInputStream(binaryInFile)){

            //read int data in binary
            int intNum = dataInFile.readInt();

            //read double data in binary
            double doubleNum = dataInFile.readDouble();
            long length = file.length();
            //close
            dataInFile.close();
        } catch (IOException exception) {
        }
    }
}
