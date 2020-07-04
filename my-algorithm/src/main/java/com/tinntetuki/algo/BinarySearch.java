package com.tinntetuki.algo;

/**
 * @Auther: tinntetuki
 * @Date: 2020/5/20 23:53
 * @Description: 算法-二分查找
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    static int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     * @param nums
     * @param target
     * @return
     */
    static int left_bound(int[] nums, int target){
        if (checkLength(nums)) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    static int left_bound2(int[] nums, int target){
        if (checkLength(nums)) return -1;

        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    static int right_bound(int[] nums, int target){
        if (checkLength(nums)) return -1;

        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    private static boolean checkLength(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6}, 5));
        System.out.println(left_bound2(new int[]{1,2,3,4,4,4,4,4,5,6}, 4));
        System.out.println(right_bound(new int[]{1,2,3,4,4,4,4,4,5,6}, 4));
    }
}
