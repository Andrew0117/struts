package test.task.user.pojo;

import java.io.Serializable;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class Genders implements Serializable {

    private Integer id;
    private String gender;

    public Genders() {
    }

    public Genders(Integer id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
