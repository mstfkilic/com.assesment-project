package com.mustafakilic.repositories.abstracts;

import com.mustafakilic.entities.concretes.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device,Long> {

    Device getById(Long id);
    Device getByBrand(String brand);
    Device getByModel(String model);
    Device getByOs(String os);
    Device getByOsVersion(String osVersion);
    void deleteById(Long id);

}
