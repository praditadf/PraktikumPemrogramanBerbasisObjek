package jobsheet04.Tugas;

public class Kamar {
    private String nomor;
    private Penghuni penghuni;

    public Kamar(String nomor) {
        this.nomor = nomor;
    }

    public void setPenghuni(Penghuni penghuni) {
        this.penghuni = penghuni;
    }

    public Penghuni getPenghuni() {
        return penghuni;
    }

    public String info() {
        String info = "";
        info += "Kamar " + nomor + " :\n";
        if (this.penghuni != null) {
            info += penghuni.info();
        }
        return info;
    }
}
