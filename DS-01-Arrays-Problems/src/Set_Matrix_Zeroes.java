import java.util.Arrays;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        boolean isRow0=false, isCol0=false;

        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                isRow0=true;
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                isCol0=true;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }

        if(isRow0){
            for(int j=0;j<n;j++)
                matrix[0][j]=0;
        }

        if(isCol0){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }

    }

    public static void main(String[] args) {
        Set_Matrix_Zeroes test = new Set_Matrix_Zeroes();
        int[][] nums = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        test.setZeroes(nums);


        // Loop through each row of the array
        for (int i = 0; i < nums.length; i++) {
            // Loop through each column of the current row
            for (int j = 0; j < nums[i].length; j++) {
                // Print the element at the current row and column
                System.out.print(nums[i][j] + " ");
            }
            // After finishing each row, print a newline to start a new line for the next row
            System.out.println();
        }

    }
}
