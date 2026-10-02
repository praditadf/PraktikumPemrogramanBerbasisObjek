package jobsheet06.tugas2;

public class TelevisiModern extends Televisi {
    private String modeTampilan;
    private String dvd = "kosong";

    public TelevisiModern(String merek, int jumlahChannel){
        super(merek, jumlahChannel);
    }

    public void gantiModusTampilan(String mode) {
        this.modeTampilan = mode;
    }

    public void masukkanDVD(String judul) {
        this.dvd = judul;
    }

    public void mainkanDVD(){
        if (dvd != null) {
            System.out.println("Sedang memainkan DVD: " + dvd);
        }
    }
}