package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.service.ModelServiceModel;

import java.util.List;

public class BrandViewModel {
    private String name;
    private List<ModelServiceModel> models;

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelServiceModel> getModels() {
        return models;
    }

    public BrandViewModel setModels(List<ModelServiceModel> models) {
        this.models = models;
        return this;
    }
}
