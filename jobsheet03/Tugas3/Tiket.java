package jobsheet03.Tugas3;

public class Tiket {
    private String judulFilm;
    private double hargaDasar;
    private boolean statusPembayaran;

    Tiket(String judulFilm, double hargaDasar) {
        this.judulFilm = judulFilm;
        this.hargaDasar = hargaDasar;
        statusPembayaran = false;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public double getHargaDasar() {
        if (hargaDasar < 0) {
            return hargaDasar = 35000;
        } else {
            return hargaDasar;
        }
    }

    public boolean isStatusPembayaran() {
        return statusPembayaran;
    }

    public void lakukanPembayaran() {
        statusPembayaran = false;
    }
}