package jobsheet04.percobaan3;

public class MainPertanyaan {
    public static void main(String[] args) {
        Pegawai masinis = new Pegawai("1234", "Spongebob Squarepants");
        KeretaApi keretaApi = new KeretaApi("GayaBaru", "Bisnis", masinis);
        System.out.println(keretaApi.info());
    }
}