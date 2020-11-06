import java.util.*;
public class User{
    private String passwd = null;
    private String id =null;
    private Run.permission permission=Run.permission.NONE;
    public User(String id,String passwd){
        this.setPasswd(passwd);
        this.setId(id);
    }
    public User(){}
    public String getPasswd(){
        return this.passwd;
    }
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }  
    public void setPasswd(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("请输入新密码(6位)：");
            String xpass = sc.next();
            System.out.print("请在此输入：");
            String xpass2 = sc.next();
            if(xpass.equals(xpass2)&&xpass.length()>=6){
                this.passwd = xpass;
                break;
            }
            else continue;
        }
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Run.permission getPermission() {
        return permission;
    }
    public void setPermission(Run.permission permission) {
        this.permission = permission;
    }

}