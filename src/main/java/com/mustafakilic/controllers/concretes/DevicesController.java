package com.mustafakilic.controllers.concretes;

import com.mustafakilic.entities.concretes.Device;
import org.springframework.web.bind.annotation.*;
import com.mustafakilic.services.concretes.DeviceService;

@RestController
@RequestMapping("/devices")
public class DevicesController {

    private DeviceService deviceService;

    public DevicesController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/list")
    public Iterable<Device> list() {
        return this.deviceService.list();
    }

    @PostMapping("/add")
    public Device add(Device device) {
        return this.deviceService.add(device);
    }
    @GetMapping("/getByBrandName/{brand}")
    public Device getByBrandName(String brand){
        return this.deviceService.getByBrand(brand);
    }
    @GetMapping("/getById/{id}")
    public Device getById(@RequestParam Long id){
        return deviceService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@RequestParam Long id){
        deviceService.deleteById(id);
    }
}