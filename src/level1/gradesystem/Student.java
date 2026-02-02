package level1.gradesystem;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private Map<String,Double> grades=new HashMap<>();

    public Student(String studentId, String name, String email){
        if(studentId==null || studentId.isBlank() ){
            throw new IllegalArgumentException("studentId can't be empty");
        }
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (email == null || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email");
        }
        this.studentId=studentId;
        this.name=name;
        this.email=email;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        if (email == null || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }
    public void setName(String name) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }
    public void setStudentId(String studentId) {
        if(studentId==null || studentId.isBlank() ){
            throw new IllegalArgumentException("studentId can't be empty");
        }
        this.studentId = studentId;
    }

    public void addGrade(String subject , Double grade){
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Invalid subject");
        }
        if (grade == null || grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Invalid grade");
        }

        grades.put(subject,grade);

    }
    public Double getGrade(String subject){
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Invalid subject");
        }

        return grades.get(subject);

    }
    public double calculateAverage(){
        if (grades.isEmpty()){
            return 0;
        }
        double sum=0;
        for(double g :grades.values()){
          sum+=g;
        }
        return sum/grades.size();
    }
    public char getLetterGrade(){
       double e=calculateAverage();
        if (e >= 90) {
            return 'A';
        } else if (e >= 80) {
            return 'B';
        } else if (e >= 70) {
            return 'C';
        } else if (e >= 60) {
            return 'D';
        } else {
            return 'F';
        }

    }


    public String getStudentInfo() {
        return "Student{" +
                "id='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", average=" + calculateAverage() +
                ", grade=" + getLetterGrade() +
                '}';
    }

}
