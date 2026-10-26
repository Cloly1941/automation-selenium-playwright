package javaKeywords;

public class Dell {
    static void main() {
        Computer com = new Computer();

        // Computer - Lớp/ Class
        // com - instance (đối tượng/ biến đại diện cho lớp)

        // private: Không thể truy cập
//        com.ramName = "";
//        com.touchPc();

        // default: Có thể truy cập vì cùng package javaKeywords (biến/ hàm)
        com.ssd = "";

        // public
        com.lcdName = "";

        // biến static
        Computer.cityName = "";

        // final: không thể gán lại
//        com.addressName = "123";
    }
}
