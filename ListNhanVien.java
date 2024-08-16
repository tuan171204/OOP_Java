import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ListNhanVien implements Thaotac {
    Scanner sc = new Scanner(System.in);
    private NhanVien[] nv;

    public void nhapNhanVien() {
        int arraySize;
        System.out.print("Nhap so luong nhan vien: ");
        arraySize = sc.nextInt();
        nv = new NhanVien[arraySize];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = new NhanVien();
            nv[i].nhap();
        }
    }

    public void xuatNhanVien() {
        for (int i = 0; i < nv.length; i++) {
            nv[i].hienThiThongTin();
        }
    }

    public boolean ktraMaNV(String maNV) {
        for (int i = 0; i < nv.length; i++) {
            if (maNV.equals(nv[i].getMaNhanVien())) {
                return false; // SAO CHECK CÓ MÃ LẠI TRẢ VỀ FALSE NHỈ
            }
        }
        return true;
    }

    public int getvitriNV(String maNV) {
        for (int i = 0; i < nv.length; i++) {
            if (maNV.equals(nv[i].getMaNhanVien())) {
                return i;
            }
        }
        System.out.println("Khong tim thay ma nhan vien !");
        return 0;

    }

    public void hienthithongtinVitri(int vitri) {
        System.out.println("------Thong tin nhan vien------");
        System.out.println("Ma nhan vien: " + nv[vitri].getMaNhanVien());
        System.out.println("Ho ten: " + nv[vitri].getTenNhanVien());
        System.out.println("Ngay sinh: " + nv[vitri].getNgaySinh());
        System.out.println("Dia chi: " + nv[vitri].getDiaChi());
        System.out.println("So dien thoai: " + nv[vitri].getsoDienThoai());
        System.out.println("Gioi tinh: " + nv[vitri].getgioiTinh());
    }

    public void hienthiTatCaThongTin(){
        System.out.println("------ THONG TIN TAT CA NHAN VIEN ------");
        System.out.println("MANV\t" + "Ho Ten\t\t\t" + "Ngay Sinh\t" + "Dia Chi\t\t" + "So Dien Thoai\t\t" + "Gioi Tinh");
        for ( int i=0; i < nv.length; i++){
            System.out.println(
            nv[i].getMaNhanVien() + "\t" +
            nv[i].getTenNhanVien() + "\t\t" +
            nv[i].getNgaySinh() + "\t" +
            nv[i].getDiaChi() + "\t" +
            nv[i].getsoDienThoai() + "\t\t" +
            nv[i].getgioiTinh());
        }
    }

    public void them() {
        int sl;
        int index = nv.length;
        System.out.print("Nhap so luong can them:");
        sl = Integer.parseInt(sc.nextLine());

        nv = Arrays.copyOf(nv, nv.length + sl);
        for (int i = index; i < nv.length; i++) {
            nv[i] = new NhanVien();
            System.out.println("Nhap thong tin nhan vien can them ");
            while (true) {
                System.out.println("Nhap ma nhan vien: ");
                String maNV = sc.nextLine();
                if (ktraMaNV(maNV)) {

                    nv[i].setMaNhanVien(maNV);
                    nv[i].nhap();
                    break;
                }
                System.out.println("Id trung, moi nhap lai!");
            }
        }
    }

    public void xoa() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ma = sc.nextLine();
        int kt = 0;
        for (int i = 0; i < nv.length; i++) {
            if (ma.equalsIgnoreCase(nv[i].getMaNhanVien())) {
                kt = 1;
                for (int j = i; j < nv.length - 1; j++) {
                    nv[j] = nv[j + 1];
                }
                nv[nv.length - 1] = null;
                nv = Arrays.copyOf(nv, nv.length - 1);
                System.out.println("Da xoa thanh cong!");
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Khong tim thay nhan vien can xoa");
        }
    }

    public void sua() {
        System.out.println("Nhap ma nhan vien can sua: ");
        String ma = sc.nextLine();
        int kt = 0;
        for (int i = 0; i < nv.length; i++) {
            if (ma.equalsIgnoreCase(nv[i].getMaNhanVien())) {
                kt = 1;
                System.out.println("Nhap thong tin nhan vien can sua: ");
                nv[i].nhap();
                System.out.println("Da sua thanh cong!");
                break;
            }
        }
        if (kt == 0) {
            System.out.println("Khong tim thay nhan vien can sua");
        }
    }

    public void ghiFile() {
        try {
            FileWriter fr = new FileWriter("dsNhanVien.txt", false);
            BufferedWriter fw = new BufferedWriter(fr);
            for (int i = 0; i < nv.length; i++) {
                fw.write(nv[i].toString());
                fw.newLine();
            }
            fw.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("loi xay ra");
        }
    }

    public void docFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dsNhanVien.txt"));
            nv = new NhanVien[0];
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(", ");
                NhanVien taoNhanVienMoi = new NhanVien(attributes[0],attributes[1],
                 attributes[2], attributes[3], attributes[4], attributes[5]);
                nv = Arrays.copyOf(nv, nv.length + 1);
                nv[nv.length - 1] = taoNhanVienMoi;
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    public NhanVien getNhanVien() {
        Random rd = new Random();// random ve mot nhan vien bat ky khi tao don hang
        return nv[rd.nextInt(5)];
    }
    
    public void Menu(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("====== QUAN LY NHAN VIEN ======");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Sua thong tin nhan vien ");
        System.out.println("3. Xoa thong tin nhan vien");
        System.out.println("4. Xem thong tin tat ca nhan vien");
        System.out.println("5. Doc tu file thong tin nhan vien");
        System.out.println("6. Thoat");
        System.out.println("Lua chon: ");
        
    }

}

