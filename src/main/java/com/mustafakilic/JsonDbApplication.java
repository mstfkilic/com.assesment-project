package com.mustafakilic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustafakilic.entities.concretes.Device;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.mustafakilic.services.concretes.DeviceService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@ComponentScan()
@SpringBootApplication

public class JsonDbApplication {

    public static void main(String[] args){
        SpringApplication.run(JsonDbApplication.class,args);
    }

    @Bean
    CommandLineRunner runner(DeviceService deviceService){
        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Device>>typeReference = new TypeReference<List<Device>>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/devices.json");
            try {
                List<Device> devices = objectMapper.readValue(inputStream,typeReference);
                deviceService.save(devices);
                System.out.println("Device's informations saved");
            }
            catch (IOException e){
                System.out.println("Unable to save devices" + e.getMessage());
            }

        };
    }
}
