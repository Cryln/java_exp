import java.util.Scanner;
import java.util.Vector;

public class StudentList {
    private Vector<Student> students = new Vector<>();
    public void addInList(String id,String passwd,String name,String myClass){
        this.students.add(new Student(id, passwd, name, myClass));
    }
    public void addInList(Student student){
        this.students.add(student);
    }
    public void addManually(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Student's name:");
        String name = sc.next();
        System.out.println("Password:");
        String passwd = sc.next();
        System.out.println("ID:");
        String id = sc.next();
        System.out.println("Class:");
        String myClass = sc.next();
        Student student = new Student(id, passwd, name, myClass);
        this.addInList(student);
        for(Cource c:Database.courceList.getCources()){
            if(c.getCourceType().equals("必修")){
                Database.selectionList.addInList(student, c);
            }
        }
    }
    public Student findById(String id){
        for(Student s:this.students){
            if(s.getId().equals(id)) return s;
        }
        return null;
    }
    public Vector<Student> getStudents() {
        return students;
    }

    // public void setStudents(Vector<Student> students) {
    //     this.students = students;
    // }

}
