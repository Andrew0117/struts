package test.task.user.form;

import org.apache.struts.action.ActionForm;
import test.task.user.pojo.User;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class UserTableForm extends ActionForm implements Serializable {

    private List<User> listUser;

    private String action;

    public UserTableForm() {
        listUser = new LinkedList<>();
    }

    public User getUser(Long id) {
        return this.listUser.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
