import java.io.*;
import java.util.*;

public class Menu {
  DanhSachHoaDon dshd = new DanhSachHoaDon();
  DsChiTietHoaDon dscthd = new DsChiTietHoaDon();
  ListProduct dssp = new ListProduct();
  ListNhanVien dsnv = new ListNhanVien();
  ListKhachHang dskh = new ListKhachHang();
  DsNhaCungCap dsncc = new DsNhaCungCap();
  DanhSachChiTietPhieuNhap dsctpn = new DanhSachChiTietPhieuNhap();
  DanhSachPhieuNhap dspn = new DanhSachPhieuNhap();

  Scanner sc = new Scanner(System.in);

  public void Menu_chinh() {
    dssp.nhapTuFile();
    dsnv.docFile();
    dskh.docFile();
    dscthd.nhapTuFile();
    dshd.nhapTuFile(dskh);
    dsncc.docFile();
    dspn.docFile();
    dsctpn.docFile();

    int choice = 0;
    do {
      System.out.println("\n====== MENU CHINH ======");
      System.out.println("1. Quan ly hoa don ");
      System.out.println("2. Quan ly san pham ");
      System.out.println("3. Quan ly nhan vien ");
      System.out.println("4. Quan ly khach hang");
      System.out.println("5. Quan ly nha cung cap");
      System.out.println("6. Quan ly phieu nhap san pham ");
      System.out.println("7. Thong ke ");
      System.out.println("8. Tim kiem nang cao");
      System.out.println("9. Luu File");
      System.out.println("Lua chon: ");
      choice = Integer.parseInt(sc.nextLine());

      switch (choice) {

        case 1:
          Menu_Hoa_Don();
          break;

        case 2:

          Menu_SanPham();
          break;

        case 3:
          Menu_NV();
          break;

        case 4:
          Menu_KH();
          break;

        case 5:
          dsncc.Menu();
          break;

        case 6:
          Menu_Phieu_Nhap();
          break;

        case 7:
          Menu_Thong_Ke();
          break;

        case 8:
          Menu_Tim_Kiem();
          break;

        case 9:
          Menu_Luu_File();
          break;
        default:
          System.out.println("Lua chon khong hop le ");
      }

    } while (true);
  }

  // 1.QUAN LY HOA DON
  public void Menu_Hoa_Don() {
    int choice = 0;
    do {
      System.out.println("\n====== QUAN LY HOA DON ======");
      System.out.println("1. Quan ly danh sach hoa don ");
      System.out.println("2. Quan ly chi tiet hoa don");
      System.out.println("3. Thoat");
      System.out.println("Lua chon: ");
      choice = Integer.parseInt(sc.nextLine());

      switch (choice) {

        case 1:
          quanLyDanhSachHoaDon();
          break;
        case 2:
          quanLyChiTietHoaDon();
          break;
        case 3:
          break;
        default:
          System.out.println("Lua chon khong hop le ");
      }
    } while (choice != 3);
  }

  // a.QUAN LY DANH SACH HOA DON

  public void quanLyDanhSachHoaDon() {
    int choice = 0;
    do {
      System.out.println("\n====== QUAN LY DANH SACH HOA DON ======");
      System.out.println("1. Them hoa don ");
      System.out.println("2. Xem thong tin hoa don");
      System.out.println("3. Sua hoa don ");
      System.out.println("4. Xoa hoa don ");
      System.out.println("5. Doc tu file hoa don ");
      System.out.println("6. Thoat");
      System.out.println("Lua chon: ");
      choice = Integer.parseInt(sc.nextLine());

      switch (choice) {

        case 1:
          ThemHoaDon();
          break;

        case 2:
          XemHoaDon();
          break;

        case 3:
          SuaHoaDon();
          break;

        case 4:
          XoaHoaDon();
          break;

        case 5:
          if (dshd != null) {
            System.out.println("nhap File khong thanh cong!");
            break;
          }
          dshd.nhapTuFile(dskh);
        case 6:
          break;

        default:
          System.out.println("Lua chon khong hop le ");

      }

    } while (choice != 6);
  }

  // Them hoa don
  public void ThemHoaDon() {
    System.out.println("\n======THEM HOA DON======");
    String maHD;
    do {
      System.out.println("Nhap ma hoa don: ");
      maHD = sc.nextLine();
    } while (dshd.kiemTraMaHoaDon(maHD) == false);

    dshd.themHoaDon(maHD, dssp);
    double tongTien = dscthd.themChiTiet(maHD, dssp);
    dshd.capNhatTongTienHoaDon(maHD, tongTien, dskh);
    dshd.xuatBill(maHD, dscthd);
  }

  // Xem hoa don
  public void XemHoaDon() {
    System.out.println("\n======XEM HOA DON======");
    System.out.println("1. Xem tat ca hoa don ");
    System.out.println("2. Xem hoa don cu the ");
    System.out.println("Lua chon: ");

    int choice = 0;
    choice = Integer.parseInt(sc.nextLine());
    if (choice == 1) {
      dshd.xemTatCaHoaDon();
    } else if (choice == 2) {
      System.out.println("Nhap ma hoa don muon xem: ");
      String maHD = sc.nextLine();
      dshd.xemHoaDonCuThe(maHD, dskh, dsnv);
    } else {
      System.out.println("Lua chon khong hop le ");
    }

  }

  // Sua hoa don
  public void SuaHoaDon() {
    dshd.xemTatCaHoaDon();
    System.out.println("\n======SUA HOA DON======");
    System.out.println("Nhap ma hoa don muon sua:");
    String maHD = sc.nextLine();
    dshd.suaHoaDon(maHD, dskh);
  }

  // Xoa hoa don.
  public void XoaHoaDon() {
    dshd.xemTatCaHoaDon();
    System.out.println("\n======XOA HOA DON======");
    System.out.println("Nhap ma hoa don muon xoa: ");
    String maHD = sc.nextLine();
    dshd.xoaHoaDon(maHD, dskh);
    dscthd.xoaChiTiet(maHD, dssp);
  }

  // b.QUAN LY CHI TIET HOA DON
  public void quanLyChiTietHoaDon() {
    int choice = 0;
    do {
      System.out.println("\n====== QUAN LY CHI TIET HOA DON ======");
      System.out.println("1. Them chi tiet hoa don ");
      System.out.println("2. Xem thong tin chi tiet hoa don");
      System.out.println("3. Sua chi tiet hoa don ");
      System.out.println("4. Xoa chi tiet hoa don ");
      System.out.println("5. Doc tu file chi tiet hoa don "); // de cho coi thoi, chu doc file thi chi duoc doc 1 lan
      System.out.println("6. Thoat");
      System.out.println("Lua chon: ");
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {

        case 1:
          ThemChiTiet(dssp);
          break;

        case 2:
          XemChiTiet();
          break;

        case 3:
          SuaChiTiet();
          break;

        case 4:
          XoaChiTiet();
          break;

        case 5:
          if (dscthd != null) {
            System.out.println("doc File khong thanh cong!");
          }
          break;

        default:
          System.out.println("Lua chon khong hop le");
      }
    } while (choice != 6);
  }

  // Them chi tiet
  public void ThemChiTiet(ListProduct product) {
    dshd.xemTatCaHoaDon();
    System.out.println("\n======THEM CHI TIET======");
    System.out.println("Nhap ma hoa don muon them chi tiet: ");
    String maHD = sc.nextLine();
    if (dshd.checkMaHoaDon(maHD) == false) {// khong tim thay ma hoa don
      do {
        System.out.println("Khong tim thay ma hoa don, vui long nhap lai: ");
        maHD = sc.nextLine();
      } while (dshd.checkMaHoaDon(maHD) == false);
    }

    double tongTienMoi = dscthd.them1ChiTiet(product, maHD);
    dshd.capNhatTongTienHoaDon(maHD, tongTienMoi, dskh);

  }

  // Xem chi tiet
  public void XemChiTiet() {

    int select = 0;
    do {
      System.out.println("\n======XEM CHI TIET======");
      System.out.println("1. Xem tat ca chi tiet hoa don ");
      System.out.println("2. Xem chi tiet hoa don cua 1 hoa don ");
      System.out.println("3. Thoat");
      System.out.println("Lua chon: ");
      select = Integer.parseInt(sc.nextLine());

      switch (select) {
        case 1:
          dscthd.xemTatCaChiTiet();
          break;

        case 2:
          System.out.println("Nhap ma hoa don muon xem: ");
          String maHD = sc.nextLine();
          if (dshd.checkMaHoaDon(maHD) == false) {// khong tim thay ma hoa don
            do {
              System.out.println("Khong tim thay ma hoa don, vui long nhap lai: ");
              maHD = sc.nextLine();
            } while (dshd.checkMaHoaDon(maHD) == false);
          }
          dscthd.xemChiTiet1HoaDon(dssp, maHD);
          break;

        case 3:
          break;

        default:
          System.out.println("Lua chon khong hop le ");
      }
    } while (select != 3);
  }

  // Sua chi tiet
  public void SuaChiTiet() {
    dscthd.xemTatCaChiTiet();
    System.out.println("\n======SUA CHI TIET======");
    System.out.println("Nhap ma hoa don muon sua chi tiet: ");
    String maHD = sc.nextLine();
    if (dshd.checkMaHoaDon(maHD) == false) {// khong tim thay ma hoa don
      do {
        System.out.println("Khong tim thay ma hoa don, vui long nhap lai: ");
        maHD = sc.nextLine();
      } while (dshd.checkMaHoaDon(maHD) == false);
    }
    double tongTienMoi = dscthd.suaChiTiet(maHD, dssp);
    dshd.capNhatTongTienHoaDon(maHD, tongTienMoi, dskh);
  }

  // Xoa chi tiet
  public void XoaChiTiet() {
    dscthd.xemTatCaChiTiet();
    System.out.println("\n======XOA CHI TIET======");
    System.out.println("Nhap ma hoa don muon xoa chi tiet: ");
    String maHD = sc.nextLine();
    double tongTienMoi = dscthd.xoa1ChiTiet(maHD, dssp);
    dshd.capNhatTongTienHoaDon(maHD, tongTienMoi, dskh);
  }

  // 2. QUẢN LÝ SẢN PHẨM.
  public void Menu_SanPham() {
    int select = 0;
    do {
      dssp.Menu();
      select = Integer.parseInt(sc.nextLine());
      switch (select) {
        case 1:
          dssp.NhapSP_KeyBoard();
          break;
        case 2:
          dssp.xoa1Sp();
          break;
        case 3:
          dssp.XuatSP();
          break;
        case 4:
          dssp.Them1Sp();
          break;
        case 5:
          if (dssp != null) {
            System.out.println("doc file khong thanh cong!");
            break;
          }
          dssp.nhapTuFile();
        default:
          break;
      }

    } while (select != 6);
  }

  // 3. NHÂN VIÊN & KHÁCH HÀNG

  /// Menu Nha Vien.
  public void Menu_NV() {
    int choice = 0;
    do {
      dsnv.Menu();
      choice = Integer.parseInt(sc.nextLine());

      switch (choice) {
        case 1:
          dsnv.them();
          break;

        case 2:
          dsnv.sua();
          break;

        case 3:
          dsnv.xoa();
          break;

        case 4:
          dsnv.hienthiTatCaThongTin();
          break;

        case 5:
          if (dsnv != null) {
            System.out.println("doc File khong thanh cong vi danh sach != null!");
            break;
          }

        default:
          System.out.println("Lua chon khong hop le !");

      }
    } while (choice != 6);

  }

  /// Menu_KH();
  public void Menu_KH() {
    int choice = 0;
    do {
      dskh.Menu();
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1:
          dskh.them();
          break;

        case 2:
          dskh.sua();
          break;

        case 3:
          dskh.xoa();
          break;

        case 4:
          dskh.hienthiTatCaThongTin();
          break;

        case 5:
          dskh.docFile();

        case 6:
          break;

        default:
          System.out.println("Lua chon khong hop le !");

      }
    } while (choice != 6);
  }

  // 4.QUẢN LÝ NHÀ CUNG CẤP & PHIẾU NHẬP

  public void Menu_Phieu_Nhap() {
    int select = 0;
    do {
      System.out.println("====== QUAN LY PHIEU NHAP SAN PHAM ======");
      System.out.println("1. Quan ly phieu nhap ");
      System.out.println("2. Quan ly chi tiet phieu nhap");
      System.out.println("3. Thoat");
      System.out.println("Lua chon: ");
      select = Integer.parseInt(sc.nextLine());

      switch (select) {
        case 1:
          Menu_PN();
          break;

        case 2:
          Menu_CTPN();
          break;

        case 3:
          break;

        default:
          System.out.println("Lua chon khong hop le ");
      }
    } while (select != 3);
  }

  // 1 . Menu Phieu Nhap
  public void Menu_PN() {
    int select = 0;
    do {
      dspn.Menu();
      select = Integer.parseInt(sc.nextLine());
      switch (select) {
        case 1:
          System.out.print("Nhap ma phieu nhap:");
          String maPN = sc.nextLine();
          Double tongtien = dsctpn.them(maPN,dssp);
          dspn.them(maPN, tongtien);
          break;

        case 2:
          dspn.xoa();

          break;

        case 3:
          System.out.println("chua sau sua");
          break;

        case 4:
          dspn.nhapVaoSanPham(dsctpn, dssp);

          break;
        case 5:
          dspn.xuat();

          break;

        default:
          System.out.println("Lua chon khong hop le ");
      }
    } while (select != 6);

  }

  /// 2. Menu chi tiet phieu nhap
  public void Menu_CTPN() {
    int select = 0;
    do {
      dsctpn.Menu();
      select = Integer.parseInt(sc.nextLine());
      switch (select) {
        case 1:
          System.out.print("Nhap  ma phieu nhap can them ctpn:");
          String maPN = sc.nextLine();
          dsctpn.them(maPN,dssp);
          break;

        case 2:
          dsctpn.xoa(dssp);

          break;

        case 3:
          dsctpn.xuat();
          break;
        case 4:
          dsctpn.sua();
          break;
        default:
          System.out.println("Lua chon khong hop le ");
      }
    } while (select != 5);

  }

  // 5.THỐNG KÊ
  public void Menu_Thong_Ke() {
    int choice = 0;
    do {
      System.out.println("\n====== MENU THONG KE ======");
      System.out.println("1. Thong ke tong doanh thu ");
      System.out.println("2. Thong ke khach hang");
      System.out.println("3. Thoat");
      System.out.println("Lua chon: ");
      choice = Integer.parseInt(sc.nextLine());

      switch (choice) {

        case 1:
          dscthd.thongKeTongDoanhThu(dssp);
          break;

        case 2:
          dshd.thongKeKhachHang(dskh);
          break;

        case 3:
          break;

        default:
          System.out.println("Lua chon khong hop le ");

      }

    } while (choice != 3);
  }

  // 6.TÌM KIẾM NÂNG CAO
  public void Menu_Tim_Kiem() {

    int select = 0;
    do {
      System.out.println("\n====== TIM KIEM NANG CAO ======");
      System.out.println("1. Tim kiem & thong ke doanh thu theo quy ");
      System.out.println("2. Tim kiem & thong ke doanh thu theo thang");
      System.out.println("3. Thoat");
      System.out.println("Lua chon: ");

      select = Integer.parseInt(sc.nextLine());

      switch (select) {
        case 1:
          dshd.thongKeTheoQuy();
          break;

        case 2:
          dscthd.thongKeSoLuong_DoanhThu(dshd);
          break;

        case 3:
          break;

        default:
          System.out.println("Lua chon khong hop le");
      }
    } while (select != 3);

  }

  public void Menu_Luu_File() {
    dssp.ghiVaoFile();
    dsnv.ghiFile();
    dskh.ghiFile();
    dscthd.ghiVaoFile();
    dshd.ghiVaoFile();
    dsncc.ghiFile();
    dspn.ghiFile();
    dsctpn.ghiFile();
  }

  // END
}
