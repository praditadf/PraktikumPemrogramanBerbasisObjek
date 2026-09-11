package jobsheet03.Tugas2;
import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal());

        float berat;
        
        System.out.print("\nMemasukkan muatan baru seberat : ");
        kontainerAlfa.tambahMuatan(berat = sc.nextFloat());
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
       
        System.out.print("\nMembongkat muat/menurunkan barang seberat : ");
        kontainerAlfa.turunkanMuatan(berat = sc.nextFloat());
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
    }
}