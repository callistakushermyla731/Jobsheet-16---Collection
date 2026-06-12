import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMahasiswa {
    List<Mahasiswa> mahasiswa = new ArrayList<>();

    public void tambah(Mahasiswa... mahasiswa) {
        this.mahasiswa.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index) {
        mahasiswa.remove(index);
    }

    public void update(int index, Mahasiswa mhs) {
        mahasiswa.set(index, mhs);
    }

    public void tampil() {
        mahasiswa.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int LinearSearch(String nim) {
        for (int i = 0; i < mahasiswa.size(); i++) {
            if (nim.equals(mahasiswa.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ListMahasiswa lm = new ListMahasiswa();
        Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");
        Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
        Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");

        lm.tambah(m, m1, m2);
        lm.tampil();
        lm.update(lm.LinearSearch("201235"), new Mahasiswa("201235", "Akhleema", "021xx4"));
        System.out.println("");
        lm.tampil();
    }
}