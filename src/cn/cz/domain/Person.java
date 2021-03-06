package cn.cz.domain;

/**
 * @author Kartoffel
 * @create 2020-03-09-22:31
 */
public class Person {
    private int id;
    private String name;

    public String a;
    protected String b;
    String c;
    private String d;

    public Person(){}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void eat(){
        System.out.println("吃");
    }

    private void eat(String food){
        System.out.println("吃" + food);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
