import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
public class Wektorowe {

    private static double[] w0(int n){
        double alfa = (2*Math.PI)/n;
        return new double[]{
                (Math.cos(alfa)-1),
                Math.sin(alfa)
        };
    }
    private static double alfa(int n){
        return  (2 * Math.PI) / n;
    }
    private static double[] obrotWektora(double[] wektor, double alfa){

        double[][] macierzOdwrotu = { // nasza macierz odwrotu
                {Math.cos(alfa),-Math.sin(alfa)},
                {Math.sin(alfa),Math.cos(alfa)}
        };
        double[] obroconyWektor = new double[2]; // obracanie wektora mnozymy z macierza odwrotu
        obroconyWektor[0] = macierzOdwrotu[0][0]* wektor[0] + macierzOdwrotu[0][1] * wektor[1];
        obroconyWektor[1] = macierzOdwrotu[1][0] * wektor[0] + macierzOdwrotu[1][1] * wektor[1];

        return obroconyWektor;
    }
    private static double dlugosc(double[] wektor){// |U| -> sqrt(Ux^2 + Uy^2)
        return Math.sqrt( (Math.pow(wektor[0],2)) + (Math.pow(wektor[1],2)) );
    }

    public static void obwod(int n) {
        double[] w0 = w0(n);
        double alfa = alfa(n);
        double obwod = dlugosc(w0);

        for (int i = 0; i < n; i++) {
            double[] tmp = Arrays.copyOf(w0, w0.length); // Create a copy of w0
            w0 = obrotWektora(tmp, alfa);
            obwod += dlugosc(w0);
        }
        obwod = Math.abs(2 * Math.PI - obwod);
        System.out.println(n + ";" + obwod);
    }
    public static void h2(int n){
        double[] w0 = w0(n);
        double alfa = alfa(n);
        double[] wyn = new double[2];
        double[] tmp = w0;

        for(int i=0; i<n;i++){
            w0 = obrotWektora(tmp,alfa);
            tmp = w0;
            wyn[0] += w0[0];
            wyn[1]+= w0[1];
        }
        System.out.println(n+";"+wyn[0] + ";" +wyn[1]);
    }

    public static void h3(int n){
        double alf = alfa(n);
        double[] w0 =w0(n);

        double sumXP = 0;
        double sumXN = 0;
        double sumYP = 0;
        double sumYN = 0;
        ArrayList<Double> zXM = new ArrayList<>();
        ArrayList<Double> zXP = new ArrayList<>();
        ArrayList<Double> zYM = new ArrayList<>();
        ArrayList<Double> zYP = new ArrayList<>();

        double[] tmp = w0;
        for (int i = 0; i < n; i++) {
            w0 = obrotWektora(tmp,  alf);
            tmp = w0;
            if (w0[0] > 0) {
                zXP.add(w0[0]);
            } else {
                zXM.add(w0[0]);
            }
            if (w0[1] > 0) {
                zYP.add(w0[1]);
            } else {
                zYM.add(w0[1]);
            }

        }
        Collections.sort(zXP,Collections.reverseOrder());
        Collections.sort(zXM);
        Collections.sort(zYP,Collections.reverseOrder());
        Collections.sort(zYM);
        for (double num : zXP) {
            sumXP += num;
        }
        for (double num : zXM) {
            sumXN += num;

        }
        for (double num : zYP) {
            sumYP += num;
        }
        for (double num : zYM) {
            sumYN += num;
        }


        double sumX = sumXP + sumXN;
        double sumY = sumYP + sumYN;




        System.out.println(n+";"+sumX +";"+ sumY);
    }
}