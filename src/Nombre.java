/**
 * Created by maxim on 05/12/2016.
 */
public abstract class  Nombre {
    protected double taille;
    protected float aj;
    public  Nombre(int N){
        taille=Math.pow(2, N);

    }
    public  float calculFourierRapideReel(){

        return(aj);

    }
}
