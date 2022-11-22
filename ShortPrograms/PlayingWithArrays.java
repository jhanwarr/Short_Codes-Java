/*
 * Finding the SADDLE POINT for the matrix;
 * A saddle point is an element of in the matrix which is the minimum element in its row
 * and the maximum element in its column. The saddle point of a matrix is always unique.
 * 
 * Input :  4 5 6
 *          7 8 9
 *          5 1 3
 *  
 *  Saddle point = 7 
 *  (since 7 is the smallest element in row 2 and largest element of column 1)
 */

import java.util.*;
public class PlayingWithArrays
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the order of the matrix : ");
        int n = sc.nextInt();
        int A[][] = new int[n][n];

        System.out.println();

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print("Enter Element at ["+(i+1)+"]["+(j+1)+"] : ");
                A[i][j]=sc.nextInt();
            }
        }
        
        sc.close();

        System.out.println("\f The Original Matrix is");

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.printf(" %4d", A[i][j]);
            }

            System.out.println();
        }

        int max, min, x; 
        boolean check = false;

        //Finding the minimum element of a row 
        
        outer:
        for(int i = 0; i<n; i++)
        {
            min = A[i][0]; 
            // Initializing min with first element of the 'i'th row
            
            x = 0;

            for(int j = 0; j<n; j++)
            {
                if(A[i][j] <= min)
                {
                    min = A[i][j];
                    x = j; 
                    // Saving the column position of the minimum element of the row
                }
            }

            
            //Finding the maximum element in the column corresponding to the minimum element of row

            max = A[0][x]; 
            // Initializing max with first element of 'x'th column
            
            for(int k = 0; k<n; k++)
            {
                if(A[k][x] > max)
                    max = A[k][x];
            }

            /* 
             * If the minimum of a row is same as maximum of the corresponding column, 
             * then we have that element as the Saddle point 
             */
            
            if(max == min)
            {
                System.out.println("\nSaddle point is "+max+", located at ("+(i+1)+", "+(x+1)+").");
                check = true;
                break outer;
            }
        }

        if(!check)
        {
            System.out.println("\nNo saddle point found in the matrix.");
        }
    }
}