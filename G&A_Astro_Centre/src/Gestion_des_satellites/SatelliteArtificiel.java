package Gestion_des_Satellites;
import java.util.Date;
import java.util.Scanner;
//import java.util.Scanner;
public final class SatelliteArtificiel extends Satellite {
    private String dateLancement;
    private String etatOperationnel;
    private int dureeVie;
  public String getDateLancement() {
        return dateLancement;
    }

    public String getEtatOperationnel() {
        return etatOperationnel;
    }

    public int getDureeVie() {
        return dureeVie;
    }

    public void setDateLancement(String dateLancement) {
        this.dateLancement = dateLancement;
    }

    public void setEtatOperationnel(String etatOperationnel) {
        this.etatOperationnel = etatOperationnel;
    }

    public void setDureeVie(int dureeVie) {
        this.dureeVie = dureeVie;
    }
    
    public SatelliteArtificiel(String nom, String orbite,float vitess, String dateLancement,String etat ,int d) {
        super(nom, orbite,vitess);
        this.dateLancement = dateLancement;
        this.etatOperationnel = etat;
        this.dureeVie = d;  // Par défaut, la date de durée de vie est initialisée à la date actuelle.
    }
  
        
    @Override
    public void saisirsatellie(){
     super.saisirsatellie();
      Scanner scan=new Scanner(System.in);
    //System.out.print("donner la date de lancement de sattelite artif :");
    //dateLancement=scan.next;
     System.out.print("donner letat  de sattelite :");
     etatOperationnel=scan.next();
    System.out.print("donner le dure de vie  de sattelite :");
    dureeVie=scan.nextInt();
       
        
    }
   


    public void ajusterVitesse(float dv) {
        System.out.println("volez vous augmenter ou diminiuer la vitesse 0:augmenter / 1:diminuer ");
         System.out.println("donner votre choix ");
        Scanner scanner=new Scanner(System.in);
        int choix=scanner.nextInt();
        if(choix==0){this.vitesse+=dv;}
         if(choix==1){this.vitesse-=dv;}
    }

    @Override
    public String toString() {
        return 
                super.toString()+"SatelliteArtificiel{" +
                "dateLancement=" + dateLancement.toString() +
                "étatOpérationnel=" + etatOperationnel +
                  "duréeVie=" + dureeVie +
                '}';
    }



}
