import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DanhSachHoaDon {
    private HoaDon[] danhSachHoaDon;
    Scanner sc = new Scanner(System.in);

    public DanhSachHoaDon() {
        danhSachHoaDon = new HoaDon[0];
    }

    public void ghiVaoFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("DsHoaDon.txt"));
            for (int i = 0; i < danhSachHoaDon.length; i++) {
                writer.write(danhSachHoaDon[i].toString2());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    // đọc danh sách hóa đơn từ file
    public void nhapTuFile(ListKhachHang kh) {
        danhSachHoaDon = new HoaDon[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DsHoaDon.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(", ");
                danhSachHoaDon = Arrays.copyOf(danhSachHoaDon, danhSachHoaDon.length + 1);
                danhSachHoaDon[danhSachHoaDon.length - 1] = new HoaDon(data[0], data[1], data[2], data[3], data[4],
                        Double.parseDouble(data[5]), data[6]);
            }
            reader.close();
        } catch (IOException e) {
            // TODO: handle exception
        }

        for ( int i=0; i < danhSachHoaDon.length; i++){
            capNhatKhachHang(danhSachHoaDon[i].getMaKhachHang(), kh);
        }
    }

    ///// them mot hoa don.
    public void themHoaDon(String maHD, ListProduct product) {

        danhSachHoaDon = Arrays.copyOf(danhSachHoaDon, danhSachHoaDon.length + 1);
        danhSachHoaDon[danhSachHoaDon.length - 1] = new HoaDon();

        danhSachHoaDon[danhSachHoaDon.length - 1].setMaHoaDon(maHD);

        System.out.println("Nhap ma khach hang: ");
        danhSachHoaDon[danhSachHoaDon.length - 1].setMaKhachHang(sc.nextLine());

        System.out.println("Nhap ma nhan vien: ");
        danhSachHoaDon[danhSachHoaDon.length - 1].setMaNhanVien(sc.nextLine());

        System.out.println("Nhap ngay lap hoa don theo dinh dang ( ngay/thang/nam ): ");
        String ngayLap = sc.nextLine();
        if ( kiemTraNgayThangNam(ngayLap) == false ){
        do {
            ngayLap = sc.nextLine();
            danhSachHoaDon[danhSachHoaDon.length - 1].setNgayLap(ngayLap);
        } while (kiemTraNgayThangNam(ngayLap) == false);
        } else {
            danhSachHoaDon[danhSachHoaDon.length-1].setNgayLap(ngayLap);
        }

        System.out.println("Nhap gio lap hoa don theo dinh dang ( gio:phut ): ");
        String gioLap = sc.nextLine();
        if ( kiemTraGioPhut(gioLap) == false){
        do {
            gioLap = sc.nextLine();
            danhSachHoaDon[danhSachHoaDon.length - 1].setGioLap(gioLap);
        } while (kiemTraGioPhut(gioLap) == false);
        } else {
            danhSachHoaDon[danhSachHoaDon.length - 1].setGioLap(gioLap);
        }
        
        danhSachHoaDon[danhSachHoaDon.length - 1].setStatus("1");

    }

    public boolean kiemTraMaHoaDon(String maHD) {
       // danhSachHoaDon = Arrays.copyOf(danhSachHoaDon, danhSachHoaDon.length + 1);
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHD) && 
            danhSachHoaDon[i].getStatus().equals("1")) {
                System.out.println("Ma hoa don da ton tai, vui long nhap ma hoa don khac ");
                return false;
            }
        }
        return true;
    }

    public boolean kiemTraNgayThangNam(String input) {
        // Định dạng chuỗi ngày/tháng/năm:
        String regex = "\\d{1,2}/\\d{1,2}/\\d{4}";
        // Kiểm tra định dạng bằng biểu thức chính quy
        String[] parts = input.split("/");
        int ngay = Integer.parseInt(parts[0]);
        int thang = Integer.parseInt(parts[1]);
        if (input.matches(regex)){
            if ( (thang == 2 && ngay <= 28)  || 
        ((thang == 1 || thang == 3 || thang ==5 || thang == 7 ||
         thang == 8 || thang == 10 || thang == 12) && ngay <= 31) || 
        ((thang == 4 || thang == 6 || thang == 9 || thang == 11) && ngay <= 30 )){
           return true ;
        } else {
            System.out.println("Ngay va thang khong hop ly, nhap lai: ");
            return false;
        }
        } else{
            System.out.println("Nhap sai dinh dang (ngay/thang/nam), nhap lai: ");
            return false;
        }
       
    }

    public boolean kiemTraGioPhut(String input) {
        // Định dạng chuỗi giờ:phút:
        String regex = "\\d{1,2}:\\d{2}";
        // Kiểm tra định dạng bằng biểu thức chính quy
        String[] parts = input.split(":");
        if (input.matches(regex)){
            int gio = Integer.parseInt(parts[0]);
        int phut = Integer.parseInt(parts[1]);
        if ( gio >= 0 && gio <= 24 && phut >= 0 && phut <= 59){
            return true ;
        } else {
            System.out.println("Gio va phut khong hop ly, nhap lai: ");
            return false;
        }
        } else {
            System.out.println("Nhap sai dinh dang (gio:phut), nhap lai: ");
            return false;
        }
        
    }

    public void xemTatCaHoaDon() {
        int index = 0;
        System.out.println("\n============ TAT CA HOA DON ============\n");
        System.out.println("STT\t" + "Ma hoa don\t" + "Ma khach hang\t" + "Ma nhan vien\t" +
                "Ngay lap\t" + "Gio lap\t\t" + "Tong Tien");
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getStatus().equals("1")) {
                System.out.println((index + 1) + "\t" + danhSachHoaDon[i].toString());
                index++;
            }
        }
    }

    public void xemHoaDonCuThe(String maHD, ListKhachHang dskh, ListNhanVien dsnv) {
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHD) && danhSachHoaDon[i].getStatus().equals("1")) {
                System.out.println("\n======THONG TIN HOA DON======");
                System.out.println("Ma hoa don\t" + "Ma khach hang\t" + "Ma nhan vien\t" +
                        "Ngay lap\t\t" + "Gio lap\t\t" + "Tong Tien");
                System.out.println(danhSachHoaDon[i].toString());
                int choice = 0;
                do {
                    System.out.println("\n======THONG TIN KHAC======");
                    System.out.println("1. Thong tin ve khach hang cua hoa don");
                    System.out.println("2. Thong tin ve nhan vien lap hoa don");
                    System.out.println("3. Thoat ");
                    System.out.println("Lua chon: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            String maKH = danhSachHoaDon[i].getMaKhachHang();
                            dskh.hienthithongtinVitri(dskh.checkvitri(maKH));
                            break;

                        case 2:
                            String maNV = danhSachHoaDon[i].getMaNhanVien();
                            dsnv.hienthithongtinVitri(dsnv.getvitriNV(maNV));
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Lua chon khong hop le");
                    }
                } while (choice != 3);
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don");
    }

    public boolean checkMaHoaDon(String maHD){
        for ( int i=0; i< danhSachHoaDon.length; i++){
            if ( danhSachHoaDon[i].getMaHoaDon().equals(maHD) &&
            danhSachHoaDon[i].getStatus().equals("1")){
                return true;
            }
        }
        return false;
    }

    public void suaHoaDon(String maHD, ListKhachHang  kh) {
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHD) && danhSachHoaDon[i].getStatus().equals("1")) {

                System.out.println("Nhap ma khach hang: ");
                danhSachHoaDon[i].setMaKhachHang(sc.nextLine());

        String ngayLap;
        do {
        System.out.println("Nhap ngay lap hoa don theo dinh dang ( ngay/thang/nam ): ");
        ngayLap = sc.nextLine();
        danhSachHoaDon[i].setNgayLap(ngayLap);
        } while ( kiemTraNgayThangNam(ngayLap) == false );
       

        String gioLap;
        do {
        System.out.println("Nhap gio lap hoa don theo dinh dang ( gio:phut ): ");
        gioLap = sc.nextLine();
        danhSachHoaDon[i].setGioLap(gioLap);
        } while (kiemTraGioPhut(gioLap) == false );
        capNhatKhachHang(danhSachHoaDon[i].getMaKhachHang(), kh);
                return;
            }
        }

        System.out.println("Khong tim thay ma hoa don");
    }

    public void xoaHoaDon(String maHD, ListKhachHang kh) {
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHD)) {
                danhSachHoaDon[i].setStatus("0");
                capNhatKhachHang(danhSachHoaDon[i].getMaKhachHang(), kh);
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don");
    }

    public void capNhatTongTienHoaDon(String maHD, double tongTienMoi, ListKhachHang kh) {
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHD)) {
                danhSachHoaDon[i].setTongTien(tongTienMoi);
                capNhatKhachHang(danhSachHoaDon[i].getMaKhachHang(), kh);
            }
        }
    }
    public void capNhatKhachHang(String maKH, ListKhachHang kh){
        int soLan = 0;
        double tongTien = 0.0;
        for ( int i=0; i< danhSachHoaDon.length; i++){
            if (danhSachHoaDon[i].getMaKhachHang().equals(maKH) && 
                danhSachHoaDon[i].getStatus().equals("1")){
                soLan++;
                tongTien += danhSachHoaDon[i].getTongTien();
            }
        }
         kh.setPhanLoaiKhachHang(maKH, soLan, tongTien);
    }

    public void thongKeTheoQuy(){
        System.out.print("Nhap nam de thong ke theo quy: ");
        String nam = sc.nextLine();
        System.out.print("Nhap quy: ");
        String quy = sc.nextLine();
        Double tong = 0.0;
        System.out.println("\t\t===========Danh sach hoa don tim kiem theo quy "+quy+" nam "+nam+" ===========");
        System.out.println("\tMa hoa don\t" + "Ma khach hang\t" + "Ma nhan vien\t" +
                        "Ngay lap\t" + "Gio lap\t\t" + "TongTien");
        for(int i=0; i<danhSachHoaDon.length; i++){
            String data[] = danhSachHoaDon[i].getNgayLap().split("/");
            int thang = Integer.parseInt(data[1]);
            if(nam.equals(data[2])){
                if(quy.equals("1")){
                    if(thang>=1&&thang<=3){
                        System.out.println("\t"+danhSachHoaDon[i].toString());
                        tong+=danhSachHoaDon[i].getTongTien();
                    }
                }
                else if(quy.equals("2")){
                    if(thang>=4&&thang<=6){
                        System.out.println("\t\t"+danhSachHoaDon[i].toString());
                        tong+=danhSachHoaDon[i].getTongTien();
                    }
                }
                else if(quy.equals("3")){
                    if(thang>=7&&thang<=9){
                        System.out.println("\t\t"+danhSachHoaDon[i].toString());
                        tong+=danhSachHoaDon[i].getTongTien();
                    }
                }
                else if(quy.equals("4")){
                    if(thang>=10&&thang<=12){
                        System.out.println("\t"+danhSachHoaDon[i].toString());
                        tong+=danhSachHoaDon[i].getTongTien();
                    }
                }
            }   
        }   
        System.out.println("--------------------------");
        System.out.println("tong tien hoa don quy "+quy+" la: "+ tong+"$");
    }
   
    public boolean checkNgay_Nam(String mahd, String thang, String nam) {
        for (int i = 0; i < danhSachHoaDon.length; i++) {
            String data[] = danhSachHoaDon[i].getNgayLap().split("/");
            if (mahd.equalsIgnoreCase(danhSachHoaDon[i].getMaHoaDon())
                    && danhSachHoaDon[i].getStatus().equalsIgnoreCase("1")
                    && nam.equalsIgnoreCase(data[2]) && thang.equalsIgnoreCase(data[1])) {
                return true;
            }
        }
        return false;
    }

    

    public void thongKeKhachHang(ListKhachHang kh) {
        String[] maKH = new String[100];
        double[] tongTien = new double[100];
        int[] soLanMua = new int[100];
        String[] phanLoai = new String[100];
        boolean[] daXet = new boolean[100];
        Arrays.fill(soLanMua, 0);
        Arrays.fill(daXet, false);
        int index = 0;

        for (int i = 0; i < danhSachHoaDon.length; i++) {
            if (danhSachHoaDon[i].getStatus().equals("1") &&
                    daXet[i] == false) {
                maKH[index] = danhSachHoaDon[i].getMaKhachHang();
                tongTien[index] = danhSachHoaDon[i].getTongTien();
                soLanMua[index]++;
                daXet[i] = true;
                for (int j = 0; j < danhSachHoaDon.length; j++) {
                    if (danhSachHoaDon[j].getMaKhachHang().equals(danhSachHoaDon[i].getMaKhachHang()) &&
                            daXet[j] == false && danhSachHoaDon[i].getStatus().equals("1")) {
                        tongTien[index] += danhSachHoaDon[j].getTongTien();
                        soLanMua[index]++;
                        daXet[j] = true;
                    }
                } index++;
            }
        }
        /* 
        // set bậc khách hàng
        for ( int i=0; i<maKH.length; i++){
            if ( maKH[i] == null){
                break;
            }
            else {
                kh.setPhanLoaiKhachHang(maKH[i], soLanMua[i], tongTien[i]);
            }
        }
        */

        // tìm khách hàng mua hàng số tiền lớn nhất
        double maxTongTien = tongTien[0];
        String maxKhachHang1 = maKH[0];
        for (int i = 1; i < maKH.length; i++) {
            if (maKH[i] == null) {
                break;
            }
            if (tongTien[i] > maxTongTien) {
                maxTongTien = tongTien[i];
                maxKhachHang1 = maKH[i];
            }
        }
        // truong hop co tren 2 khach co tong tien lon nhat nhung bang nhau
        index =0;
        String[] maxKhachHang_1 = new String[20];
        for ( int i=0; i< maKH.length; i++){
            if (maKH[i] == null){
                break;
            }
            if ( tongTien[i] == maxTongTien && maKH[i] != maxKhachHang1){
                maxKhachHang_1[index] = maKH[i];
                index++;
            }
        }

        // tìm khách hàng có số lần mua nhiều nhất
        int maxSoLan = soLanMua[0];
        String maxKhachHang2 = maKH[0];
        for (int i = 0; i < maKH.length; i++) {
            if (maKH[i] == null) {
                break;
            }
            if (soLanMua[i] > maxSoLan) {
                maxSoLan = soLanMua[i];
                maxKhachHang2 = maKH[i];
            }
        }
        // truong hop co tren 2 khach co so lan mua lon nhat nhung bang nhau
        index =0;
        String[] maxKhachHang_2 = new String[20];
        for ( int i=0; i< maKH.length; i++){
            if ( maKH[i] == null){
                break;
            }
            if ( soLanMua[i] == maxSoLan && maKH[i] != maxKhachHang2){
                maxKhachHang_2[index] = maKH[i];
                index++;
            }

        }
        // tính tỉ lệ khách hàng quay lại ( số lần mua > 2 ) -> tỉ lệ = so kh mua >=2 /
        // số kh
        double tiLeQuayLai;
        int soLuongKhachHang = 0;
        int soLanQuayLai = 0;
        for (int i = 0; i < maKH.length; i++) {
            if (maKH[i] == null) {
                break;
            }
            soLuongKhachHang++;
            if (soLanMua[i] >= 2) {
                soLanQuayLai++;
            }
        }
        tiLeQuayLai = (double) soLanQuayLai / soLuongKhachHang;

        // tinh gia tri trung binh cua moi hoa don, avg = tongTongTien / tongSoLanMua
        double giaTriTrungBinhHoaDon;
        double tongDoanhThu = 0.0;
        int tongSoLanMua = 0;
        for ( int i=0; i< maKH.length; i++){
            if (maKH[i]==null){
                break;
            }
            tongDoanhThu += tongTien[i];
            tongSoLanMua += soLanMua[i];
        } 
        giaTriTrungBinhHoaDon = (double) tongDoanhThu / tongSoLanMua;


        System.out.println("\n==================  THONG KE KHACH HANG MUA HANG  ==================");
        System.out.println("Ma khach hang\t\t" + "So lan mua hang\t\t" + "Tong tien mua hang");
        for (int i = 0; i < maKH.length; i++) {
            if (maKH[i] == null)
                break;
            System.out.println(maKH[i] + "\t\t\t" + soLanMua[i] + "\t\t\t" + tongTien[i] + "$");
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.print("+ Khach hang co tong tien mua lon nhat: " + maxKhachHang1);
        for ( int i=0; i< maxKhachHang_1.length; i++){
            if (maxKhachHang_1[i] != null ){
                System.out.print(", " + maxKhachHang_1[i]);
            }
        }
        System.out.println("\n- Tong tien: " + maxTongTien + "$\n");
        System.out.print("+ Khach hang co so lan mua hang nhieu nhat: " + maxKhachHang2);
        for ( int i=0; i< maxKhachHang_2.length; i++){
            if (maxKhachHang_2[i] != null ){
                System.out.print(", " + maxKhachHang_2[i]);
            }
        }
        System.out.println("\n- So lan: " + maxSoLan + "\n");
        System.out.printf("+ Ti le khach hang quay lai: %.2f", tiLeQuayLai * 100);
        System.out.print("%\n");
        System.out.printf("\n+ Gia tri trung binh cua don hang: %.2f$ \n", giaTriTrungBinhHoaDon );
        System.out.println("----------------------------------------------------------------------");

    }

    //// xuat bill cho khach hang.
    public void xuatBill( String mahd,DsChiTietHoaDon dscthd) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt"));
            writer.write("\n==================  XUAT BILL KHACH HANG  ===================\n");
            for (int i = 0; i < danhSachHoaDon.length; i++) {
                if (mahd.equalsIgnoreCase(danhSachHoaDon[i].getMaHoaDon())) {
                    writer.write("MaHD: "+danhSachHoaDon[i].getMaHoaDon()+"\n");
                    writer.write("MaNV: "+danhSachHoaDon[i].getMaNhanVien()+"\n");
                    writer.write("MaKh: "+danhSachHoaDon[i].getMaKhachHang()+"\n");
                    writer.write("Gio: "+danhSachHoaDon[i].getGioLap()+"\n");
                    writer.write("Ngay: "+danhSachHoaDon[i].getNgayLap()+"\n");
                    writer.write("TTien: "+Double.toString(danhSachHoaDon[i].getTongTien())+"\n");
                }
            }
            writer.write("\n==================  Chi tiet hoa don  ===================\n");
            writer.write("\t\t\tMaSp\tSoluong\tDongia\tthanhtien\n");
            for (int i = 0; i < dscthd.getDanhSachChiTiet().length; i++) {
                if (mahd.equalsIgnoreCase(dscthd.getDanhSachChiTiet()[i].getMaHoaDon())) {
                    writer.write("\t\t\t--------------------------------\n");
                    writer.write("\t\t\t"+dscthd.getDanhSachChiTiet()[i].getMaSanPham()+"\t\t");
                    writer.write(dscthd.getDanhSachChiTiet()[i].getSoLuong()+"\t\t");
                    writer.write(Double.toString(dscthd.getDanhSachChiTiet()[i].getDonGia())+"\t");
                    writer.write(Double.toString(dscthd.getDanhSachChiTiet()[i].getThanhTien())+"\t");
                    writer.newLine();
                }
            }
            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
