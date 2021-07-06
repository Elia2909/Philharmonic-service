package philharmonic.service.spring.service.impl;

import philharmonic.service.spring.dao.StageDao;
import philharmonic.service.spring.exception.DataProcessingException;
import philharmonic.service.spring.model.Stage;
import philharmonic.service.spring.service.StageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao StageDao) {
        this.stageDao = StageDao;
    }

    @Override
    public Stage add(Stage Stage) {
        return stageDao.add(Stage);
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
