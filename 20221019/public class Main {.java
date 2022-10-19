import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        
        while(true){

            System.out.println("숫자를 입력하세요.");

            // 숫자를 입력받기 
            int number;
            Scanner scan = new Scanner(System.in);
            number = scan.nextInt();

            int total = 0;
            while(number > 0){

                total += number % 10;

                number /= 10;
            }
        
        System.out.println("입력된 수의 각 자릿수의 합은?" + total);    

        System.out.println();

        }
    }
}


// 2+ 123%10 나머지 .=3

// 5

// 123  / 10 
// number 12


//2459  // 245 //24 //2

//     int total = 0;
//     while(number > 0){
//     total += number % 10;
//     number /= 10;



// total += number % 10
// total = total + (number % 10)
//0+9  // 5+9  // 14+4  //18+2
// 9   // 14   // 18    //20

