import java.util.Vector;

public class SelectionList {
    Vector<Selection> selections = new Vector<>();
    
    public void addInList(Student stu,Cource cource){
        this.selections.add(new Selection(stu, cource));
    }
    
    public Vector<Selection> getSelections(){
        return this.selections;
    }
    public Vector<Cource> findCources(Student stu){
        Vector<Cource> cources = new Vector<Cource>();
        for(Selection s:this.selections){
            if(s.getStu().equals(stu)) 
                cources.add(s.getCource());
        }
        return cources;
    }
    public Vector<Student> findStudents(Cource cource){
        Vector<Student> students = new Vector<Student>();
        for(Selection s:this.selections){
            if(s.getCource().equals(cource)) 
                students.add(s.getStu());
        }
        return students;
    }
    public boolean removeFromList(Student stu,Cource cource){
        for(Selection s:this.selections){
            if(s.getStu().equals(stu)&&s.getCource().equals(cource))
               { this.selections.removeElement(s);
                return true;    
            }
        }
        return false;

    }
}
