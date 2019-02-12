package test.task.user.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;
import test.task.user.crud.Crud;
import test.task.user.form.UserTableForm;
import test.task.user.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class UserTableAction extends ActionSupport {

    @Override
    public ActionForward execute(
            ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        DataSource ds = (DataSource) getWebApplicationContext().getBean("dataSource");
        Crud crud = (Crud) getWebApplicationContext().getBean("usersCrud");

        UserTableForm userTableForm = (UserTableForm) form;

        String action = request.getParameter("a");
        if (action != null && !action.equals("") && !action.equals(userTableForm.getAction())) {
            User u = userTableForm.getUser(Long.valueOf(action));
            if (u != null) {
                crud.Delete(ds, u.getId());
            }
            userTableForm.setAction(action);
        }
        userTableForm.setListUser(crud.Select(ds));

        return mapping.getInputForward();
    }

}
