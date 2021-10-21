package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.service.ModelServiceModel;

import java.util.List;

public interface ModelService {

    void initializeModels();

    ModelEntity findById(Long id);

}
