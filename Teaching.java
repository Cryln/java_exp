public class Teaching {
    private Teacher teacher;
    private Cource cource;
    public Teaching(Teacher teacher,Cource cource){
        this.setCource(cource);
        this.setTeacher(teacher);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Cource getCource() {
        return cource;
    }

    public void setCource(Cource cource) {
        this.cource = cource;
    }
}
