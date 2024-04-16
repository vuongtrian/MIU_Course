package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.model.Address;
import edu.miu.cs489.dental_surgeries_appointment.repository.AddressRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(int addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public Address getAddress(int addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(()-> new RuntimeException("Address not found"));
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
