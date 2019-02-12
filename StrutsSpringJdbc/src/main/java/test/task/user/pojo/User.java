package test.task.user.pojo;

import test.task.user.service.GendersList;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class User implements Serializable {

    private Long id;
    private String name;
    private String surName;
    private String email;
    private Date birthday;
    private Genders gender;

    private Integer genderId;

    public User() {
        this.genderId = -1;
    }

    public User(Long id, String name, String surName, String email, Date birthday, Genders gender) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setBirthdayString(String birthday) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            this.birthday = (Date) formatter.parse(birthday);
        } catch (ParseException e) {
        }
    }

    public String getBirthdayString() {
        if (this.birthday == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.format(this.birthday);
    }

    public Integer getAge() {
        if (this.birthday == null) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        sdf.setLenient(false);
        String b = sdf.format(this.birthday);
        String c = sdf.format(new Date());
        return Integer.valueOf(c) - Integer.valueOf(b);
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
        this.gender = GendersList.getGenders(genderId);
    }

}
