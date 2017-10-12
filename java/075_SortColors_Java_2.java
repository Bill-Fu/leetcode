class Solution {
    public void sortColors(int[] nums) {
        int head0 = 0, head1 = 0, head2 = 0;
        for (int index = 0; index < nums.length; index++) {
            switch (nums[index]) {
                case 0: nums[head2] = 2;
                        nums[head1] = 1;
                        nums[head0] = 0;
                        head0++;
                        head1++;
                        head2++;
                        break;
                case 1: nums[head2] = 2;
                        nums[head1] = 1;
                        head1++;
                        head2++;
                        break;
                case 2: nums[head2] = 2;
                        head2++;
                        break;
            }
        }
    }
}
