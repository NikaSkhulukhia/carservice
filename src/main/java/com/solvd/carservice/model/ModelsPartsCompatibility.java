package com.solvd.carservice.model;

import java.util.Objects;

public class ModelsPartsCompatibility {
    private Long id;
    private Long brandModelId;
    private Long carPartId;

    public ModelsPartsCompatibility() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        ModelsPartsCompatibility that = (ModelsPartsCompatibility) o;
        return Objects.equals(id, that.id) && Objects.equals(brandModelId, that.brandModelId) && Objects.equals(carPartId, that.carPartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandModelId, carPartId);
    }

    @Override
    public String toString() {
        return "ModelsPartsCompatibility{" +
                "id=" + id +
                ", brandModelId=" + brandModelId +
                ", carPartId=" + carPartId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandModelId() {
        return brandModelId;
    }

    public void setBrandModelId(Long brandModelId) {
        this.brandModelId = brandModelId;
    }

    public Long getCarPartId() {
        return carPartId;
    }

    public void setCarPartId(Long carPartId) {
        this.carPartId = carPartId;
    }
}
