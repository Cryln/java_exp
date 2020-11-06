// import java.util.Scanner;

public class Student extends User {
    private String name;
    private String myClass;
    public Student(String id,String passwd,String name,String myClass){
        super(id,passwd);
        this.setName(name);
        this.setMyClass(myClass);
        super.setPermission(Run.permission.STUDENT);
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return super.getId();
    }
    public void setId(String id){
        super.setId(id);
    }
    public String getMyClass(){
        return this.myClass;
    }
    public void setMyClass(String myClass){
        this.myClass = myClass;
    }
    public Run.permission getPermission(){
        return super.getPermission();
    }
    public void show(){
        System.out.println(this.getId()+" "+this.getName()+' '+this.getMyClass());
    }
    // public boolean login(){
    //     System.out.println("stuId:");
    //     Scanner sc = new Scanner(System.in);
    //     String id = sc.next();
    //     System.out.println("password:");
    //     String passwd = sc.next();
    //     if(id==this.getId()&&passwd==this.getPasswd())
    //         return true;
    //     else 
    //         return false;
    // }
}
