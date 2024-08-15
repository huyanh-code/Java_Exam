public class Student {
    private String name;
    private int age;
    private String className;
    private double averageScore;
    private String gender;

    public Student(String name, int age, String className, double averageScore, String gender) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.averageScore = averageScore;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                ", age= " + age +
                ", className='" + className + '\'' +
                ", averageScore=" + averageScore +
                ", gender='" + gender + '\'' +
                '}';
    }
}
