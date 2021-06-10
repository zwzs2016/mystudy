package cn.tedu.boot31.entity;

public class Hero {
    private Integer id;
    private String name;
    private String type;
    private Integer money;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Hero(Integer id, String name, String type, Integer money) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                '}';
    }
}
