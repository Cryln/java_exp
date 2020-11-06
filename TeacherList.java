import java.util.Scanner;
import java.util.Vector;

public class TeacherList {
    private Vector<Teacher> teachers = new Vector<>();
    public void addInList(String id, String passwd, String name, String level){
        this.teachers.add(new Teacher(id, passwd, name, level));
    }
    public void addInList(Teacher teacher){
        this.teachers.add(teacher);
    }
    public void addManually(){
        Scanner sc = new Scanner(System.in);
        System.out.println("teacher's name:");
        String name = sc.next();
        System.out.println("password:");
        String passwd = sc.next();
        System.out.println("work ID:");
        String id = sc.next();
        System.out.println("level:");
        String level = sc.next();
        addInList(id, passwd, name, level);
    }
    public Teacher findById(String id){
        for(Teacher t:this.teachers){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }
    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    // public void setTeachers(Vector<Teacher> teachers) {
    //     this.teachers = teachers;
    // }
}
