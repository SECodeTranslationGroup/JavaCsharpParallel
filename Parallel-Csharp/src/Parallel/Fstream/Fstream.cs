using System;
using System.Collections.Generic;
using System.IO;
using Parallel.Linq101.DataSources;
namespace Parallel_Csharp.Parallel.fstream;

public class Fstream
{
    private const string FileName = "file.txt";
    private const int Size = 109;

    public static FileStream GetFileInputStream(string filepath)
    {
        FileStream fileInputStream= null;
        try {
            fileInputStream = new FileStream(filepath, FileMode.Open, FileAccess.Read);
        }
        catch (FileNotFoundException e) {
            Console.WriteLine("Error: file not existed.");
            Console.WriteLine(e.StackTrace);
        }
        return fileInputStream;
    }

    public static FileStream GetFileOutputStream(string filepath, bool append) {
        FileStream fileOutputStream= null;
        try {
            fileOutputStream = new FileStream(filepath, append? FileMode.Append: FileMode.Open, FileAccess.Write);
        }
        catch (FileNotFoundException e) {
            Console.WriteLine("Error: file not existed.");
            Console.WriteLine(e.StackTrace);
        }
        return fileOutputStream;
    }

    public int WriteFileBinary(){
        byte[] bytes = { 99, 100, 101, 102 };
        try {
            FileStream outFile = File.Open(FileName, FileMode.Create, FileAccess.Write);
            outFile.Write(bytes);
            outFile.Close();
        }
        catch (IOException exception) {
            return -1;
        }
        return 0;
    }
    
    public int ReadFileBinary(int length) {
        byte[] bytes = new byte[length];
        int n = 0;
        try{
            FileStream inFile = File.Open(FileName, FileMode.Open, FileAccess.Read);
            n = inFile.Read(bytes);
            inFile.Close();
        }
        catch (IOException exception) {
            return -1;
        }
        return n;
    }
    
    public int CountFileSize(){
        int count = 0;
        byte[] bytes = new byte[10];
        try{
            FileStream file = File.Open(FileName, FileMode.Create, FileAccess.Read);
            BinaryReader dataInFile = new BinaryReader(file);
            while(true){
                bytes = dataInFile.ReadBytes(bytes.Length);
                if(bytes.Length != 10) {
                    count += bytes.Length;
                    dataInFile.Close();
                    file.Close();
                    break;
                }
                else{
                    count += 10;
                }
            }
        }catch(IOException exception){}
        return count;
    }

    private static long Copy(string inFilePath, string outFilePath, byte[] buffer)
    {
        FileStream? inFile = null;
        FileStream? outFile = null;
        try
        {
            inFile = File.Open(inFilePath, FileMode.Open, FileAccess.Read);
            outFile = File.Open(outFilePath, FileMode.Truncate, FileAccess.Write);
            long total = 0;
            while (true)
            {
                int res = inFile.Read(buffer);
                if (res == 0)
                {
                    break;
                }

                if (res > 0)
                {
                    total += res;
                    if (outFile != null)
                    {
                        outFile.Write(buffer, 0, res);
                    }
                }
            }
            outFile.Flush();
            inFile.Close();
            outFile.Close();
            inFile = null;
            outFile = null;
            return total;
        }
        catch (IOException e) {
            Console.WriteLine(e.StackTrace);
        }
        return 0;
    }

    public int WriteProductToFile(string fileName, Product product)
    {
        StreamWriter? streamWriter = null;
        try{
            streamWriter = new StreamWriter(fileName);
            streamWriter.Write(product.ToString());
            streamWriter.Close();
        }catch(IOException e){
            return -1;
        }
        return 0;
    }

    public string? ReadLine(string fileName)
    {
        string? str;
        using (StreamReader reader = File.OpenText(fileName))
        {
            str = reader.ReadLine();
        }
        return str;
    }

    public void WriteData(String fileName)
    {
        try
        {
            FileStream binaryOutFile = new FileStream(fileName, FileMode.Create, FileAccess.Write);
            BinaryWriter dataOutFile = new BinaryWriter(binaryOutFile);
            
            int intNum = 10;
            dataOutFile.Write(intNum);
            
            double doubleNum = 3.14;
            dataOutFile.Write(doubleNum);
        }
        catch (IOException exception) {
        }
    }

    public void ReadData(String fileName)
    {
        try {
            FileStream binaryInFile = new FileStream("file.txt", FileMode.Open, FileAccess.Read);
            BinaryReader dataInFile = new BinaryReader(binaryInFile);

            //read int data in binary
            int intNum = dataInFile.ReadInt32();
            //read double data in binary
            double doubleNum = dataInFile.ReadDouble();
            //get byte length of binary file
            long length = binaryInFile.Length;
            //close
            binaryInFile.Close();
        } catch (IOException exception) {
        }
    }
}