/**
 * Created by maxim on 06/12/2016.
 */
public class CalculComplexe extends Reel {

    public CalculComplexe(int N){
        super(N);
    }
    public Complexe[] calculSerieFourrierRapideComplexe(Complexe[] uk){
        int n = uk.length;
        Complexe[] aj = new Complexe[n];

        // On prend le conjugué de uk et on le met ds aj
        for (int i = 0; i < n; i++) {
            aj[i] = uk[i].conjugate();
        }

        // On cfait le calcul de serie de fourrier rapide de aj et on le met dans aj
        aj = calculFourierRapide(aj);

        // On refait le conjugué de aj et on le remet dans aj
        for (int i = 0; i < n; i++) {
            aj[i] = aj[i].conjugate();
        }

        // On divise par n
        for (int i = 0; i < n; i++) {
            aj[i] = aj[i].scale(1.0 / n);
        }
             
        return aj;
    }
}
