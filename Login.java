import java.util.Scanner;

class Login {
    User currentUser = null;
    Login(User user){
        currentUser = user;
    }
    
    public User tologin(){
        Run.permission runtime = currentUser.getPermission();
        User user = null;
        if(runtime==Run.permission.NONE)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("id:");
            String id = sc.next();
            System.out.println("password");
            String passwd = sc.next();
            user = Database.userList.findById(id);
            if(user!=null){
                if(user.getPasswd().equals(passwd)){
                    System.out.println("登陆成功，身份："+user.getPermission());
                }
                else{
                    System.out.println("登录失败，请检查密码或ID");
                }
            }
            else{
                System.out.println("未找到用户");
            }
        }
        else{
            System.out.println("已经登录，身份："+runtime);
            user = currentUser;
        }
    
        return user;
    }
}
