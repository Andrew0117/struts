package test.task.user.service;

import test.task.user.pojo.Genders;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class GendersList {

    private static final List<Genders> LISTGENDERS;

    public static final List<Genders> getListGenders() {
        return LISTGENDERS;
    }

    public static final Genders getGenders(Integer id) {
        return LISTGENDERS.stream().filter(g -> g.getId().equals(id)).findFirst().orElse(null);
    }

    static {
        // may be db
        LISTGENDERS = new LinkedList<>();
        LISTGENDERS.add(new Genders(1, "Male"));
        LISTGENDERS.add(new Genders(2, "Female"));
    }
}
