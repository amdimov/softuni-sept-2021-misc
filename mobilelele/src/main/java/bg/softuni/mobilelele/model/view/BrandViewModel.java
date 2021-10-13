package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.ModelEntity;

import java.util.List;

public class BrandViewModel {
    private String name;
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandViewModel setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }
}
