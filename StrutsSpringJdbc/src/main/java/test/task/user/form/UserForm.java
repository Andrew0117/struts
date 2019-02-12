package test.task.user.form;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import test.task.user.pojo.Genders;
import test.task.user.pojo.User;
import test.task.user.service.GendersList;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class UserForm extends ValidatorForm implements Serializable {

    private User user;

    public UserForm() {
        super();

        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void clearForm() {
        this.user = new User();
    }

    public List<Genders> getGendersList() {
        return GendersList.getListGenders();
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = super.validate(mapping, request);
        if (this.user.getName() == null || this.user.getName().length() < 3) {
            errors.add("name", new ActionMessage("error.name.required"));
        }
        if (this.user.getSurName() == null || this.user.getSurName().length() < 3) {
            errors.add("surName", new ActionMessage("error.surname.required"));
        }
        if (this.user.getEmail() != null && !this.user.getEmail().equals("")
                && !EmailValidator.getInstance().isValid(this.user.getEmail())) {
            errors.add("email", new ActionMessage("error.email"));
        }
        return errors;
    }
}
