package bg.softuni.mobilelele.service;


import bg.softuni.mobilelele.model.service.BrandServiceModel;

import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandServiceModel> getAllBrands();
}
