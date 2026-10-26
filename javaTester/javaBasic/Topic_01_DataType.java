package javaBasic;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Topic_01_DataType {
    // Nguyên Thủy  (Primitive Type)
    // Number
    // Nguyên: ko có thập phân
    // byte/ short/ int / long
    byte bNumber = 100;
    short sNumber =1000;
    int iNumber = 10000;
    long lNumber = 100000;

    // Thực: có thập phân
    // float/ double
    float fNumber = 35.5f;
    double dNumber = 26.8d;

    // Boolean
    // boolean
    boolean status = true;

    // Character
    // char
    char c = 'B';

    // Tham chiếu (Reference Type)
    // String/ Array/ ArrayList/ Class/..
    String studentAddress = "123 Tran Hung Dao";

    // Array
    String[] students = {"Nguyen Du", "Nguyen Nam"};
    int[] studentPhong = {90, 10};

    // Array List
    List<String> studentAccount  = new ArrayList<>();

    FirefoxDriver firefoxDriver = new FirefoxDriver();

    // Khai báo biến
    // 1 - Access Modifỉer: public private protected default
    // 2 - Data Type
    // 3 - Variable Name : lower Camel Case
    // 4 - Variable Value
    // = gán dữ liệu cho biến

    public String studentName = "Nguyen Thanh Nam";
}
