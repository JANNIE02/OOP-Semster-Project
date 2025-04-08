package TermProject;

public class Student {
    public String name;
    public String id;
    public int[] scores;

    public Student(String name, String id, int numSubjects) {
        this.name = name;
        this.id = id;
        this.scores = new int[numSubjects];
    }
}
