package jobsheet04.percobaan3;

public class MainPercobaan3 {
    public static void main(String[] args) {
        Pegawai masinis = new Pegawai("1234", "Spongebob Squarepants");
        Pegawai asisten = new Pegawai("4567", "Patrick Star");
        KeretaApi keretaApi = new KeretaApi("GayaBaru", "Bisnis", masinis, asisten);
        System.out.println(keretaApi.info());
    }
}