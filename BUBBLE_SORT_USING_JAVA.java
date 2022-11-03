//  BUBBLE_SORT_USING_JAVA

import java.util.*;

public class BUBBLE_SORT_USING_JAVA{
    
    public static void main(String[] args) {
        
        int i,j,temp,limit;
        Scanner sc=new Scanner(System.in());
        System.out.println("ENTER"+limit+"NUMBER");
        
        for(i=0;i<limit;i++){
            array[i]=sc.nextInt();
        }

        for(i=0;i<(limit-1);i++){
            for(j=0;j<(limit-i-1);j++){
                if(array[i]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        System.out.println("THE SORTED ARRAY IS-----");

        for(i=0;i<limit;i++){
            System.out.println(array[i]);
        }
    
    }
}
