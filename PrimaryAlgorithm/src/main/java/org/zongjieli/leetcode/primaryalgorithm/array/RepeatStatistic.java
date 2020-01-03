package array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName: RepeatStatistic
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/23
 * @Version: 1.0
 **/
public class RepeatStatistic {
    public static int[] repeatStatistic(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        Map<Integer, Integer> map = new HashMap(nums1.length);
        for (int number : nums1) {
            Integer numberObj = map.get(number);
            int numberCount = numberObj == null ? 0 : numberObj;
            if (numberCount == 0) {
                map.put(number, 1);
            } else {
                map.put(number, numberCount + 1);
            }
        }
        List<Integer> numberList = new ArrayList<>(nums2.length);
        for (int number : nums2) {
            Integer numberObj = map.get(number);
            int numberCount = numberObj == null ? 0 : numberObj;
            if (numberCount != 0) {
                numberList.add(number);
                map.put(number, numberCount - 1);
            }
        }
        int[] numberArray = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numberArray[i] = numberList.get(i);
        }
        return numberArray;
    }

    public static void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int standardNumber = nums[leftIndex];
        int nextLeft = leftIndex;
        int nextRight = rightIndex;
        while (leftIndex < rightIndex) {
            while (rightIndex > leftIndex && nums[rightIndex] >= standardNumber) {
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];
            while (leftIndex < rightIndex && nums[leftIndex] <= standardNumber) {
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
            if (rightIndex == leftIndex) {
                nums[rightIndex] = standardNumber;
                quickSort(nums, nextLeft, leftIndex - 1);
                quickSort(nums, rightIndex + 1, nextRight);
            }
        }
    }

    public static int[] repeatStatisticBySort(int[] nums1, int[] nums2) {
        quickSort(nums1, 0, nums1.length);
        quickSort(nums2, 0, nums2.length);
        int i = 0;
        int j = 0;
        int numsIndex = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[numsIndex++] = nums1[i++];
                j++;
            }
        }
        int[] nums = new int[numsIndex];
        for (int k = 0; k < numsIndex; k++) {
            nums[k] = nums1[k];
        }
        return nums;
    }

    public static int[] repeatStatisticSinglePoint(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        return new int[10];
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 5, 1, 2, 2, 9, 16, 22};
        int[] nums2 = new int[]{5, 6, 1, 1, 1, 2, 11, 16};
//        System.out.println(Arrays.toString(repeatStatistic(nums1, nums2)));
//        System.out.println(Arrays.toString(repeatStatisticBySort(nums1, nums2)));
        System.out.println(Arrays.toString(repeatStatisticSinglePoint(nums1, nums2)));
    }
}
