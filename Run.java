
public class Run {
    enum permission {NONE,STUDENT,TEACHER,ADMIN}
    //static Database ;
    static User currentUser= new User();
    static Login login = new Login(currentUser);
    static Menu menu = new Menu();
    static Operation operation =new Operation(currentUser);
    static permission runtime = permission.NONE;
    // static Login lg = new Login();
    static void startloading(){
        Loadfile ld = new Loadfile();
        ld.loadAll();
    }
    static void endSaving(){
        Savefile sv = new Savefile();
        sv.savaAll();
        System.out.println("saved");
    }
    public static void main(String[] args) {
        startloading();
        while(currentUser.getPermission()==permission.NONE)
            currentUser = login.tologin();
        runtime = currentUser.getPermission();
        int statu =1;
        do{
            statu = menu.funSelect(currentUser);
        }while(statu ==1);   
        endSaving();
    }
}
