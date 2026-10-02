package jobsheet06.tugas2;

public class Televisi {
    public String merek;
    public int jumlahChannel;
    private int channelAktif;

    public Televisi(String merek, int jumlahChannel) {
        this.merek = merek;
        this.jumlahChannel = jumlahChannel;
    }

    public void pindahChannel(int channel) {
        if (channel >= 1 && channel <= jumlahChannel) {
            this.channelAktif = channel;
        }else {
            System.out.println("Channel tidak tersedia.");
        }
    }

    public int getChannelAktif() {
        return channelAktif;
    }
}