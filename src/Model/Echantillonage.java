package Model;

import Model.Complexe;
import Model.Nombre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by maxim on 07/12/2016.
 */

public class Echantillonage {
    private static final Logger LOGGER = LoggerFactory.getLogger(Echantillonage.class);
    protected Complexe matrice[][];
    protected int echantillonage;
    protected int nbPoints ;
    protected int nbFenetre;
    protected Complexe tabPts[];
    protected Nombre nb;
    //Constructeur
    public Echantillonage (int echantillonage,int nbPoints,Complexe tabPts[]){
        this.echantillonage=echantillonage;
        this.nbPoints=nbPoints;
        this.tabPts=tabPts;
        this.nb=new Nombre(2);
        this.matrice=new Complexe[nbPoints+echantillonage][echantillonage+1];
        this.nbFenetre=0;




    }
    //On remplie le tableau de points avec un 0 au début
    public void rempliTab0(){
        int i,compt;
        Complexe temp;
        temp=new Complexe(0,0);
        for(int k=this.nbPoints+1;k>0;k--){

            tabPts[k]=tabPts[k-1];


        }
        tabPts[0]= new Complexe(0,0);
        this.nbPoints=this.nbPoints+1;

        //LOGGER.debug("this.nbpoints = "+this.nbPoints);

    }
    //On calcul pour chaque fenetre les coefficients aj
    public void calculColonneAj(){
        int i,j,compt,compt2,compt3;
        Complexe temp[]=new Complexe[this.echantillonage];
        Complexe temp2;

        compt2=0;
        compt3=0;
        for(i=0;i<this.nbPoints;i=(i+this.echantillonage)-1){
            compt=0;

            for(j=(i);j<i+(this.echantillonage);j++){
                if(tabPts[j]==null){//Si dans la fenetre il manque des points on complete avec des zeros
                    tabPts[j]=new Complexe(0,0);
                    //this.nbPoints++;
                    compt3++;
                }
                temp[compt]=tabPts[j];
               /*LOGGER.debug("j="+j);
                LOGGER.debug("compt="+compt);*/

                compt++;
            }



            this.matrice[compt2]=nb.calculFourierRapide(temp);
            compt2++;
            this.nbFenetre++;


        }
        for(i=0;i<compt3;i++){
            this.nbPoints++;
        }
    }
    public void selectioneAj(){//On selectionne seulement les aj appartenant  à [0;L/2]
        for(int i=0;i<this.nbPoints/this.echantillonage;i++){
            for(int j=0;j<(this.echantillonage)/2;j++){
                this.matrice[i][j]=this.matrice[i][this.echantillonage-1-j];
                this.matrice[i][this.echantillonage-1-j]=null;
            }
        }


    }
    public void moduleAj(){//On fait le module des aj
        for(int i=0;i<this.nbFenetre;i++){
            for(int j=0;j<(this.echantillonage)/2;j++){
                this.matrice[i][j]=(this.matrice[i][j]).abs();
            }
        }
    }


    public Complexe[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(Complexe[][] matrice) {
        this.matrice = matrice;
    }

    public int getEchantillonage() {
        return echantillonage;
    }

    public void setEchantillonage(int echantillonage) {
        this.echantillonage = echantillonage;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public int getNbFenetre() {
        return nbFenetre;
    }

    public void setNbFenetre(int nbFenetre) {
        this.nbFenetre = nbFenetre;
    }

    public Complexe[] getTabPts() {
        return tabPts;
    }

    public void setTabPts(Complexe[] tabPts) {
        this.tabPts = tabPts;
    }

    public Nombre getNb() {
        return nb;
    }

    public void setNb(Nombre nb) {
        this.nb = nb;
    }
}
