package TugasPraktikum16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainNilai {
    static ArrayList<Mahasiswa> listMhs = new ArrayList<>();
    static ArrayList<MataKuliah> listMK = new ArrayList<>();
    static ArrayList<Nilai> listNilai = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        listMhs.add(new Mahasiswa("20001", "Thalhah", "021xxx"));
        listMhs.add(new Mahasiswa("20002", "Zubair", "021xxx"));
        listMhs.add(new Mahasiswa("20003", "Abdur-Rahman", "021xxx"));
        listMhs.add(new Mahasiswa("20004", "Sa'ad", "021xxx"));
        listMhs.add(new Mahasiswa("20005", "Sa'id", "021xxx"));
        listMhs.add(new Mahasiswa("20006", "Ubaidah", "021xxx"));

        listMK.add(new MataKuliah("00001", "Internet of Things", 3));
        listMK.add(new MataKuliah("00002", "Algoritma dan Struktur Data", 2));
        listMK.add(new MataKuliah("00003", "Algoritma dan Pemrograman", 2));
        listMK.add(new MataKuliah("00004", "Praktikum Algoritma dan Struktur Data", 3));
        listMK.add(new MataKuliah("00005", "Praktikum Algoritma dan Pemrograman", 3));

        int pilih;

        do {
            System.out.println("=================================================");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("=================================================");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    inputNilai();
                    sc.nextLine();
                    break;
                case 2:
                    tampilNilai();
                    sc.nextLine();
                    break;
                case 3:
                    cariNilai();
                    break;
                case 4:
                    urutNilai();
                    break;
            }
        } while (pilih != 5);
    }

    static void inputNilai() {
        System.out.println("Masukkan Data Nilai");
        System.out.print("Kode : ");
        String kode = sc.next();

        System.out.print("Nilai : ");
        double nilai = sc.nextDouble();
        sc.nextLine();

        System.out.println("\nDAFTAR MAHASISWA");
        System.out.println("================================================");
        System.out.printf("%-8s %-20s %-10s\n", "NIM", "NAMA", "NO. TELP");

        for (Mahasiswa m : listMhs) {
            System.out.printf("%-8s %-20s %-10s\n",
                    m.nim, m.nama, m.notelp);
        }

        System.out.print("Pilih Mahasiswa by NIM : ");
        String nim = sc.next();

        System.out.println("\nDAFTAR MATA KULIAH");
        System.out.println("================================================");

        System.out.printf("%-8s %-40s %-5s\n", "Kode", "Mata Kuliah", "SKS");

        for (MataKuliah mk : listMK) {
            System.out.printf("%-8s %-40s %-5d\n",
                    mk.kodeMK, mk.namaMK, mk.sks);
        }

        System.out.print("Pilih Mata Kuliah by Kode MK : ");
        String kodeMK = sc.next();

        Mahasiswa mhsDipilih = null;
        MataKuliah mkDipilih = null;

        for (Mahasiswa m : listMhs) {
            if (m.nim.equals(nim)) {
                mhsDipilih = m;
            }
        }

        for (MataKuliah mk : listMK) {
            if (mk.kodeMK.equals(kodeMK)) {
                mkDipilih = mk;
            }
        }

        listNilai.add(new Nilai(mhsDipilih, mkDipilih, nilai));
    }

    static void tampilNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.printf("%-8s %-15s %-35s %-15s %-8s\n",
                "NIM", "NAMA", "MATA KULIAH", "SKS", "NILAI");

        for (Nilai n : listNilai) {
            System.out.printf("%-8s %-15s %-35s %-15d %-8.2f\n",
                    n.mhs.nim,
                    n.mhs.nama,
                    n.mk.namaMK,
                    n.mk.sks,
                    n.nilai);
        }
    }

    static void cariNilai() {
        System.out.print("Masukkan Data Mahasiswa [NIM] : ");
        String nim = sc.next();

        int totalSKS = 0;

        System.out.printf("%-8s %-15s %-35s %-15s %-8s\n",
                "NIM", "NAMA", "MATA KULIAH", "SKS", "NILAI");

        for (Nilai n : listNilai) {
            if (n.mhs.nim.equals(nim)) {
                System.out.printf("%-8s %-15s %-35s %-15d %-8.2f\n",
                        n.mhs.nim,
                        n.mhs.nama,
                        n.mk.namaMK,
                        n.mk.sks,
                        n.nilai);

                totalSKS += n.mk.sks;
            }
        }

        System.out.println("Total SKS " + totalSKS + " telah diambil.");
    }

    static void urutNilai() {
        Collections.sort(listNilai,
                (a, b) -> Double.compare(a.nilai, b.nilai));

        tampilNilai();
    }
}