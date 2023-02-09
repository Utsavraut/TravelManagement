package com.system.travelmanagement.service.impl;

import com.system.travelmanagement.Entity.Destination;
import com.system.travelmanagement.Pojo.DestinationPojo;
import com.system.travelmanagement.Repo.DestinationRepo;
import com.system.travelmanagement.service.Adddestination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdddestinationImpl implements Adddestination {
    private final DestinationRepo destinationRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/images";
    @Override
    public DestinationPojo saveDestination(DestinationPojo destinationPojo) throws IOException {
        Destination destination = new Destination();
        if (destinationPojo.getId() != null){
            destination.setId(destinationPojo.getId());
        }
        destination.setCity(destinationPojo.getCity());
        destination.setCountry(destinationPojo.getCountry());
        destination.setPrice(destinationPojo.getPrice());

        if(destinationPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, destinationPojo.getImage().getOriginalFilename());
            fileNames.append(destinationPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, destinationPojo.getImage().getBytes());
            destination.setImage(destinationPojo.getImage().getOriginalFilename());

        }
        destinationRepo.save(destination);
        return new DestinationPojo(destination);
    }


}

