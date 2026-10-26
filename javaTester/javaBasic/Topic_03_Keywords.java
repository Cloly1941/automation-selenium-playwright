package javaBasic;

import javaKeywords.Computer;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Topic_03_Keywords extends Computer {
    // protected
    // Topic_03_Keywords là con của Computer
    public void showMainName () {
        System.out.println(mainName);

        // public
        System.out.println(lcdName);
    }
}

