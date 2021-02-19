package Jobsheet7_MetodeSecant;

import java.util.Scanner;

public class MetodeSecant {
    public static void main(String[] args) {
        int maks;
        double f=0, h=0, iterasi=0, er=0;

        double a[] = new double[100]; //Mendeklarasi nilai array batas bawah
        double b[] = new double[100]; //Mendeklarasi nilai array batas atas
        double c[] = new double[20]; //Mendeklarasi nilai array c atau nilai x
        double fc[] = new double[20]; //Mendeklarasi nilai array fc atau fx
        double fa[] = new double[20]; //Mendeklarasi nilai array fa
        double fb[] = new double[20]; //Mendeklarasi nilai array fb
        double error[] = new double[100]; //Mendeklarasikan nilai error
        boolean next = true;

        Scanner scan = new Scanner(System.in); //Proses penginputan data
        System.out.print("Masukkan nilai batas atas : "); //Proses penginputan nilai batas atas
        b[1] = scan.nextDouble ();
        System.out.print("Masukkan nilai batas bawah : "); //Proses penginputan nilai batas bawah
        a[1]= scan.nextDouble ();
        System.out.print("Masukkan nilai toleransi error : "); //Proses penginputan nilai error
        er= scan.nextDouble ();
        System.out.print("Tentukan iterasi maksimum : "); //Proses menentukan batas maksimum iterasi
        maks = scan.nextInt();

        fa[1] = (1 + a[1] * (Math.exp (-a[1]))); //Mencari nilai fa sesuai fungsi
        fb[1] = (1 + b [1] * (Math.exp (-b[1]))); //Mencari nilai fa sesuai fungsi
        c[1] = (b[1] - (fb[1] * (b[1] - a[1]) / (fb[1] - fa[1]))); //Mencari nilai c atau x sesuai fungsi
        fc[1] = (1 + c[1] * (Math.exp (-c[1]))); //Mencari nilai fc atau fx sesuai fungsi
        error[1] = Math.abs(fc[1]);

        int i = 1;

        while (next == true && i <= maks) { //Perulangan untuk mencari nilai akar dan nilai final fc atau fx
            fa[i] = (1 + a[i] * (Math.exp (-a [i]))); //Mencari nilai fa di setiap iterasi
            fb[i] = (1 + b[i] * (Math.exp (-b [i]))); //Mencari nilai fb di setiap iterasi
            c[i] = (b[i] - (fb[i] * (b[i] - a[i]) / (fb[i] - fa[i]))); //Mencari nilai c atau x di setiap iterasi
            fc[i] = (1 + c[i] * (Math.exp (-c[i]))); //Mencari nilai fc atau fc di setiap iterasi
            error[i] = ((Math.abs (fc[i]))); //Mencari nilai error
            System.out.println("\nIterasi ke-"+ i); //Menampilkan proses iterasi
            System.out.println("Batas atas = " + String.format ("%.6f", (double) b[i])); //Menampilkan nilai batas atas tiap iterasi
            System.out.println("Batas bawah = " + String.format ("%.6f", (double) a[i])); //Menampilkan nilai batas bawah tiap iterasi
            System.out.println("Nilai c = " + String.format ("%.6f", (double) c[i])); //Menampilkan nilai c atau x tiap iterasi
            System.out.println("f(a) = " + String.format ("%.6f", (double) fa[i])); //Menampilkan nilai fa tiap iterasi
            System.out.println("f(b) = " + String.format ("%.6f", (double) fb[i])); //Menampilkan nilai fb tiap iterasi
            System.out.println("f(c) = " + String.format ("%.6f", (double) fc[i])); //Menampilkan nilai fc atau fx tiap iterasi

            a[i + 1] = b[i]; //Proses menentukan nilai batas bawah pada iterasi selanjutnya
            b[i + 1] = c[i]; //Proses menentukan nilai batas atas pada iterasi selanjutnya

            if (error[i]>er) { //Percabangan untuk menentukan berhentinya pencarian akar
                next = true;
            } else
                next = false;
            f = c[i];
            h = fc[i];
            iterasi = i;

            i++;
        }
        System.out.println("\nAkar c = "+ String.format ("%.6f", (double) f)); //Menampilkan hasil akar
        System.out.println("Hasil f(c) = "+ String.format ("%.6f", (double) h)); //Menampilkan hasil akhir fc atau fx
    }
}
