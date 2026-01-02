package leetcode.p0033;

public class SearchInRotatedSortedArray {

    // Time: O(log n), Space: O(1)
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;

            // left half sorted
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else { // right half sorted
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    // optional quick sanity test
    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(s.search(new int[]{1}, 0)); // -1
    }
}
