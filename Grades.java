import java.util.Scanner;
public class Grades {
    public int num;
    public int sum;

    public Grades(int num){
        this.num = num;
        this.sum = 0;
    }
    public void addMarks(int marks) {
        sum += marks;
    }
    public int calcAverage(){
        if (num == 0) {
            return 0;
        }else{
        return sum/num;
        }
    }
    public char displayGrade(){
        int average = calcAverage();
        if(average>70&&average<100){
            return 'A';
        }else if(average>=60){
            return 'B';
        }
        else if(average>=50){
            return 'C';
        }
        else if(average>=40){
            return 'D';
        }else {
            return 'F';
        }
    }
    public String displayComment() {
        char grade = displayGrade();
        switch (grade) {
            case 'A':
                return "Excellent performance";
            case 'B':
                return "Good job";
            case 'C':
                return "Fair,need improvement";
            case 'D':
                return "Poor work harder";
            case 'F':
                return "Failed";
            default:
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of units:");
        int num=in.nextInt();
        if(num<5){
            System.out.println("You can enter marks for at least five units.");
        }else{
        Grades grades=new Grades(num);
            for (int i = 0; i < num; i++) {
                System.out.println("Enter marks " + (i + 1) + ": ");
                int marks = in.nextInt();
                grades.addMarks(marks);
            }
            System.out.println("Your average is:" + grades.calcAverage());
            System.out.println("Your grade is:" + grades.displayGrade());
            System.out.println("Your comment is:" + grades.displayComment());
        }
    }
}
