package com.mustafakilic.services.concretes;

import com.mustafakilic.entities.concretes.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mustafakilic.repositories.abstracts.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public Iterable<Device>list(){
        return deviceRepository.findAll();
    }
    public Device add(Device device){
        if(device.getModel()==null && device.getBrand()==null && device.getOs()==null && device.getOsVersion()==null ){
            System.out.println("Değerler boş olamaz");
        }
        return deviceRepository.save(device);
    }
    public Device getByBrand(String brand){
        return deviceRepository.getByBrand(brand);
    }

    public Device getById(Long id){
        return deviceRepository.getById(id);
    }
    public void deleteById(Long id){
        deviceRepository.deleteById(id);
    }
    
    public Iterable<Device> save(List<Device> devices){

        return deviceRepository.saveAll(devices);
    }
    

}
