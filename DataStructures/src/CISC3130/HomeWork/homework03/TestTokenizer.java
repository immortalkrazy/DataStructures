import java.io.File;
import java.io.FileNotFoundException;

public class TestTokenizer {

    public static void main(String[] args) throws FileNotFoundException {

        File dataFile = new File("test.txt");
        System.out.println(dataFile.exists());

        Concordance cc = new Concordance("test.txt");
        cc.add();
        cc.print();
        System.out.println("SIZE: " + cc.count("any"));

        System.out.println(cc);
    }



}
