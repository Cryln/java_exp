import java.util.Vector;

public class TeachingList {
    Vector<Teaching> teachings = new Vector<>();
    public Vector<Teaching> getTeachings(){
        return this.teachings;
    }
    public void addInList(Teacher teacher,Cource cource){
        this.teachings.add(new Teaching(teacher, cource));
    }
    public Vector<Cource> findCources(Teacher teacher){
        Vector<Cource> cources = new Vector<Cource>();
        for(Teaching t:this.teachings){
            if(t.getTeacher().equals(teacher))
                cources.add(t.getCource());
        }
        return cources;
    }
    public Vector<Teacher> findTeachers(Cource cource){
        Vector<Teacher> teachers = new Vector<Teacher>();
        for(Teaching t:this.teachings){
            if(t.getCource().equals(cource))
                teachers.add(t.getTeacher());
        }
        return teachers;
    }
    public void removeFromList(Teacher teacher,Cource cource){
        for(Teaching t:this.teachings){
            if(t.getTeacher().equals(teacher)&&t.getCource().equals(cource)){
                this.teachings.removeElement(t);
                break;
            }
                
        }
    }
}
