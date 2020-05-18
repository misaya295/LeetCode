package one2thirty.day01;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
。
 */
class Sum {


        public int[] twoSum01(int[] nums, int target)  {


            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {



                        return new int[]{i, j};

                    }

                }


            }

            throw new IllegalArgumentException("没有可以相加的两个数");
    }

    public int[] twoSum02(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {

            int two = target - nums[i];
            if (map.containsKey(two) && map.get(two) != i) {
                return new int[]{i, map.get(two)};
            }


        }
        throw new IllegalArgumentException("没有可以相加的两个数");

    }


    public int[] twoSum03(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            int two = target - nums[i];
            if (map.containsKey(two)) {
                return new int[]{map.get(two), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有可以相加的两个数");


    }










    public static void main(String[] args)  {

        int nums[] = new int[]{1,3,4,5,6};


        Sum sum= new Sum();
//        nums= sum.twoSum01(nums, 9);
//        nums= sum.twoSum02(nums, 9);
        nums= sum.twoSum03(nums, 9);

        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k]+" ");
        }






    }


}
