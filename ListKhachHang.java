import java.io.*;
import java.util.*;

public class ListKhachHang implements Thaotac {
    private KhachHang kh[];
    Scanner sc = new Scanner(System.in);

    public void NhapDanhSachKhachHang() {
        System.out.print("Nhap so luong khach hang:");
        kh = new KhachHang[Integer.parseInt(sc.nextLine())];
        sc.next();
        for (int i = 0; i < kh.length; i++) {
            kh[i] = new KhachHang();
            kh[i].nhap();
        }
    }

    public boolean checkma(String ma) {
        for (int i = 0; i < kh.length; i++) {
            if (ma.equals(kh[i].getMaKhachHang())) {
                return false;
            }
        }
        return true;
    }

    public int checkvitri(String ma) { // get vitri
        for (int i = 0; i < kh.length; i++) {
            if (ma.equals(kh[i].getMaKhachHang())) {
                return i;
            }
        }
        System.out.println("Khong tim thay ma khach hang !");
        return -1;
    }

    public String getmaKHvitri ( int vitri ){
        return kh[vitri].getMaKhachHang();
    }

    

    public void hienthithongtinVitri( int vitri){
        System.out.println("------Thong tin khach hang------");
        System.out.println("Ma khach hang: " + kh[vitri].getMaKhachHang());
        System.out.println("Ho ten: " + kh[vitri].getTenKhachHang());
        System.out.println("Dia chi: " + kh[vitri].getdiaChi());
        System.out.println("So dien thoai: " + kh[vitri].getsoDienThoai());
        System.out.println("Gioi tinh: " + kh[vitri].getgioiTinh());
    }

    public void hienthiTatCaThongTin(){
        System.out.println("------ THONG TIN TAT CA KHACH HANG ------");
        System.out.println("MAKH\t" + "Ho Ten\t\t\t" + "Dia Chi\t\t\t" + "So Dien Thoai\t" + "Gioi Tinh\t" + "Bac");
        for ( int i=0; i < kh.length; i++){
            System.out.println(
            kh[i].getMaKhachHang() + "\t" +
            kh[i].getTenKhachHang() + "\t\t" +
            kh[i].getdiaChi() + "\t\t" +
            kh[i].getsoDienThoai() + "\t" +
            kh[i].getgioiTinh() + "\t\t" +
            kh[i].getPhanLoai());
        }
    }

    public void them() {
        int sl;
        int index = kh.length;
        System.out.print("Nhap so luong khach hang can them:");
        sl = Integer.parseInt(sc.nextLine());
        kh = Arrays.copyOf(kh, sl + kh.length);
        for (int i = index; i < kh.length; i++) {
            KhachHang kh1 = new KhachHang();
            kh[i] = new KhachHang();
            String ma;
            while(true){
                System.out.print("Nhap ma khach hang: ");
                ma =  sc.nextLine();
                if(checkma(ma)==true){
                    break;
                }
                System.out.print("sai, vui long nhap lai:");
            }
            // kh1.nhap();
            kh[i].nhap();
            kh[i].setMaKhachHang(ma);
            kh[i].setPhanLoai(0);
        }
    }
    public void xoa(){
        while(true){
            System.out.print("Nhap ma nha vien can xoa:");
            String maNv =  sc.nextLine();
            int index = checkvitri(maNv);
            if (index != -1) {
                for (int i = index; i < kh.length - 1; i++) {
                    kh[i] = kh[i + 1];
                }
                break;
            } else {
                System.out.print("Sai, vui long nhap lai:");
            }
        }
        kh = Arrays.copyOf(kh, kh.length - 1);
    }

    public void sua() {
        int vitri = -1;
        while (true) {
            System.out.print("Nhap vi tri can sua:");
            vitri = Integer.parseInt(sc.nextLine());
            if (vitri < 0 || vitri >= kh.length) {
            } else {
                break;
            }
        }
        kh[vitri].nhap();
    }

    public void ghiFile() {
        String fileName = "KhachHang.txt"; // Tên tệp tin để ghi dữ liệu
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < kh.length; i++) {
                writer.write(kh[i].toString());
                
                writer.newLine(); // Thêm ký tự xuống dòng sau mỗi phần tử
            }
            writer.close(); // Đóng luồng ghi
            //System.out.println("Ghi du lieu thanh cong vao tep " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docFile() {
        String fileName = "KhachHang.txt";
        try {
            kh = new KhachHang[0];

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(", ");
                KhachHang KhachHangMoi = new KhachHang(attributes[0], attributes[1], attributes[2], attributes[3],
                        attributes[4], attributes[5]);
                kh = Arrays.copyOf(kh, kh.length + 1);
                kh[kh.length - 1] = KhachHangMoi;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xuatKhachHang(){
        for(int i=0;i<kh.length;i++){
            kh[i].hienThiThongTin();
        }
    }

    public KhachHang getKhachHang() {
        Random rd = new Random();
        int x = rd.nextInt(kh.length);
        return kh[x];
    }

    public void setPhanLoaiKhachHang(String maKH, int soLanMua, double tongTien){
        for ( int i = 0; i < kh.length; i++){
            if ( kh[i].getMaKhachHang().equals(maKH)){
                if (soLanMua >= 2 && tongTien >= 1000.0){
                    kh[i].setPhanLoai(1);
                    if (soLanMua >= 3 && tongTien >= 1800.0){
                        kh[i].setPhanLoai(2);
                        if (soLanMua >= 4 && tongTien >= 3000.0){
                            kh[i].setPhanLoai(3);
                            if (soLanMua >= 5 && tongTien >= 5000.0){
                            kh[i].setPhanLoai(4);
                            }
                        }
                    }
                } 
                else {
                     kh[i].setPhanLoai(0);
                }
            } else if (kh[i].getPhanLoai() == null){
                kh[i].setPhanLoai(0);
            }
        }
    }

    public void Menu(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("====== QUAN LY KHACH HANG ======");
        System.out.println("1. Them khach hang ");
        System.out.println("2. Sua thong tin khach hang ");
        System.out.println("3. Xoa thong tin khach hang");
        System.out.println("4. Xem thong tin tat ca khach hang");
        System.out.println("5. Doc tu file thong tin khach hang");
        System.out.println("6. Thoat");
        System.out.println("Lua chon: ");
    }
}
