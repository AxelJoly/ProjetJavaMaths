package Model;
import java.io.*;
/**
 * Created by maxim on 08/12/2016.
 */
public class ReadFiles {
    public int main(Complexe[]  tab){
        String chaine="";
        int compt;
        int taille=0;
        String fichier ="fichiertexte.txt";

        //lecture du fichier texte
        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            compt=0;
            while ((ligne=br.readLine())!=null){
                if (compt == 0) {
                    taille = Integer.parseInt(ligne);
                }
                else {
                    tab[compt] = new Complexe(Integer.parseInt(ligne), 0);
                }
                compt++;
                System.out.println(ligne);
                chaine+=ligne+"\n";

            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        //création ou ajout dans le fichier texte
       /* try {
            FileWriter fw = new FileWriter (fichier);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter fichierSortie = new PrintWriter (bw);
            fichierSortie.println (chaine+"\n test de lecture et écriture !!");
            fichierSortie.close();
            System.out.println("Le fichier " + fichier + " a été créé!");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }*/
       return(taille);
    }

}
