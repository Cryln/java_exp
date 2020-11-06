// import java.util.Scanner;

public class Teacher extends User{
    private String name;
    private String level;
    public Teacher(String id, String passwd, String name, String level){
        super(id,passwd);
        this.setName(name);
        this.setLecel(level);
        super.setPermission(Run.permission.TEACHER);
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
    public String getLevel(){
        return this.level;
    }
    public void setLecel(String level){
        this.level = level;
    }
    public Run.permission getPermission(){
        return super.getPermission();
    }
    public void show(){
        System.out.println(this.getId()+' '+this.getName());
    }
    // public boolean login(){
    //     System.out.println("workId:");
    //     Scanner sc = new Scanner(System.in);
    //     String workId = sc.next();
    //     System.out.println("password:");
    //     String passwd = sc.next();
    //     if(workId==this.getWorkId()&&passwd==this.getPasswd())
    //         return true;
    //     else 
    //         return false;
    // }
}
