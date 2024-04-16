package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.model.Address;

import java.util.List;

public interface AddressService {
    Address save (Address address);
    Address updateAddress (Address address);
    void deleteAddress (int addressId);
    Address getAddress (int addressId);
    List<Address> getAllAddress();
}
