import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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

    public int binarySearch(String nim) {
        Collections.sort(mahasiswa,
                Comparator.comparing(m -> m.nim));

        return Collections.binarySearch(
                mahasiswa,
                new Mahasiswa(nim, "", ""),
                Comparator.comparing(m -> m.nim));
    }

    public void sortAscending() {
        Collections.sort(mahasiswa,
                (m1, m2) -> m1.nim.compareTo(m2.nim));
    }

    public void sortDescending() {
        Collections.sort(mahasiswa,
                (m1, m2) -> m2.nim.compareTo(m1.nim));
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

        System.out.println("List Ascending");
        lm.sortAscending();
        lm.tampil();

        System.out.println("\nList Descending");
        lm.sortDescending();
        lm.tampil();
    }
}