package philharmonic.service.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import philharmonic.service.spring.dao.AbstractDao;
import philharmonic.service.spring.dao.StageDao;
import philharmonic.service.spring.model.Stage;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory factory) {
        super(factory, Stage.class);
    }
}
