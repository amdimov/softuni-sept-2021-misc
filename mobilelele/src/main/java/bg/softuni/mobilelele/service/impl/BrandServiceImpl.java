package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.service.BrandServiceModel;
import bg.softuni.mobilelele.model.service.ModelServiceModel;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford");

            brandRepository.save(ford);
        }
    }

    @Override
    public List<BrandServiceModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandEntity -> {
                    BrandServiceModel brandServiceModel = modelMapper.map(brandEntity, BrandServiceModel.class);
                    brandServiceModel.setModels(brandEntity.getModels().stream()
                            .map(modelEntity -> modelMapper.map(modelEntity, ModelServiceModel.class))
                            .collect(Collectors.toList()));
                    return brandServiceModel;
                })
                .collect(Collectors.toList());
    }
}
