import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1216{
    static char[][] arr;
    static final int L = 100;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int T = Integer.parseInt(br.readLine());
            arr = new char[L][L];

            for(int i = 0; i < L; i++){
                String str = br.readLine();
                for(int j = 0; j < L; j++){
                    arr[i][j] = str.charAt(j);
                }
            }
            for(int i = L; i > 0; i--){
                if(solve(i)){
                    System.out.println("#"+tc+" "+i);
                    break;
                }
            }
        }
    }
    
    private static boolean solve(int l){
        for(int i = 0; i < L; i++){
            for(int j = 0; j < (L-l); j++){
                if(solveRow(i, j, l) || solveCol(j, i, l)){
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean solveRow(int i, int j, int l){
        String temp = "";
        int count = 0;

        while(count < l){
            temp += arr[i][j+count];
            count++;
        }

        StringBuffer bf = new StringBuffer(temp);
        String reverse = bf.reverse().toString();

        if(temp.equals(reverse)){
            return true;
        }
        return false;
    }

    private static boolean solveCol(int i, int j, int l){
        String temp = "";
        int count = 0;

        while(count < 1){
            temp += arr[i+count][j];
            count++;
        }

        StringBuffer bf = new StringBuffer(temp);
        String reverse = bf.reverse().toString();

        if(temp.equals(reverse)){
            return true;
        }
        return false;
    }
}