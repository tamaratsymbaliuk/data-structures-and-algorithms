public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGameII test = new JumpGameII();
        int result = test.jump(nums);
        System.out.println(result);
    }
    public int jump(int[] nums) {

        int jumps = 0;

        // Current 'window' of positions.
        int currentLeft = 0;
        int currentRight = 0;

        // Current 'horizon' that we can reach from the current 'window'
        int currentFarthest = 0;

        // Iterate until currentFarthest is >= nums.length - 1
        // i.e. until the last index is within the horizon
        while (currentFarthest < nums.length - 1) { // nums.length - 1 is the last element, so if we reached it, no need to itreate again
            // Compute what's the visible 'horizon', i.e. what's the farthest
            // position we can reach from the current 'window' of positions.
            for (int i = currentLeft; i <= currentRight; i++) {
                currentFarthest = Math.max(currentFarthest, i + nums[i]);
            }
            // our window was [currentLeft -  currentRight]
            // in the next iteration, we will check how far we can get from [currentRight + 1 - currentFarthest]
            currentLeft = currentRight + 1;
            currentRight = currentFarthest;

            jumps++;
        }

        return jumps;
    }

}
