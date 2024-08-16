
//package FileJava.DoAnMyPham;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ListProduct {
    private SanPham ts[];
    Scanner sc = new Scanner(System.in);

    public void nhapTuFile() { // ham nay la nhap san pham tu file.
        ts = new SanPham[0];
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("FileSp.txt"));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data[1].indexOf("Ho") != -1) {
                    DongHo donghomoi = new DongHo(data[0], data[1], Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]), data[4], data[5], data[6]);
                    ts = Arrays.copyOf(ts, ts.length + 1);
                    ts[ts.length - 1] = (DongHo) donghomoi;

                } else {
                    ts = Arrays.copyOf(ts, ts.length + 1);
                    ts[ts.length - 1] = new DayChuyen(data[0], data[1], Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]), data[4], Float.parseFloat(data[5]), data[6]);
                }
            }
            reader.close();
        } catch (IOException e) {
            // TODO: handle exception
        }

    }

    public void NhapSP_KeyBoard() {
        System.out.print("Nhap so luong san pham: ");
        ts = new SanPham[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < ts.length; i++) {
            System.out.println("0: Nhap Dong Ho.\n1: Nhap Day truyen.");
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) {
                ts[i] = new DongHo();
                System.out.print("Nhap ma san pham: ");
                ts[i].setMasp(sc.nextLine());
                ts[i].nhapByKeyboard();
            } else {
                ts[i] = new DayChuyen();
                System.out.print("Nhap ma san pham: ");
                ts[i].setMasp(sc.nextLine());
                ts[i].nhapByKeyboard();
            }
        }
    }
    public void XuatSP(){
        System.out.println("MaSp"+"\tTenSP"+"\t\tSoLuong"+"\tDonGia"+"\t\tChatLieu"+"\tThuonghieu(KL)"+"\tHatDinh(LoaiMay)");
        for (int i = 0; i < ts.length; i++) {
            if (ts[i] != null) {
                ts[i].xuat();
            } else {
                System.out.println("Phần tử là null");
            }
        }
    }
    public void Them1Sp() {
        ts = Arrays.copyOf(ts, ts.length + 1);
        System.out.println("0: Nhap Dong Ho.\n1: Nhap Day truyen.");
        int n = sc.nextInt();
        if (n == 0) {
            ts[ts.length - 1] = new DongHo();
            ts[ts.length-1].setMasp(sc.nextLine());
            ts[ts.length - 1].nhapByKeyboard();
        } else if (n == 1) {
            ts[ts.length - 1] = new DayChuyen();
            ts[ts.length-1].setMasp(sc.nextLine());
            ts[ts.length - 1].nhapByKeyboard();
        }
    }

    public void ghiVaoFile() { /// ham nay la xuat vao file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("OutputSp.txt"));
            for (int i = 0; i < ts.length; i++) {
                if (ts[i] instanceof DongHo) {
                    DongHo dh = (DongHo) ts[i];
                    writer.write(ts[i].getMasp() + ", " + ts[i].getTenSp() + ", " + ts[i].getSoluong() + ", "
                            + ts[i].getDonGia() + ", " + ts[i].getChatLieu() + ", " + dh.getThuongHieu() + ", "
                            + dh.getLoaiMay());
                    writer.newLine();
                } else {
                    DayChuyen dc = (DayChuyen) ts[i];
                    writer.write(ts[i].getMasp() + ", " + ts[i].getTenSp() + ", " + ts[i].getSoluong() + ", "
                            + ts[i].getDonGia() + ", " + ts[i].getChatLieu() + ", " + dc.getKichThuoc() + ", "
                            + dc.gethatDinh());
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("Ghi thanh cong vao tep!.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }

    }

    public void xoa1Sp() {
        System.out.println("Nhap ma san pham can xoa: ");
        String maxoasp = sc.nextLine();
        int vitrixoa = getViTri(maxoasp);
        for(int i=vitrixoa;i<ts.length;i++){
            ts[i]=ts[i+1];
        }
        ts = Arrays.copyOf(ts, ts.length-1);
    }
    
    // ham nhan gia tien
    public double getDonGia(int vitri) {
        return ts[vitri].getDonGia();
    }

    public int getViTri(String maSp) { // kiem tr vi tri san pham de lay dongia, masp, // tham so truyen vao la ma sp
        int vitri = 0;
        for (int i = 0; i < ts.length; i++) {
            if (maSp.equals(ts[i].getMasp())) {
                vitri = i;
                return vitri;
            }
        }
        return -1;
    }
    public String getMaSp(int vitri) {
        return ts[vitri].getMasp();
    }
    public String getTenSp(int vitri) { // ham hay tra nhan vao vi tri tra ve ten san pham
        return ts[vitri].getTenSp();
    }

    public boolean checkma(String ma) { // ham nay kiem tra xem ma do da ton tai hay chua.
        for (int i = 0; i < ts.length; i++) {
            if(ts[i]==null){

            }
            else if (ma.equals(ts[i].getMasp())) {
                return false; //da ton tai
            }
        }
        return true; // khong ton tai tra ve true
    }
    /// Thoc tinh thay doi so luong
    public void setThemSoLuong(int sl, int vitri) {
        ts[vitri].setSoLuong(sl);
    }
    public void setGiamSoLuong(int sl, int vitri) {
        ts[vitri].setSoLuongBan(sl);
    }

    public void setTangSoLuong(int sl, int vitri){
        ts[vitri].setSoLuongTra(sl);
    }
    // Thuoc tinh thay doi gia
    public void setThayDoiGia(double gia, int vitri) {
        ts[vitri].setGia(gia);
    }
    public void Menu() { // khi goi Menu thi sp tu load len,
        System.out.println("====== QUAN LY SAN PHAM ======");
        System.out.println("1. Nhap San Pham Tu Ban Phim");
        System.out.println("2. Xoa 1 San Pham");
        System.out.println("3. Xuat San Pham");
        System.out.println("4. Them mot san pham");
        System.out.println("5. Doc File");
        System.out.println("6. Thoat");
    }
  //// ham nha sp => khong co sai
    public SanPham getSanPham(String ma){
            for(int i=0;i<ts.length;i++){
                if(ma.equals(ts[i].getMasp())){
                    return ts[i];
                }
            }
        return null;
    }
    public void xuatThongTinSp(int vitri){
        System.out.println(ts[vitri].toString());
    }
}       

    
  

