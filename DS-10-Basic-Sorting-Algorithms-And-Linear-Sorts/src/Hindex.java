public class Hindex {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        Hindex test = new Hindex();
        int result = test.hIndex(citations);
        System.out.println(result);
    }

    public int hIndex(int[] citations) {
        /* buckets[5] -> # of papers with >= 5 citations
        buckets[4] -> # of papers with >= 4 citations
        etc.

        if buckets[5] >= 5. the h-index is 5
        i.e if (# of papers with >= 5 citations) >= 5.

        if buckets[5] + buckets[4] >= 4, then the h-index is 4
        i.e if (# of papers with >= 4 citations) >= 4

        if buckets[5] + buckets[4] + buckets[3] >= 3, then the h-index is 3
        i.e if (# of papers with >= 3 citations) >= 3 and so on

        */
        int n = citations.length;
        int[] buckets = new int[n + 1]; // indices from 0 to n

        for (int c : citations) {
            if (c > n) {
                // it doesn't matter if a paper has more than n citations, because
                // h-index can't be more than n (the number of papers a researcher produced in total)
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            // count now equals (total number of papers with >= i citations)
            if (count >= i) { // if total number of papers with >= i citations) >= i, then h-index = i.
                return i;
            }
        }
        return 0;

    }
}
