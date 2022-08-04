import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerLog {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int num = scan.nextInt();

        System.out.println(name);
        System.out.println(num);

        Logger logger = Logger.getLogger("MyLogger");
        logger.info("Main program started !!");
        logger.log(Level.WARNING, "Data file size too big");

        logger.setLevel(Level.FINE);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINE);
        logger.addHandler(ch);

        logger.fine("Shutdown main program !!");
    }
}
//    실행결과
//            Kim // 키보드 입력
//200 // 키보드 입력
//        Kim
//        200
//        6월 09, 2019 11:08:10 오후 javapart1.ScannerLog main
//        INFO: Main program started !!
//        6월 09, 2019 11:08:10 오후 javapart1.ScannerLog main
//        WARNING: Data file size too big
//        6월 09, 2019 11:08:10 오후 javapart1.ScannerLog main
//        FINE: Shutdown main program !!
