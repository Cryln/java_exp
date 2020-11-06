import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import static java.lang.Double.POSITIVE_INFINITY;

public class Cource {
    private String courceId;
    private String courceName;
    private String courceType;
    private double capacity = 0;
    // private Vector<Teacher> teachers;
    // private Vector<Student> students;
    

    public Cource(String courceId,String courceName,String courceType,double capacity){
        this.setCourceId(courceId);
        this.setCourceName(courceName);
        this.setCourceType(courceType);
        if(courceType.equals("必修")){
            this.setCapacity(POSITIVE_INFINITY);
        }
        else this.setCapacity(capacity);
        // this.teachers = new Vector<Teacher>();
        // this.students = new Vector<Student>();
    }

    
    // public Vector<Teacher> gTeachers(){
    //     return this.teachers;
    // }
    // public Vector<Student> gStudents(){
    //     return this.students;
    // }
    public String getCourceId(){
        return this.courceId;
    }
    public void setCourceId(String courceId){
        this.courceId = courceId;
    }
    public String getCourceType(){
        return this.courceType;
    }
    public void setCourceType(String courceType){
        this.courceType = courceType;
    }
    public String getCourceName(){
        return this.courceName;
    }
    public void setCourceName(String courceName){
        this.courceName = courceName;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
// class IndexDESC implements Comparator<Vector<Cource>>{
//     public int compare(Vector<Cource> a,Vector<Cource> b){
//         if(a.size()<b.size()){
//             return -1;
//         }else if(a.size()==b.size()){
//             return 0;
//         }else{
//             return 1;
//         }
//     }
// }
