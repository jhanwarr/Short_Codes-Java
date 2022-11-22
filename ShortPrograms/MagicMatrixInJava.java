import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MagicMatrixInJava
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter the size of the matrix : ");
        int n = Integer.parseInt(br.readLine());
        
        int A[][] = new int[n][n];
        int i,j,k;

        //Initializing every cell of the matrix with 0 
        
        for(i = 0; i<n; i++)
        {
            for(j = 0; j<n; j++)
            {
                A[i][j] = 0;
            }
        }

        //When the size of the matrix is Odd
        
        if(n % 2 != 0)
        {
            i = 0; 
            j = n/2;
            k = 1;
            while(k <= n*n)
            {
                A[i][j] = k++;
                i--; 
                j++; 
                if(i < 0 && j > n-1) // Condition for the top-right corner element
                {
                    i = i+2;
                    j--;
                }
                
                // Wrapping around the row if it goes out of boundary
                if(i < 0) 
                    i = n-1;
                
                // Wrapping around the column if it goes out of boundary
                if(j > n-1) 
                    j = 0;
                
                // Condition when the cell is already filled
                if(A[i][j] > 0)
                {
                    i = i+2;
                    j--;
                }
            }
        }

        //When the size of the matrix is even
        
        else
        {
            k = 1;

            // Filling the matrix with natural numbers from 1 till n*n
            for(i = 0; i<n; i++)
            {
                for(j = 0; j<n; j++)
                {
                    A[i][j] = k++;
                }
            }

            j = n-1;

            for(i = 0; i<n/2; i++)
            {
                // swapping corner elements of primary diagonal
                A[i][i] += A[j][j];
                A[j][j] = A[i][i] - A[j][j];
                A[i][i] = A[i][i] - A[j][j];

                // swapping corner elements of secondary diagonal
                A[i][j] += A[j][i];
                A[j][i] = A[i][j] - A[j][i];
                A[i][j] = A[i][j] - A[j][i];

                j--;
            }
        }

        // Printing the matrix
        
        System.out.println("\nThe Magic Matrix of size "+n+"x"+n+" is:\n");
        
        for(i = 0; i<n; i++)
        {
            for(j=0 ; j<n; j++)
            {
                System.out.printf("%4d", A[i][j]);
            }
            
            System.out.println();
        }
    }
}