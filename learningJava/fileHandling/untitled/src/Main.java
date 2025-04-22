import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        FileInputStream fis = new FileInputStream("a.txt");
//        FileOutputStream fos = new FileOutputStream("Test.txt");
//        fos.write("اهلا ومرحبا بكم".getBytes("UTF-8"));
//        System.out.println(new FileInputStream("Test.txt").read());

         // arr of byte
//        byte[] arr = new byte[3];
//        fis.read(arr);
//        System.out.println((char)arr[0]);
//        String s = new String(arr);
//        System.out.println(s);


//        loop
//        int data;
//        while ((data = fis.read()) != -1){
//            System.out.println((char) data);
//        }

//        System.out.println((char)fis.read());
//        System.out.println((char)fis.read());
//        System.out.println((char)fis.read());
//        System.out.println((char)fis.read());
        //Reading image
        File f = new File("H:\\Java\\fileHandling\\An-Agile-Life-Cycle-Approach.png");
        FileInputStream fis = new FileInputStream(f);
        byte [] im = new byte[(int)f.length()];
        fis.read(im);
        for (int i = 0; i < f.length(); i++) {
            System.out.print(im[i]);
        }
        // Write image
        FileOutputStream fos = new FileOutputStream("H:\\Java\\fileHandling\\An-Agile-Life-Cycle-Approach1.png");
        fos.write(im);
        fos.flush();
        fos.close();
        fis.close();

    }
}