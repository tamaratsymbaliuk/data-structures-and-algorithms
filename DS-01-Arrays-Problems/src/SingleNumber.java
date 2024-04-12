public class SingleNumber {


        public int singleNumber(int[] nums) {
            int a = 0;
            for (int i: nums){
                a = a^i;
            }
            return a;
        }

    public static void main(String[] args) {
        int[] numbers = {4,1,2,1,2};
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(numbers));


    }
    }

