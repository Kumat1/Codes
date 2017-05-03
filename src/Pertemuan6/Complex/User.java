package Pertemuan6.Complex;

import java.util.List;

/**
 * Created by matt on 5/1/17.
 */
public class User extends Model {

    private Integer id;
    private String username;

    @Override
    protected String tableName() {
        return "user";
    }

    public static void main(String[] args) {
        User user = new User();
        List<User> list = user.select(null, User.class);
        System.out.println(list);
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String toString() {
        if (username != null)
            return username.toString();
        return null;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }
}
