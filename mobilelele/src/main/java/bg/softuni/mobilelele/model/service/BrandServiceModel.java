package bg.softuni.mobilelele.model.service;

import bg.softuni.mobilelele.model.entity.ModelEntity;

import java.util.List;

public class BrandServiceModel {

    private String name;
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandServiceModel setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }
}
