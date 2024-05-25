package Gestion_des_Satellites;

import java.util.Scanner;

public final class SatelliteNaturel extends Satellite {
    private float periodeRevolution;
    private  float diametre;

    public float getPeriodeRevolution() {
        return periodeRevolution;
    }

    public float getDiametre() {
        return diametre;
    }

    public SatelliteNaturel(String nom, String orbite, float v,float periodeRevolution, float diametre) {
        super(nom, orbite, v);
        this.periodeRevolution = periodeRevolution;
        this.diametre = diametre;
    }
     
   @Override
    public void saisirsatellie(){
    super.saisirsatellie();
    Scanner scan=new Scanner(System.in);
    System.out.print("donner la periode de revolution   de sattelite :");
    vitesse=scan.nextFloat();
   System.out.print("donner le diametre de sattelite :");
    vitesse=scan.nextFloat();
   }

    public SatelliteNaturel(float periodeRevolution, float diametre, String nom, String orbite, float v) {
        super(nom, orbite, v);
        this.periodeRevolution = periodeRevolution;
        this.diametre = diametre;
    }


    @Override
    public String toString() {
        return super.toString()+"SatelliteNaturel{" +
                "périodeRévolution=" + periodeRevolution +"diametre=" +this.diametre+
                '}';
    }
    

    public void setPeriodeRevolution(float periodeRevolution) {
        this.periodeRevolution = periodeRevolution;
    }

    public void setDiametre(float diametre) {
        this.diametre = diametre;
    }
}
