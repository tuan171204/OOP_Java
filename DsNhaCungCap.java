import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class DsNhaCungCap {
    private NhaCungCap dsncc [];
    Scanner sc = new Scanner(System.in);



    public DsNhaCungCap(){
        dsncc = new NhaCungCap[0];
    }
    
    public void them(){
        dsncc = Arrays.copyOf(dsncc, dsncc.length+1);
        dsncc[dsncc.length-1] = new NhaCungCap();
        dsncc[dsncc.length-1].nhap();

    }

    public void xuat(){
        System.out.println("\n====== DANH SACH CAC NHA CUNG CAP ======");
        System.out.println("Ma\t\t" + "Ten\t\t" + "Dia chi\t\t\t" + "So Dien Thoai");
        for ( int i=0; i < dsncc.length; i++){
            System.out.println(dsncc[i].toString2());
        }
    }

    public void sua(){
       xuat();
       System.out.println("\n---- SUA NHA CUNG CAP---- ");
       System.out.println("Nhap ma nha cung cap muon sua thong tin: ");
       String mancc = sc.nextLine();
       for ( int i=0 ; i < dsncc.length; i++){
        if ( dsncc[i].getMaNhaCungCap().equals(mancc)){
            System.out.println("Nhap ma nha cung cap moi: ");
            dsncc[i].setMaNhaCungCap(sc.nextLine());
            System.out.println("Nhap ten nha cung cap moi: ");
            dsncc[i].setTenNhaCungCap(sc.nextLine());
            System.out.println("Nhap dia chi moi cua nha cung cap: ");
            dsncc[i].setDiaChi(sc.nextLine());
            System.out.println("Nhap so dien thoai moi cua nha cung cap: ");
            dsncc[i].setSdt(sc.nextLine());
        }
       }
       System.out.println("Khong tim thay ma nha cung cap");
    }

    public void xoa(){
       xuat();
       System.out.println("\n---- XOA NHA CUNG CAP---- ");
       System.out.println("Nhap ma nha cung cap muon xoa: ");
       String mancc = sc.nextLine();
       for ( int i=0 ; i < dsncc.length; i++){
        if ( dsncc[i].getMaNhaCungCap().equals(mancc)){
            for ( int j = i; j < dsncc.length - 1; j++){
                dsncc[j] = dsncc[j+1];
            }
            dsncc = Arrays.copyOf(dsncc, dsncc.length-1);
            return;
        }
       }
       System.out.println("Khong tim thay ma nha cung cap");


    }

    public void ghiFile(){
        try {
            BufferedWriter writer = new BufferedWriter ( new FileWriter ("test.txt", false));
            for ( int i=0; i< dsncc.length; i++){
                writer.write(dsncc[i].toString());
                writer.newLine();
            }
            writer.close();

        } catch(IOException e){
            System.out.println("Loi ghi vao file");
        }
    }

    public void docFile(){
        
        try {
            dsncc = new NhaCungCap[0];
            BufferedReader reader = new BufferedReader( new FileReader("NhaCC.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                String data[] = line.split(", ");
                dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
                dsncc[dsncc.length -1] = new NhaCungCap( data[0], data[1], data[2], data[3]);
            } reader.close();
        } catch ( IOException e ){
            System.out.println("Loi khi doc file ");
        }
    }
    
    public void Menu(){
        int select = 0;
        do {
            System.out.println("====== QUAN LY NHA CUNG CAP ======");
            System.out.println("1. Them nha cung cap ");
            System.out.println("2. Xem thong tin cac nha cung cap ");
            System.out.println("3. Sua thong tin nha cung cap");
            System.out.println("4. Xoa nha cung cap ");
            System.out.println("5. Ghi vao file ");
            System.out.println("6. Doc tu file ");
            System.out.println("7. Thoat");
            System.out.println("Lua chon: ");
            select = Integer.parseInt(sc.nextLine());

            switch ( select ){
                case 1:
                them();
                break;

                case 2:
                xuat();
                break;

                case 3:
                sua();
                break;

                case 4:
                xoa();
                break;

                case 5:
                ghiFile();
                break;

                case 6:
                docFile();
                break;
                
                case 7:
                break;

                default:
                System.out.println("Lua chon khong hop le ");
            }
        } while (select != 7);
    }
}
