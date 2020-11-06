import java.util.Scanner;
import java.util.Vector;
import static java.lang.Double.POSITIVE_INFINITY;

public class CourceList {
    private Vector<Cource> cources = new Vector<>();
    public void addInList(String courceId,String courceName,String courceType,double capacity){
        this.cources.add(new Cource(courceId, courceName, courceType, capacity));
    }
    public void addInList(Cource cource){
        this.cources.add(cource);
    }

    public boolean addManually(){
        Scanner sc = new Scanner(System.in);
        String courceId=null;
        for(int i=1;i<2;i++){
            System.out.println("courceId:("+"当前课程总数"+this.cources.size()+")");
            courceId = sc.next();
            for(Cource c:cources){
                if(courceId.equals(c.getCourceId())){
                    i = 0;
                    System.out.println("courceId已经存在，请重新输入");
                    break;
                }
            }
        }
        System.out.println("courceName:");
        String courceName = sc.next();
        System.out.println("courceType:");
        String courceType = sc.next();
        double capacity = POSITIVE_INFINITY;
        if(courceType.equals("选修")){
            System.out.println("选修课人数上限:");
            capacity = sc.nextDouble();
        }
        
        Cource cource = new Cource(courceId, courceName, courceType, capacity);
        this.addInList(cource);
        if(courceType.equals("必修"))
        {
            for(Student s:Database.studentList.getStudents()){
            Database.selectionList.addInList(s, cource);
            }
        }
        System.out.println("任课老师id:(多名老师用空格隔开)");
        String teacherId = sc.next();
        String[] tchr = teacherId.split(" ");
        for(String s:tchr){
            Teacher teacher = Database.teacherList.findById(s);
            if(teacher != null){
                Database.teachingList.addInList(teacher, cource);
            }
            else{
                System.out.println(s+"未找到");
            }
        }
        

        return true;
    }
    Cource findById(String courceId){
        for(Cource c:this.cources){
            if(c.getCourceId().equals(courceId)) return c;
        }
        return null;
    }

    public Vector<Cource> getCources() {
        return cources;
    }

    // public void setCources(Vector<Cource> cources) {
    //     this.cources = cources;
    // }
}
