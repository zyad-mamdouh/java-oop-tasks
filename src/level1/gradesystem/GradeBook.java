package level1.gradesystem;

import java.util.*;

public class GradeBook {
    private String className;
    private List<Student> students=new ArrayList<>();
    GradeBook(String className){
        if(className==null || className.isBlank()){
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.className=className;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(String studentId){
        students.remove(studentId);
    }
    public String findStudent(String studentId){
        for (Student s:students){
            if(Objects.equals(s.getStudentId(), studentId)){
                return s.getName()+ ": " + s.getStudentId();
            }
        }
        return "not found";
    }
    public double getClassAverage(){
        double sum=0;
        int count=0;
        for (Student e :students){
            sum+=e.calculateAverage();
            count++;
        }
        return sum/count;
}
    public  String getTopStudents(int count){
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        orderedStudent();
        String result = "";
        for (int i =0 ; i<count ;i++){
            result+=students.get(i).getName() +": "+ students.get(i).getName()+ "\n";
        }



        return result;
    }

    public void orderedStudent(){
        Collections.sort(students,new Comparator<Student>(){

            @Override
            public int compare(Student s1, Student s2) {
                if(s1.calculateAverage() < s2.calculateAverage()) return 1;
                if(s1.calculateAverage() > s2.calculateAverage()) return -1;
                return 0;
            }
        });
    }


    public void displayAllStudents() {
        for (Student s:students){
            s.getStudentInfo();
        }

    }
}
