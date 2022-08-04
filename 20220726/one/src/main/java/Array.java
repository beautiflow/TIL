import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array {

    public static void main(String[] args){
        // 1. Declare and initialize an array
        System.out.println("# 1. Declare and initialize an array");
        int[] scores = {95, 100, 87, 91};
        scores[2] = 90; // 3번째 요소 (87)를 90으로 변경

        System.out.println(scores);
        for (int i = 0; i < scores.length; i++){
            System.out.println(scores[i]);
        }

        // 2. Arrays method : toString(), asList()
        System.out.println("\n# 2. Arrays method : toString(), asList()");
        String[] cars = {"hyundai", "bmw", "benz", "toyota" };
        List<String> car_list = Arrays.asList(cars);
        System.out.println(car_list);
        System.out.println(car_list.get(1));
        // car_list.add("ford"); error

        //3. Arrays method : sort(array, Comparator), sort(array, int fromindex, int toindex)
        System.out.println("\n# 3. Arrays method : sort(array, Comparator), sort(array,int fromindex, int toindex)");
        Arrays.sort(cars);
        System.out.println(Arrays.asList(cars));

        Arrays.sort(cars, Collections.reverseOrder());
        System.out.println(Arrays.asList(cars));

        Arrays.sort(cars, 0, 2);
        System.out.println(Arrays.asList(cars));

        // 4. Arrays method : copyOf, copyOfRange
        System.out.println("\n# 4. Arrays method : copyOf, copyOfRange");
        String [] cars_copied1 = Arrays.copyOf(cars, cars.length);
        System.out.println(Arrays.asList(cars_copied1));

        String[] cars_copied2 = Arrays.copyOfRange(cars, 0, 2);
        System.out.println(Arrays.asList(cars_copied2));

        // 5. Multiple Array
        System.out.println("\n# 5. Multiple Array");
        int[][][] allScores = {
                {{90, 85, 70, 55, 60}, {96, 88, 81, 91, 75}, {96, 88, 81, 91, 75}, {96, 88, 81, 91, 75}},
                {{91, 82, 73, 54, 65}, {96, 87, 88, 99, 80}, {91, 82, 83, 94, 75}, {96, 87, 88, 99, 70}},
                {{92, 83, 74, 55, 66}, {97, 88, 89, 90, 71}, {92, 83, 84, 95, 76}, {97, 88, 89, 90, 71}}};
        System.out.println(allScores[1][2][0]);


    }


}





//실행결과
//        # 1. Declare and initialize an array
//        [I@6a6824be
//        95
//        100
//        90
//        91
//
//        # 2. Arrays method: toString(), asList()
//        [hyundai, bmw, benz, toyota]
//        bmw
//
//        # 3. Arrays method: sort(array, Comparator), sort(array, int fromindex, int toindex)
//        [benz, bmw, hyundai, toyota]
//        [toyota, hyundai, bmw, benz]
//        [hyundai, toyota, bmw, benz]
//
//        # 4. Arrays method: copyOf, copyOfRange
//        [hyundai, toyota, bmw, benz]
//        [hyundai, toyota]
//
//        # 5. Multiple Array
//        91
