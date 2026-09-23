package jobsheet04.percobaan6;

public class Laptop {
    private String merk;
    private Printer printerDefault;

    public Laptop(String merk, Printer printerDefault) {
        this.merk = merk;
        this.printerDefault = printerDefault;
    }

    public void cetakDokumen(String namaFile) {
        System.out.println(merk + " mengirim dokumen ke printer...");
        printerDefault.cetak(namaFile);
    }
}