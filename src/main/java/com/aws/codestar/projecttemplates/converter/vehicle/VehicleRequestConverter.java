package com.aws.codestar.projecttemplates.converter.vehicle;

import com.aws.codestar.projecttemplates.converter.image.ImageRequestConverter;
import com.aws.codestar.projecttemplates.map.image.ImageRequest;
import com.aws.codestar.projecttemplates.map.vehicle.VehicleRequest;
import com.aws.codestar.projecttemplates.model.Image;
import com.aws.codestar.projecttemplates.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleRequestConverter {

    @Autowired
    private ImageRequestConverter imageRequestConverter;

    public Vehicle convert(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setTitle(vehicleRequest.getTitle());
        vehicle.setDescription(vehicleRequest.getDescription());
        vehicle.setImages(this.getImages(vehicleRequest.getImages()));
        return vehicle;
    }

    private List<Image> getImages(List<ImageRequest> imageRequests) {
        List<Image> images = new ArrayList<>();
        for (ImageRequest imageRequest : imageRequests) {
            images.add(this.imageRequestConverter.convert(imageRequest));
        }
        return images;
    }
}