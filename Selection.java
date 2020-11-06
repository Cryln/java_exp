
public class Selection {
    private Student stu;
    private Cource cource;
    public Selection(Student stu,Cource cource){
        this.setCource(cource);
        this.setStu(stu);
    }
    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public Cource getCource() {
        return cource;
    }

    public void setCource(Cource cource) {
        this.cource = cource;
    }


}
