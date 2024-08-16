public class test_xongxoa {
    public static void main(String []args){
        DanhSachPhieuNhap dspn = new DanhSachPhieuNhap();
        DanhSachChiTietPhieuNhap ctpn = new DanhSachChiTietPhieuNhap();
        ListProduct product =  new ListProduct();
        ListKhachHang dskh = new ListKhachHang();
        ListNhanVien dsnv = new ListNhanVien();
        DsNhaCungCap dsncc = new DsNhaCungCap();
        DanhSachChiTietPhieuNhap dsctpn = new DanhSachChiTietPhieuNhap();
        dsctpn.docFile();
        dskh.docFile();
        dsnv.docFile();
        dsncc.docFile();
        dsctpn.docFile();
        dspn.docFile();
  
        dsctpn.xuat();
        dsctpn.timKiemMaPhieuNhap("PN002");
        //dsctpn.ghiFile();
    }


    

}