public class Contiguous_Array {
        public int findMaxLength(int[] nums) {

   /*[1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1]
  brute force algorithm
   ones = 11
   zeroes = 3
        if ones == zeroes
        asnwer = max(answer, ones+zeroes);
        */
            int n = nums.length;
            int answer = 0;
            int [] prefix_balance = new int[n];
            int balance = 0;

            for (int i = 0; i < n; i++){
                if (nums[i] == 0) balance--;
                else balance++;

                prefix_balance[i] = balance;

                /*
                [1,1,1,1,1,1,0,0,0,1] - array
                [1,2,3,4,5,6,5,4,3,4] - prefix balance

                [1,1,1,1].     the very first position of 4
                [1,1,1,1,1,1,0,0,] second position of 4

                ________________ if we subtract we have [1,1,0,0]

                prefix_balance array can contain numbers from -n to n
                int[] array has values from -100 to +100
                int[] information_about_value[] should have indices from -100 to +100
                int[] information_about_value[]  = new int[201]; - indices 0...200 will correspond to values -100 to +100. 2n+1
                 */
            }

            int[] prefix_balance_value_first_seen_at = new int[2 * n + 1];
            for (int i = 0; i < 2 * n + 1; i++){
                prefix_balance_value_first_seen_at[i] = -1; //fill out our array with dummy values, so if it is -1 we never saw that value yet
            }
            for (int i = 0; i < n; i++){ // iterate over prefix_balance array
                int value = prefix_balance[i];
                if (prefix_balance_value_first_seen_at[n + value] == -1){ // if we never saw it yet, we use n + value because -n.._n = values and 0..2n = indices, relationship between values and indices is index = value + n
                    prefix_balance_value_first_seen_at[n + value] = i; //that we record the index
                }
            }
            // n = 10
            // nums                                 = [1,1,1,1,1,1,0,0,0,1] - array
            // prefix balance.                      = [1,2,3,4,5,6,5,4,3,4]
            // indices                                 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17
            //prefix_balance_value_first_seen_at    = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
            //18,19,20
            // -1,-1,-1] 21 2n + 1 = 2*10 +1

            //values                                  -10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0, 1, 2, 3, 4, 5, 6, 7,            8,9,10

// we assign prefix_balance_value_first_seen_at using our existing array
            //     = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,1,2,3,4, 5,-1,-1-1,-1,-1]

            //i=0,1,2,3,4,5,6,7,8,9
            // [1,2,3,4,5,6,5,4,3,4] prefix_balance
            // prefix_balance_value_first_seen_at[prefix_balance[i]]  = 4
            // i = 7
            // [0..7] => prefix_balance[7] = 4
            // [0..3] => prefix_balance[3] = 4
            // [0..7] - [0..3] = [4..7] => balance == 0
            // length of longest contigious subarray woth a balance of 0, which ends at i =
            //i -  prefix_balance_value_first_seen_at[prefix_balance[i]] = 7 - 3 = 4
            // Algorithm: iterate over all i from 0..n-1, and take a max(i - prefix_balance_value_first_seen_at[prefix_balance[i]]) as an answer


            for ( int i = 0; i < n; i++){
                int value = prefix_balance[i];
                int index = n + value;
                if (value == 0){
                    // 0..i -> how many numbers are here ? i + 1
                    answer = Math.max(answer, i + 1);
                }
                answer = Math.max(answer,i - prefix_balance_value_first_seen_at[index]);

            }


            return answer;

        }

}
