package com.tinntetuki.algo;

/**
 * 算法-二分查找
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target){
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
    int left_bound(int[] nums, int target){
        if (checkLength(nums)) {
            return -1;
        }
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
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target){
        if (checkLength(nums)) {
            return -1;
        }

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

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    private boolean checkLength(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        return false;
    }

}
