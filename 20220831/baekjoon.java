import java.util.Scanner;

class baekjoon {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int money = sc.nextInt();
         int n = sc.nextInt();
         

         int answer = 0;
         for(int i = 0; i < n ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            answer += (a*b); // 복합연산자
         }
         
         if(answer == money){
            System.out.println("Yes");
         }else{
            System.out.println("No");
         }
     }
}