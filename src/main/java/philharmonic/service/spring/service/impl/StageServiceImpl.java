package philharmonic.service.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import philharmonic.service.spring.dao.StageDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.Stage;
import philharmonic.service.spring.service.StageService;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get cinema hall by id " + id));
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }
}
