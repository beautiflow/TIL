import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S_1208{
    public static void main(String[] args){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int tc = 1; tc <= 10; tc++){

        int dump = Integer.parseInt(br.readLine());

        int[] box = new int[100];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < box.length; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box);

        for(int i = 0; i < dump; i++){
            box[0]++;
            box[99]--;
            Arrays.sort(box);
        }
        int gap = box[99] - box[0];

        System.out.println("#"+tc+" "+gap);
     }
    }

}