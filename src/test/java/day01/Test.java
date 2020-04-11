package day01;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        int nums[] = new int[]{1,3,4,5,6};

        int target = 9;


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int two = target - nums[i];

            System.out.println(map.containsKey(two) && map.get(two) != i);

//            System.out.println(map.get(two));


        }

    }




}
