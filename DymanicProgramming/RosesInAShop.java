package DymanicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class RosesInAShop {
    private static int maxLenContiguousSubArrayRemovingOneElement(int arr[], int n) {
        int max_so_far = 1;
        int max_len = 1;
        int[] fwd = new int[n+1];
        int[] bwd = new int[n+1];

        fwd[0] = 1; bwd[n-1] = 1;

        //Checking max len from left to right
        for(int i=1; i<n; i++) {
            if(arr[i-1] < arr[i])
                max_so_far++;
            else
                max_so_far = 1;
            
            // max_len = Math.max(max_len, max_so_far);
            fwd[i] = max_so_far;
        }

        max_so_far = 1;

        //Checking max len from right to left
        for(int i=n-2; i>=0; i--) {
            if(arr[i+1] > arr[i])
                max_so_far++;
            else
                max_so_far = 1;
            max_len = Math.max(max_len, max_so_far);
            bwd[i] = max_so_far;
        }

        int ans = max_len;

        //Checking max len if an integer is removed
        for(int i=1; i<=n-2; i++) {
            if(arr[i-1] < arr[i+1])
                ans = Math.max(ans, fwd[i-1] + bwd[i+1]);
        }

        return ans;
    }

    private static void solve(FastScanner fs) {
        // add code
        int n = fs.nextInt();
        int arr[] = fs.readIntArray(n);

        System.out.println(maxLenContiguousSubArrayRemovingOneElement(arr, n));
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        solve(fs);
    }
 
    static class FastScanner {
        BufferedReader br = null;
        StringTokenizer st;
        
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();;
            }
            return str;
        }
 
        long[] readLongArray(int n) {
            long[] arr = new long[n];
            for(int i=0; i<n; i++)
                arr[i] = nextLong();
            return arr;
        } 

        int[] readIntArray(int n) {
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = nextInt();
            return arr;
        }
    }
}
