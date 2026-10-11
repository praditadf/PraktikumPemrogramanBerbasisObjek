package jobsheet07.Tugas1;

public class Segitiga {
    private int sudut;

    public int sisaSudut(int sudutA) {
        return 180 - sudutA;
    }

    public int sisaSudut(int sudutA, int sudutB) {
        return 180 - (sudutA + sudutB);
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        return sisiA + sisiB + Math.sqrt((sisiA*sisiA)+(sisiB*sisiB));
    }

    public int getSudut() {
        if (sudut <= 0 || sudut >= 180) {
            throw new IllegalArgumentException();
        }else{
            return sudut;
        }
    }
}