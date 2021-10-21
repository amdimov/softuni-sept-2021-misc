package bg.softuni.mobilelele.model.binding;

import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferAddBindModel {
    @NotEmpty
    private String model;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @NotNull
    private EngineEnum engine;
    @NotNull
    private TransmissionEnum transmission;
    @NotNull
    @Min(1930)
    private Integer year;
    @NotNull
    @PositiveOrZero
    private Integer mileage;
    @NotEmpty
    private String description;
    @NotEmpty
    private String imageUrl;

    public String getModel() {
        return model;
    }

    public OfferAddBindModel setModel(String model) {
        this.model = model;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddBindModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddBindModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddBindModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferAddBindModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddBindModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddBindModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddBindModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
