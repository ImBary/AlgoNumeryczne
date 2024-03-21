import java.util.Random;
public class MonteCarlo {

    public MonteCarlo(){}

    public static void losowanie(int N){
        int sum = 0;
        Random rand = new Random();
        for(int i = 0; i<N; i++){
            double x = rand.nextDouble(1);
            double y = rand.nextDouble(1);

            if(Math.sqrt((Math.pow(x,2) + Math.pow(y,2)))<=1){
                sum++;
            }
        }
        double szacowanePi = (4.0 * sum) / N ;
        System.out.println(N+";"+szacowanePi);
    }
}
