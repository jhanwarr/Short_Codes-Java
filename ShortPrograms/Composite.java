import java.util.Scanner;
class Composite
{
    int arr[][];
    int m; int n;

    Composite(int m, int n)
    {
        this.m = m;
        this.n = n;
        arr = new int[m][n];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length and width of the 2D array : ");
        Composite obj = new Composite(sc.nextInt(), sc.nextInt());
        sc.close();
        
        obj.fill();
        obj.display();
    }
    
    int isComposite(int p)
    {
        for(int i = 2; i<p; i++)
        {
            if(p%i == 0)
                return 1;
        }
        return 0;
    }

    void fill()
    {
        int check = 0, j = 1;

        for(int z = 0; z<n; z++)
        {
            for(int x = 0; x<m; x++)
            {
                for(int i = j+1; check<m*n; i++)
                {
                    if(isComposite(i) == 1)
                    {
                        arr[x][z] = i;
                        j = i;
                        check++;
                        break;
                    }
                }
            }
        }
    }
    
    void display()
    {
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.printf("%4d", arr[i][j]);
            }
            
            System.out.println();
        }
    }
}
