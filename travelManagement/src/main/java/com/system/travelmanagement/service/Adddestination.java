package com.system.travelmanagement.service;

import com.system.travelmanagement.Pojo.DestinationPojo;

import java.io.IOException;

public interface Adddestination {
    DestinationPojo saveDestination(DestinationPojo destinationPojo) throws IOException;
}
