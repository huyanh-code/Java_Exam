import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Đặng Thị Lan Anh", 20, "C2208G2", 8.0, "female"));
        students.add(new Student("Nguyễn Anh Tuấn", 20, "C2208G1", 7.5, "male"));
        students.add(new Student("Nguyễn Văn Bắc", 21, "C2209l", 7.0, "male"));
        students.add(new Student("Nguyễn Thị Kim Anh", 20, "C2309l", 8.5, "female"));
        students.add(new Student("Tô Văn Đức", 20, "C2108l", 6.0, "male"));

        students.add(new Student("Lê Văn Dữ", 24, "C2208G2", 9.0, "male"));
        students.add(new Student("Nguyễn Văn Dũng", 21, "C2208G1", 7.0, "male"));
        students.add(new Student("Phạm Ánh Dương", 20, "C2209l", 6.5, "female"));
        students.add(new Student("Đỗ Thị Kim Duyên", 20, "C2309l", 8.0, "female"));
        students.add(new Student("Nguyễn Ngọc Thế Cương", 22, "C2108l", 5.0, "male"));

        students.add(new Student("Nguyễn Thanh Hà", 20, "C2208G2", 7.0, "female"));
        students.add(new Student("Nguyễn Lam Giang", 20, "C2208G1", 7.6, "female"));
        students.add(new Student("Nguyễn Hoàng Hiệp", 22, "C2209l", 7.8, "male"));
        students.add(new Student("Nguyễn Việt Hoàng", 20, "C2309l", 6.8, "male"));
        students.add(new Student("Nguyễn Quốc Khánh", 21, "C2108l", 9.2, "male"));

        students.add(new Student("Lê Đỗ Thành Công" , 20, "C2208G2", 6.5, "male"));
        students.add(new Student("Mai Xuân An", 20, "C2208G1", 7.2, "male"));
        students.add(new Student("Nguyễn Văn Lợi", 20, "C2209l", 8.6, "male"));
        students.add(new Student("Trần Lê Dung", 20, "C2309l", 6.5, "female"));
        students.add(new Student("Đặng Thị Dịu", 20, "C2108l", 7.6, "female"));

        students.add(new Student("Lê Ngọc Hảo" , 20, "C2208G2", 8.8, "female"));
        students.add(new Student("Nguyễn Thị Mỹ Hạnh", 20, "C2208G1", 8.5, "female"));
        students.add(new Student("Lê Thái Linh", 20, "C2209l", 7.0, "female"));
        students.add(new Student("Nguyễn Việt Linh", 20, "C2309l", 9.2, "female"));
        students.add(new Student("Đỗ Thị Phượng Loan", 20, "C2108l", 6.8, "female"));

        for(Student student: students){
            System.out.println(student);
        }

        Map<String, Double> averageScoreByClass = calculateAverageScore(students);
        printAverage(averageScoreByClass);

        Map<String, int[]> classGenderCount = new HashMap<>();
        for(Student student: students){
            String className = student.getClassName();
            boolean isMale =  student.getGender().equalsIgnoreCase("male");

            classGenderCount.putIfAbsent(className, new int[2]);

            classGenderCount.get(className)[isMale ? 0 : 1]++;
        }

        System.out.println("\nTỉ lệ nam/nữ theo từng lớp:");
        for(Map.Entry<String, int[]> entry : classGenderCount.entrySet()){
            int maleCount = entry.getValue()[0];
            int femaleCount = entry.getValue()[1];
            int total = maleCount + femaleCount;

            double maleRatio = (double) maleCount / total * 100;
            double femaleRatio = (double) femaleCount / total * 100;

            System.out.printf("Lớp %s: Nam %.2f%% - Nữ %.2f%%%n", entry.getKey(), maleRatio, femaleRatio);
        }
    }
    private static Map<String, Double> calculateAverageScore(List<Student> students){
        Map<String, List<Double>> scoreByClass = new HashMap<>();

        for(Student student: students){
            if(!scoreByClass.containsKey(student.getClassName())){
                scoreByClass.put(student.getClassName(), new ArrayList<>());
            }
            scoreByClass.get(student.getClassName()).add(student.getAverageScore());
        }
        Map<String, Double> averageScores = new HashMap<>();
        for(String className: scoreByClass.keySet()){
            List<Double> scores = scoreByClass.get(className);
            double sum = 0;
            for(double score: scores){
                sum += score;
            }
            double average = sum / scores.size();
            averageScores.put(className, average);
        }
        return averageScores;
    }

    private static void printAverage(Map<String, Double> averageScoreByClass){
        System.out.println("\nĐiểm trung bình theo từng lớp: ");
        for(String className: averageScoreByClass.keySet()){
            System.out.println("Lớp " + className + ": " + averageScoreByClass.get(className));
        }
    }
}