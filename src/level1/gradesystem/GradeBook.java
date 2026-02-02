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
        if(student==null){
          throw new IllegalArgumentException("student is null");
        }
        for (Student s:students){
            if(Objects.equals(s.getStudentId(), student.getStudentId())){
                throw new IllegalArgumentException("student is exists ");
            }
        }
        students.add(student);
    }
    public void removeStudent(String studentId){
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Invalid studentId");
        }
      for (int i=0; i<students.size();i++){
          if (Objects.equals(students.get(i).getStudentId(),studentId)){
              students.remove(i);
              return;
          }
      }

        throw new IllegalArgumentException("Student not exists");

    }
    public String findStudent(String studentId){
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Invalid studentId");
        }
        for (Student s:students){
            if(Objects.equals(s.getStudentId(), studentId)){
                return s.getName()+ ": " + s.getStudentId();
            }
        }
        return "not found";
    }

    public double getClassAverage(){
        if(students.isEmpty()){
            return 0;
        }
        double sum=0;

        for (Student e :students){
            sum+=e.calculateAverage();
        }
        return sum/students.size();
}

    public  String getTopStudents(int count){
        if(count>students.size()){
            throw new IllegalArgumentException("Count exceeds number of students");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be positive");
        }

        orderedStudent();

        String result = "";
        for (int i =0 ; i<count ;i++){
            result+=students.get(i).getName() +": "+ students.get(i).calculateAverage()+ "\n";
        }



        return result;
    }
    public String getStudentsByLetterGrade(char letterGrade){
        String result="";
        for(Student s:students){
            if(s.getLetterGrade()==letterGrade){
               result+=s.getName()+ ": "+ s.calculateAverage()+ "\n";
            }
        }
        if (result.isEmpty()) {
            return "No students with grade " + letterGrade;
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
        if (students.isEmpty()){
            System.out.print("No students");
            return;
        }
        for (Student s:students){
         System.out.println(s.getStudentInfo());
        }

    }
}
