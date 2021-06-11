package cn.tedu.boot42.entity;

public class Emp {
    private Integer id;
    private String name;
    private Integer sal;
    private String job;

    public Emp(Integer id, String name, Integer sal, String job) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", job='" + job + '\'' +
                '}';
    }
}
