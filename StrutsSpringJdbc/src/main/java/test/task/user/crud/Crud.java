package test.task.user.crud;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public interface Crud {

    List Select(DataSource ds);

    int Insert(DataSource ds, Object o);

    int Delete(DataSource ds, Long id);

}
