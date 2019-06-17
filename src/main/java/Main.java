import Utils.HibernateUtils;
import model.Notes;
import model.User;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {


    public static void main(final String[] args) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        User u = session.load(User.class, (long)1);
        u.getNotes().forEach(note -> System.out.println(note.getContent()));
        transaction.commit();
        session.close();

    }
}