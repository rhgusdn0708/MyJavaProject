package Student;

public class Student {
    private String studentId;
    private String name;
    private String major;
    private int grade;

    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        setGrade(grade); // grade 체크 포함
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            System.out.println("학년은 1~4 사이여야 합니다.");
        }
    }

    public void printInfo() {
        System.out.println(name + " / " + major + " / " + grade + "학년");
    }

    public static void main(String[] args) {
        Student student = new Student("20250001", "김민수", "컴퓨터공학", 2);
        student.printInfo();
        student.setGrade(5); // 잘못된 입력 테스트
        student.printInfo();
    }
}