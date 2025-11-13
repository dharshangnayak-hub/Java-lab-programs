import java.util.Scanner;
class Student
{
    String name,usn;
    int marks[]=new int[10];
    int credits[]=new int[10];
    int n;
    void accept()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student name:");
        name=sc.nextLine();
        System.out.println("Enter student USN:");
        usn=sc.nextLine();
        System.out.println("Enter number of subjects:");
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter marks of subject "+(i+1)+" : ");
            marks[i]=sc.nextInt();
            System.out.println("Enter credits of subject "+(i+1)+" : ");
            credits[i]=sc.nextInt();
        }
    }

    int gp(int marks)
    {
        if(marks>=90)
            return 10;
        else if(marks>=80)
            return 9;
        else if(marks>=70)
            return 8;
        else if(marks>=60)
            return 7;
        else if(marks>=50)
            return 6;
        else if(marks>=40)
            return 5;
        else
            return 0;
    }

    float sgpa()
    {
        int total_credits=0;
        int total_points=0;
        for(int i=0;i<n;i++)
        {
            total_credits+=credits[i];
            total_points+=gp(marks[i])*credits[i];
        }
        return (float)total_points/total_credits;
    }

    void display()
    {
        System.out.println("--Student Details--");
        System.out.println("Student Name: "+name);
        System.out.println("Student USN: "+usn);
        for(int i=0;i<n;i++)
        {
            System.out.println("Subject "+(i+1)+" : Marks = "+marks[i]+", Credits = "+credits[i]);
        }
        System.out.printf("SGPA: %.2f\n",sgpa());
    }
}
public class sgpacalc
{
    public static void main(String args[])
    {
        Student s=new Student();
        s.accept();
        s.display();
    }
}