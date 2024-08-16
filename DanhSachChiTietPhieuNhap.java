import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class DanhSachChiTietPhieuNhap {
    ChiTietPhieuNhap[] dsctpn;
    int n = 0;
    Scanner scanner = new Scanner(System.in);
    public DanhSachChiTietPhieuNhap() {
        dsctpn = new ChiTietPhieuNhap[0];
    }

    public DanhSachChiTietPhieuNhap(ChiTietPhieuNhap[] dsctpn2) {
        this.dsctpn = dsctpn2;
    }
    // public void docFile() {
    //     dsctpn = new ChiTietPhieuNhap[0];
    //     try {
    //         BufferedReader reader = new BufferedReader(new FileReader("DsChiTietPhieuNhap.txt"));
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             dsctpn = Arrays.copyOf(dsctpn, dsctpn.length+1);
    //             String[] arr = line.split(", ");
    //             dsctpn[dsctpn.length-1] = new  ChiTietPhieuNhap(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]),Double.parseDouble(arr[4]),arr[5]);
    //         }
    //         reader.close();
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }
    public void docFile() {
        dsctpn = new ChiTietPhieuNhap[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DsChiTietPhieuNhap.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                
                dsctpn = Arrays.copyOf(dsctpn, dsctpn.length+1);
                String[] arr = line.split(", ");
                dsctpn[dsctpn.length-1] = new  ChiTietPhieuNhap(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]),Double.parseDouble(arr[4]),arr[5]);
            }
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void ghiFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
            for(int i=0;i<dsctpn.length;i++){
                writer.write(dsctpn[i].toString());
                System.out.println(dsctpn[i].toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
    public void nhap() { 
        System.out.println("Nhap so chi phieu nhap: ");
        dsctpn = new ChiTietPhieuNhap[n];
        for (int i = 0; i < n; i++) {
            dsctpn[i] = new ChiTietPhieuNhap();
            dsctpn[i].nhap();
            System.out.println("");
        }
    }
    //// chuc them san pham vao san pham.
    public void nhapVaoSanPham(ListProduct product){
        System.out.print("Nhap ma phieu nhap: ");
        String mapn = scanner.nextLine();
        System.out.print("Nhap ma san pham: ");
        String masp = scanner.nextLine();
        for(int i=0; i<dsctpn.length;i++){
            if(dsctpn[i].getMaPhieuNhap().equals(mapn)){
                if(dsctpn[i].getMaSanPham().equals(masp)){
                        product.setThemSoLuong(dsctpn[i].getSoLuong(), product.getViTri(masp));
                }
            }
        }
    }
    public void xuat() {
        System.out.println("MaPhieuNhap\tmaSp\t\tSoLuong\t\tDonGia\t\tThanhTien");
        for (int i = 0; i < dsctpn.length-1; i++) {
            if(dsctpn[i].getStatus().equals("1")){
                dsctpn[i].xuat();
            }
        }
    }
    public Double them(String maPN, ListProduct product){
        Double tongtien = 0.0;
        System.out.print("Nhap so luong chi tiet phieu nhap can them: ");
        int sl = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<sl;i++){
            dsctpn =  Arrays.copyOf(dsctpn, dsctpn.length+1);
            dsctpn[dsctpn.length-1] = new ChiTietPhieuNhap();
            dsctpn[dsctpn.length-1].nhap();
            dsctpn[dsctpn.length-1].setMaPhieuNhap(maPN);
             dsctpn[dsctpn.length-1].setStatus("1");
            String maSanPham = dsctpn[dsctpn.length-1].getMaSanPham();
             int vitri = product.getViTri(maSanPham);
            product.setTangSoLuong(dsctpn[dsctpn.length-1].getSoLuong(), vitri);
            tongtien += dsctpn[dsctpn.length-1].getThanhTien();
        }
        return tongtien;
    }
   
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma chi tiet phieu nhap can sua chua: ");
        String maktra = scanner.nextLine();
        // tim ma chi tiet
        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (dsctpn[i].getMaPhieuNhap().equalsIgnoreCase(maktra)) {
                viTri = i;
                break;
            }
        }
        if (viTri != -1) {
            String maSanPham;
            int soLuong;
            double donGia;
            System.out.println(" nhap ma san pham can sua: ");
            maSanPham = scanner.nextLine();
            System.out.println(" nhap so luong cua chi tiet phieu nhap can sua: ");
            soLuong = scanner.nextInt();
            System.out.println(" nhap don gia can sua: ");
            donGia = scanner.nextDouble();
            dsctpn[viTri].setMaSanPham(maSanPham);
            dsctpn[viTri].setSoLuong(soLuong);
            dsctpn[viTri].setDonGia(donGia);
            System.out.println("da sua chua xong chi tiet phieu nhap voi ma: " + maktra);
        } else {
            System.out.println("khong tim thay ma chi tiet phieu nhap: " + maktra);
        }
    }
    // sua truyen tham so lam sau

    public void xoa(ListProduct product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma phieu nhap: ");
        String maPN = scanner.nextLine();
        System.out.println("Nhap ma san pham");
        String maSP = scanner.nextLine();
        for(int i=0;i<dsctpn.length;i++){
            if(dsctpn[i].getMaPhieuNhap().equals(maPN) && dsctpn[i].getMaSanPham().equals(maSP)){

                dsctpn[i].setStatus("0");
                
                int viTri = product.getViTri(maSP);
                product.setGiamSoLuong(dsctpn[i].getSoLuong(), viTri);
            }
        }
    }
    public ChiTietPhieuNhap timKiemMaPhieuNhap(String maPhieuNhap) {
        maPhieuNhap = maPhieuNhap.trim();
        System.out.println("maPhieuNhap: " + maPhieuNhap);
        for (int i = 0; i < n; i++) {
            System.out.println("maPhieuNhap: " + maPhieuNhap);
            System.out.println("dsctpn[i].getMaPhieuNhap(): " + dsctpn[i].getMaPhieuNhap());
            if ((dsctpn[i].getMaPhieuNhap()).equalsIgnoreCase(maPhieuNhap)) {
                dsctpn[i].xuat();
                return dsctpn[i];
            }
        }
        System.out.println("Không tim thay");
        return null;
    }

    public ChiTietPhieuNhap timKiemMaSanPham(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if (dsctpn[i].getMaSanPham().equalsIgnoreCase(maSanPham)) {
                dsctpn[i].xuat();
                return dsctpn[i];
            }
        }
        System.out.println("khong tim thay");
        return null;
    }

    public ChiTietPhieuNhap[] timKiemDonGia(double minPrice, double maxPrice) {
        ChiTietPhieuNhap[] ketQua = new ChiTietPhieuNhap[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsctpn[i].getDonGia() >= minPrice && dsctpn[i].getDonGia() <= maxPrice) {
                dsctpn[i].xuat();
                System.out.println( );
                ketQua[count] = dsctpn[i];
                count++;
            }
        }
        System.out.println("so san pham tim thay: "+ count);
        if (count == 0) {
            System.out.println("khong tim thay chi tiet hoa don voi gia tu " + minPrice + "->" + maxPrice);
            return null;
        }
        return Arrays.copyOf(ketQua, count);

    }

    public ChiTietPhieuNhap[] timKiemSoLuong(int soLuong) {
        ChiTietPhieuNhap[] ketQua = new ChiTietPhieuNhap[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsctpn[i].getSoLuong() == soLuong) {
                dsctpn[i].xuat();
                System.out.println("-------------" );
                ketQua[count++] = dsctpn[i];
            }
        }
        System.out.println("so san pham tim thay: "+ count);
        if (count == 0) {
            System.out.println("khong tim thay chi tiet voi:" + soLuong);
            return null;
        }
        ketQua = Arrays.copyOf(ketQua, count);
        return ketQua;
    }
    public double tongTienTheoPhieuNhap(String maPhieuNhap) {
        double tongTien = 0;

        for (int i = 0; i < n; i++) {
            if (dsctpn[i].getMaPhieuNhap().equalsIgnoreCase(maPhieuNhap)) {
                tongTien += dsctpn[i].getThanhTien();
            }
        }

        return tongTien;
    }
    public void Menu(){
        System.out.println("1. Them chi tiet phieu nhap.");
        System.out.println("2. Xoa Chi Tiet phieu nhap.");
        System.out.println("3. Xuat danh sach chi tiet phieu nhap.");
        System.out.println("4. sua chi tiet phieu nhap.");
        System.out.println("5. thoat.");
    }
    public ChiTietPhieuNhap []getDSCTPN(){
        return dsctpn;
    }
}
