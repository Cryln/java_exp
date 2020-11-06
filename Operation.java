import java.util.Scanner;
import java.util.Vector;


class Operation {
    User currentUser = null;
    String ins,del;
    {
        ins = "insert";
        del = "delete";
    }
    Operation(User user){
        currentUser = user;
    }
    public void denied(){
        System.out.println("permission denied");
    }
    public boolean changePasswd(){
        if(this.currentUser.getPermission().ordinal()>Run.permission.NONE.ordinal()){
            Scanner sc = new Scanner(System.in);
            System.out.println("输入新的密码");
            String passwd = sc.next();
            this.currentUser.setPasswd(passwd);
            return true;
        }
        else{
            denied();
            return false;
        }
    }
    public Vector<Cource> getCources(){
        if(this.currentUser.getPermission().ordinal()==Run.permission.STUDENT.ordinal()){
            return Database.selectionList.findCources((Student)currentUser);
        }
        else if(this.currentUser.getPermission().ordinal()==Run.permission.TEACHER.ordinal()){
            return Database.teachingList.findCources((Teacher)currentUser);
        }
        else if(this.currentUser.getPermission().ordinal()==Run.permission.ADMIN.ordinal()){
            return Database.courceList.getCources();
        }
        
        else return null;
    }
    public void printCources(Vector<Cource> cources){
        int max = 0;
        for(Cource c:cources){
            
            System.out.println(c.getCourceId()+' '+c.getCourceName()+' '+
            c.getCourceType()+' '+c.getCapacity());
        }
    }
    public Vector<Student> getStuByCource(){
        String courceId;
        System.out.println("输入课程id：");
        Scanner sc = new Scanner(System.in);
        courceId = sc.next();
        if(this.currentUser.getPermission().ordinal()>Run.permission.STUDENT.ordinal()){
            return Database.selectionList.findStudents(Database.courceList.findById(courceId));
        }
        else return null;
    }
    public void findStuByCource(Vector<Student> students){
        for(Student s:students){
            System.out.println(s.getId()+' '+s.getName()+' '+
            s.getMyClass());
        }
    }
    public boolean insertCource(){
        if(this.currentUser.getPermission().ordinal()==Run.permission.ADMIN.ordinal()){
            return Database.courceList.addManually();
        }
        else{
            denied();
            return false;
        }
    }
    public void stuListOp(String operation){
        if(this.currentUser.getPermission().ordinal()==Run.permission.ADMIN.ordinal()){
            if(operation.equals(ins)){
                Database.studentList.addManually();
            }
            else if(operation.equals(del)){
                System.out.println("student id:");
                Scanner sc = new Scanner(System.in);
                String id = sc.next();
                for(Student s:Database.studentList.getStudents()){
                    if(s.getId().equals(id)){
                        Database.studentList.getStudents().removeElement(s);
                        break;
                    }
                }
                System.out.println("未找到该stu");
            }
        }
        else{
            denied();
        }
    }
    public void tchrListOp(String operation){
        if(this.currentUser.getPermission().ordinal()==Run.permission.ADMIN.ordinal()){
            if(operation.equals(ins)){
                Database.teacherList.addManually();
            }
            else if(operation.equals(del)){
                System.out.println("teacher id:");
                Scanner sc = new Scanner(System.in);
                String id = sc.next();
                for(Teacher t:Database.teacherList.getTeachers()){
                    if(t.getId().equals(id)){
                        Database.teacherList.getTeachers().removeElement(t);
                        break;
                    }
                }
                System.out.println("未找到该teacher");
            }
        }
        else{
            denied();
        }
    }
    public void crsListOp(String operation){
        if(this.currentUser.getPermission().ordinal()==Run.permission.ADMIN.ordinal()){
            if(operation.equals(ins)){
                Database.courceList.addManually();
            }
            else if(operation.equals(del)){
                System.out.println("courceId:");
                Scanner sc = new Scanner(System.in);
                String id = sc.next();
                for(Cource c:Database.courceList.getCources()){
                    if(c.getCourceId().equals(id)){
                        Database.courceList.getCources().removeElement(c);
                        break;
                    }
                }
                System.out.println("未找到该cource");
            }
        }
        else{
            denied();
        }
    }
    public boolean seleListOp(String operation){
        if(this.currentUser.getPermission().ordinal()%2==1){
            String studentId,courceId;
            if(this.currentUser.getPermission()==Run.permission.STUDENT){
                studentId = this.currentUser.getId();
            }
            else{
                System.out.println("输入学生id:");
                Scanner sc = new Scanner(System.in);
                studentId = sc.next();
            }
            if(operation.equals(ins)){
                System.out.println("输入课程id:");
                Scanner sc = new Scanner(System.in);
                courceId = sc.next();
                Student student = Database.studentList.findById(studentId);
                Cource cource = Database.courceList.findById(courceId);
                if(cource.getCapacity()<=Database.selectionList.findStudents(cource).size()){
                    System.out.println("课满！");
                    return false;
                }
                if(student!=null&&cource!=null){
                    Database.selectionList.addInList(student, cource);
                }
                else{
                    System.out.println("输入有误");
                }
            }
            else if(operation.equals(del)){
                System.out.println("cource id:");
                Scanner sc = new Scanner(System.in);
                courceId = sc.next();
                Student student = Database.studentList.findById(studentId);
                Cource cource = Database.courceList.findById(courceId);
                Database.selectionList.removeFromList(student, cource);
            }
                return true;
            }

        denied();
        return false;

    }
    public boolean tchListOp(String operation){
        if(this.currentUser.getPermission().ordinal()==3||this.currentUser.getPermission().ordinal()==2){
            String teacherId,courceId;
            if(this.currentUser.getPermission()==Run.permission.TEACHER){
                teacherId = this.currentUser.getId();
            }
            else{
                System.out.println("输入老师id:");
                Scanner sc = new Scanner(System.in);
                teacherId = sc.next();
            }
            if(operation.equals(ins)){
                System.out.println("输入课程id:");
                Scanner sc = new Scanner(System.in);
                courceId = sc.next();
                Teacher teacher = Database.teacherList.findById(teacherId);
                Cource cource = Database.courceList.findById(courceId);
                if(teacher!=null&&cource!=null){
                    Database.teachingList.addInList(teacher, cource);
                }
                else{
                    System.out.println("输入有误");
                }
            }
            else if(operation.equals(del)){
                System.out.println("cource id:");
                Scanner sc = new Scanner(System.in);
                courceId = sc.next();
                Teacher teacher = Database.teacherList.findById(teacherId);
                Cource cource = Database.courceList.findById(courceId);
                Database.teachingList.removeFromList(teacher, cource);
            }
                return true;
            }

        denied();
        return false;
    }
    public boolean resetUser(){
        if(this.currentUser.getPermission().ordinal()==Run.permission.ADMIN.ordinal()){
            System.out.println("用户Id:");
            Scanner sc = new Scanner(System.in);
            String id = sc.next();
            User user = Database.userList.findById(id);
            user.setPasswd("123456");
            
            return true;
        }
        else {
            denied();
            return false;
        }
    }
}
