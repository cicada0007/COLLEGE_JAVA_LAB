import java.util.Scanner;

public class Crc {

    void div(int a[], int k) {
        int gp[] = {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
        for (int i = 0; i < k; i++) {
            if (a[i] == gp[0]) {
                for (int j = i; j < 17 + i; j++) {
                    a[j] ^= gp[j - i];
                }
            }
        }
    }

    public static void main(String args[]) {
        int a[] = new int[100];
        int len, k;
        Crc ob = new Crc();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Data Frame:");
        len = sc.nextInt();
        int flag = 0;

        System.out.println("Enter the Message:");
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < 16; i++) {
            a[len++] = 0;
        }

        k = len - 16;
        int b[] = a.clone();

        ob.div(a, k);

        for (int i = 0; i < len; i++) {
            a[i] ^= b[i];
        }

        System.out.println("Data to be transmitted:");
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nEnter the Received Data:");
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }

        ob.div(a, k);

        for (int i = 0; i < len; i++) {
            if (a[i] != 0) {
                flag = 1;
                break;
            }
        }

        System.out.println(flag == 1 ? "Error in data" : "No error");
    }
}
