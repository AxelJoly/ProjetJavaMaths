/**
 * Created by maxim on 05/12/2016.
 */
public class Reel extends Nombre {
    public Reel(int N){
        super(N);
    }

    public Complexe[] calculFourierRapide(Complexe[] uk) {
        int n = uk.length;

        // base case
        if (n == 1) return new Complexe[] { uk[0] };

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) { throw new RuntimeException("n is not a power of 2"); }

        // fft of even terms
        Complexe[] tempPaire = new Complexe[n/2];
        for (int k = 0; k < n/2; k++) {
            tempPaire[k] = uk[2*k];
        }
        Complexe[] q = calculFourierRapide(tempPaire);

        // fft of odd terms
        Complexe[] tempImpaire  = tempPaire;  // reuse the array
        for (int k = 0; k < n/2; k++) {
            tempImpaire[k] = uk[2*k + 1];
        }
        Complexe[] r = calculFourierRapide(tempImpaire);

        // combine
        Complexe[] aj = new Complexe[n];
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complexe wk = new Complexe(Math.cos(kth), Math.sin(kth));
            aj[k]       = q[k].plus(wk.times(r[k]));
            aj[k + n/2] = q[k].minus(wk.times(r[k]));
        }

        return (aj);
    }
}
