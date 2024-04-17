package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressResponse;
import edu.miu.cs489.dental_surgeries_appointment.model.Address;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAllAddress();
}
