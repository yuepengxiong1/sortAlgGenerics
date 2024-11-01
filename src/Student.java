public class Student implements Comparable<Student> {

    private String name;
    private float grade;

    public Student(float grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public float getGrade(){
        return grade;
    }

    public void setGrade(float grade){
        this.grade = grade;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Student stu){
        return (int)(this.grade - stu.grade);
    }

    @Override
    public String toString(){
        return this.name + ": " + this.grade;
    }
}
