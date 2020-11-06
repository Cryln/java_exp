import java.util.Vector;

public class UserList {
    private Vector<User> users = new Vector<>();
    public void addInList(String id,String passwd){
        this.users.add(new User(id,passwd));
    }
    public void addInList(User user){
        this.users.add(user);
    }
    public User findById(String id){
        for(User u:this.users){
            if(u.getId().equals(id)) return u;
        }
        return null;
    }

    public Vector<User> getUsers() {
        return users;
    }

    // public void setUsers(Vector<User> users) {
    //     this.users = users;
    // }
}
