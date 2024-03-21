import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.function.IntConsumer;
public class Main {
    public static void main(String[] args) {

        //zapis("Zadanie1/Grafy/h2.csv",100000,Wektorowe::h2);
        zapis("/home/bary/AlgoNumeryczne/Zadanie1/Grafy/obwod.csv",1000,Wektorowe::obwod);
        //zapis("Zadanie1/Grafy/h3.csv",100000,Wektorowe::h3);
        //zapis("Zadanie1/Grafy/Monte.csv",10000,MonteCarlo::losowanie);
    }
    public static void zapis(String nazwa, int n, IntConsumer function ){
        try {
            FileOutputStream fileOutputStream3 = new FileOutputStream(nazwa);
            PrintStream printStream3 = new PrintStream(fileOutputStream3);
            System.setOut(printStream3);
            System.out.println("X;Y");
            for(int i=4; i<=n; i+=10){
                function.accept(i);
            }

            printStream3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}