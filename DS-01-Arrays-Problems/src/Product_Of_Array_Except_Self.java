import java.util.Arrays;

public class Product_Of_Array_Except_Self {
        public int[] productExceptSelf(int[] nums) {

            int n = nums.length;
            System.out.println(n);
            int[] pref_mul = new int[n];//O(n) space
            System.out.println("line 8 " + Arrays.toString(pref_mul));
            int[] suff_mul = new int[n];//O(n) space
            System.out.println("line 10 " + Arrays.toString(suff_mul));

            for (int i = 0; i < n; i++){ //O(n)
                //assigning neutral 1 for multiplication
                pref_mul[i] = 1;
                System.out.println("line 15 " + Arrays.toString(pref_mul));
                suff_mul[i] = 1;
                System.out.println("line 17 " + Arrays.toString(suff_mul));
            }

            pref_mul[0] = nums[0];
            System.out.println("line 21 " + Arrays.toString(pref_mul));
            for (int i = 1; i < n; i++){ //O(n)
                pref_mul[i] = pref_mul[i - 1] * nums[i];
                System.out.println("line 24 " + pref_mul[i]);
            }

            suff_mul[n-1] = nums[n-1];
            System.out.println("line 28 " + Arrays.toString(suff_mul));
            for (int i = n - 2; i >= 0; i--){ //O(n)
                suff_mul[i] = nums[i] * suff_mul[i + 1];
                System.out.println("line 31 " + Arrays.toString(suff_mul));
            }

            int[] result = new int[n]; //O(n) space
            result[0] = suff_mul[1];
            result[n - 1] = pref_mul[n - 2];
            for (int i = 1; i < n - 1; i++){ //O(n)
                result[i] = pref_mul[i - 1] * suff_mul[i + 1];
                System.out.println("line 39 " + result[i]);
            }

            //Time: O(n)
            //Space: O(n)
            return result;


        }

    public static void main(String[] args) {
        int [] nums ={1,2,3,4};
        Product_Of_Array_Except_Self test = new Product_Of_Array_Except_Self();
        System.out.println(Arrays.toString(test.productExceptSelf(nums)));
    }
    }

