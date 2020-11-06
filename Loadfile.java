import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Loadfile {
    public void loadAll(){
        loadStu();
        loadTchr();
        loadCource();
        loadSelection();
        loadTeaching();
        loadAdmin();
    }
    private void loadStu(){
        try (
            FileInputStream fs = new FileInputStream("./DB/students.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));) 
            {
            String data = null;
            while((data = br.readLine())!=null){
                String[] ps = data.split(" ");
                String name = ps[0];
                String passwd = ps[1];
                String id = ps[2];
                String myClass = ps[3];
                Student student = new Student(id, passwd, name, myClass);
                Database.studentList.addInList(student);
                Database.userList.addInList(student);
            }
            
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void loadTchr(){
        try (
            FileInputStream fs = new FileInputStream("./DB/teachers.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));          
        ) {
            String data = null;
            while((data = br.readLine())!=null){
                String[] ps = data.split(" ");
                String name = ps[0];
                String passwd = ps[1];
                String id = ps[2];
                String level = ps[3];
                Teacher teacher = new Teacher(id, passwd, name, level);
                Database.teacherList.addInList(teacher);
                Database.userList.addInList(teacher);
                
            }            
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void loadAdmin(){
        try (
            FileInputStream fs = new FileInputStream("./DB/admin.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));          
        ) {
            String data = null;
            while((data = br.readLine())!=null){
                String[] ps = data.split(" ");
                String id = ps[0];
                String passwd = ps[1];
                User user = new User(id, passwd);
                user.setPermission(Run.permission.ADMIN);
                Database.userList.addInList(user);
            }
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void loadCource(){
        try (
            FileInputStream fs = new FileInputStream("./DB/cources.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ) {
            String data = null;
            while((data = br.readLine())!=null){
                String[] ps = data.split(" ");
                String courceId = ps[0];
                String courceName = ps[1];
                String courceType = ps[2];
                double capacity = Double.parseDouble(ps[3]);
                Database.courceList.addInList(courceId, courceName, courceType,capacity);
            } 
        } catch (Exception e) {
           e.printStackTrace(); //TODO: handle exception
        }
    }
    private void loadSelection(){
        try (
            FileInputStream fs = new FileInputStream("./DB/selections.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ) {
            String data = null;
            while((data = br.readLine())!=null){
                String[] ps = data.split(" ");
                String studentId = ps[0];
                String courceId = ps[1];
                Database.selectionList.addInList(Database.studentList.findById(studentId),
                Database.courceList.findById(courceId));
            } 
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void loadTeaching(){
        try (
            FileInputStream fs = new FileInputStream("./DB/teachings.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ) {
            String data = null;
            while((data = br.readLine())!=null){
                String[] ps = data.split(" ");
                String teacherId = ps[0];
                String courceId = ps[1];
                Database.teachingList.addInList(Database.teacherList.findById(teacherId),
                Database.courceList.findById(courceId));
            } 
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }

}
