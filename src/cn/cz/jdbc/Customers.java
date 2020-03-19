package cn.cz.jdbc;

import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-03-17-9:00
 */
public class Customers {

    private int id;
    private String name;
    private String email;
    private Date brith;

    public Customers(int id, String name, String email, Date brith) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.brith = brith;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ",    name='" + name + '\'' +
                ",    email='" + email + '\'' +
                ",    brith='" + brith + '\''
               ;
    }
}
