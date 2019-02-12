package test.task.user.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.struts.ActionSupport;
import test.task.user.crud.Crud;
import test.task.user.form.UserForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
@Component
public class UserAction extends ActionSupport {

    @Override
    public ActionForward execute(
            ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        DataSource ds = (DataSource) getWebApplicationContext().getBean("dataSource");
        Crud crud = (Crud) getWebApplicationContext().getBean("usersCrud");

        UserForm userForm = (UserForm) form;
        if (crud.Insert(ds, userForm.getUser()) == 0) {
            userForm.clearForm();
        }

        return mapping.getInputForward();
    }

}
