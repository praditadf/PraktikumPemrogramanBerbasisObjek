package jobsheet04.Tugas;

public class MainKos {
    public static void main(String[] args) {
        Kos kos = new Kos("Kos A", 10);

        Penghuni p1 = new Penghuni("Budi", "081234567890");
        Penghuni p2 = new Penghuni("Alex", "089876543210");
        
        kos.setPenghuni(p1, 1);
        kos.setPenghuni(p2, 2);
        
        System.out.println(kos.info());
        
        Pengelola pengelola = new Pengelola("Achmad");
        
        pengelola.tagihSewa(p1, 450000);
        pengelola.tagihSewa(p2, 450000);
    }
}
