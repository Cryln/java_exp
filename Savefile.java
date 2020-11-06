import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Savefile {
    public void savaAll(){
        saveStu();
        saveTchr();
        saveAdmin();
        saveCource();
        saveSelection();
        saveTeaching();
    }
    private void saveStu(){
        File file = new File("./DB/students.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));) {
            if(!file.exists()){
                file.createNewFile();
            }
            for(Student s:Database.studentList.getStudents()){
                out.write(s.getName()+' '+s.getPasswd()+' '+s.getId()+' '+s.getMyClass()+"\r\n");
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void saveTchr(){
        File file = new File("./DB/teachers.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));) {
            if(!file.exists()){
                file.createNewFile();
            }
            for(Teacher t:Database.teacherList.getTeachers()){
                out.write(t.getName()+' '+t.getPasswd()+' '+t.getId()+' '+t.getLevel()+"\r\n");
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void saveAdmin(){
        File file = new File("./DB/admin.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));) {
            if(!file.exists()){
                file.createNewFile();
            }
            for(User u:Database.userList.getUsers()){
                if(u.getPermission()==Run.permission.ADMIN){
                    out.write(u.getId()+' '+u.getPasswd()+"\r\n");
                    break;
                }
                    
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void saveCource(){
        File file = new File("./DB/cources.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));) {
            if(!file.exists()){
                file.createNewFile();
            }
            for(Cource c:Database.courceList.getCources()){
                out.write(c.getCourceId()+' '+c.getCourceName()+' '+c.getCourceType()+' '
                +Double.toString(c.getCapacity())+"\r\n");
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void saveSelection(){
        File file = new File("./DB/selections.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));) {
            if(!file.exists()){
                file.createNewFile();
            }
            for(Selection s:Database.selectionList.getSelections()){
                out.write(s.getStu().getId()+' '+s.getCource().getCourceId()+"\r\n");
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
    private void saveTeaching(){
        File file = new File("./DB/teachings.txt");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));) {
            if(!file.exists()){
                file.createNewFile();
            }
            for(Teaching t:Database.teachingList.getTeachings()){
                out.write(t.getTeacher().getId()+' '+t.getCource().getCourceId()+"\r\n");
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
}
