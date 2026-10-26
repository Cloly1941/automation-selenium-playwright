package javaKeywords;

public abstract class Computer {
    // **** Access Modifier **** //

    // biến - Variable/ Propertíes
    // public - protected - default - private
    // private : 1 biến/ hàm chỉ có Class hiện tại mới sử dụng được (demo: Dell.java)
    private String ramName = "Kingston 8gb";

    private void touchPc () {}

    // default: Cùng package javaKeywords có thể truy cập (biến/ hàm) (demo: Dell.java)
    String ssd = "EVo";

    // protected: Dùng extends kế thừa class để sử dụng (demo: Topic_03_Keywords.java)
    // Topic_03_Keywords là con của Computer
    protected String mainName = "";

    // public: Dùng mọi nơi
    public String lcdName = "Dell Ultra 2715";



//    static void main() {
//        Computer com = new Computer();
//
//        // private
//        com.ramName = "Samsung 160Gb";
//
//        // public
//        com.lcdName = "";
//    }

    // **** Access Modifier End **** //

    // ** biến - Variable/ Propertíes **

    // 1 - biến non-static: Nếu muốn truy cập vào thì phải thông qua instance/ đối tượng
    // New class lên mới sử dụng được

    // 2 - biến static
    // Truy cập trực tiếp từ tên lớp/ ko cần qua instance
    // Chia sẻ dữ liệu cho tất cả các luồng (Thread)
    static String cityName = "Ho Chi Minh"; // (Demo Dell.java)

    // 3 - biến final
    // Khi không muốn gán lại dữ liệu (Demo Dell.java)
    final String addressName = "";

    // Xét trong phạm vi class
    // 4 - biến toàn cục - global
    // Trong 1 Class thì 1 biến được gọi là toàn cục
    // Khi biến được khai báo ở phạm vi class

    // 5 - biến cục bộ - local
    // Khai báo ở phạm vi trong hàm/ tham số hàm hoặc trong khối lệnh (block)
    public void printRam(String ramName) {
        String hddName = "";

        for (int i = 0 ; i < 10; i++) {
            System.out.println(i);

            if(i > 0) {
                int number = 5;
            }
        }
    }

    // ** hàm - Method/ Function **
    // 1 - hàm non-static
    // Ko có từ khóa gọi là non static

    // 2 - hàm static
    // Gọi ra sử dụng ở phạm vi lớp
    public static void showLCD() {

    }

    // 3 - hàm final
    // Ko thể override - tính abstraction (trừu tượng)
    // Ko cho phép các lớp con viết lại hàm này (Demo Acer.java)
    public static final void showSSD() {}

    // 4 - hàm abstract
    // Bắt buộc các lớp con phải viết lại
    // Chỉ có tên hàm/ tham số của hàm/ kiểu dữ liệu trả về
    // ko được có phần thân
    // 1 lớp abstarct không thể ở trong non abstract
    // ex: public class Computer - non abstract
    //     public abstract class Computer - abstract
    // hàm abstract k được new Computer()
    public abstract void showNetwork();

    // Áp dụng được tính chất trừu tượng
    // Thể hiện qua abstract class và interface
    // Chứa cái hàm abstract

    // ** lớp - Class **
    // Cho phép đơn kế thừa: 1 class chỉ có thể kế thừa 1 class khác
    // 1 - final class
    // ko cho phép bất kì lớp nào kế thừa

    // 2 - abstract class
    // Chứa cả non-abstract method và abstract method

    // 3 - non abstract class
    // Chỉ được chứa non-abstract method thôi

    // interface
    // Chức năng giống abstract class
    // Ko chứa non abstract class giống như abstract class
    // Cho phép đa kế thừa: 1 class có thể chứa n interface

}
