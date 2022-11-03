import java.util.*;
public class Student_information{
    String usn;
    String Name;
    String branch;
    int phone;
    void insertRecord (String reg,String name,String b,int p){
        usn=reg;
        Name=name ;
        branch=b;
        phone =p;
    }

    void displyRecord(){
        System.out.println(usn+"  "+Name+"  "+branch+"  "+phone)
        }
    
    public static void main(String[] args) {
        student s[]=new student[100];
        Scanner sc=new Scanner(System.in())
        System.out.println("ENTER THE STUDENT_NAME");
        int n=sc.nextInt();
        
        for(int i=0;i<n;i++){
            s[i]= new student();
        }

        for(int j=0;j<n;j++){
            System.out.println("ENTER THE USN,NAME AND BRANCH")
            String usn=sc.next();
            String Name=sc.next();
            String branch=SC.next();
            int phone=sc.nextInt();
            s[j].insertRecord(usn,Name,branch,phone)
        }
        
        for (int m=0;m<n;m++){
            s[m].displayRecord();
        }
    }
}