package com.application.demo.MedicineList;

import java.util.List;


import org.springframework.stereotype.Service;
@Service
public class MedicineServiceImpl implements MedicineService{
private MedicineRepository medicineRepository;

public MedicineServiceImpl(MedicineRepository medicineRepository) {
	super();
	this.medicineRepository = medicineRepository;
}

@Override
public void insertMedicines(MedicineEntity medicines) {
	medicineRepository.save(medicines);
	
}


@Override
public void deleteMedicines(int medicineId) {
	//Medicines m = medicineRepository.getById(medicineId);
	medicineRepository.deleteById(medicineId);
}

@Override
public MedicineEntity findById(int medicineId) {
	MedicineEntity m = medicineRepository.findByMedicineId(medicineId);
	return m;
}

@Override
public List<MedicineEntity> getMedicineDetails() {
	List<MedicineEntity> medicines = medicineRepository.findAll();
	return medicines;
}



public MedicineEntity updateMedicine(MedicineEntity medicine, int medicineId) {
	// TODO Auto-generated method stub
	if(medicineRepository.findById(medicineId).isPresent())
	{
		MedicineEntity old= medicineRepository.findById(medicineId).get();
		old.setSeller(medicine.getSeller());
	old.setStatus(medicine.getStatus());
		old.setDescription(medicine.getDescription());
		old.setExpdate(medicine.getExpdate());
		old.setManufactureDate(medicine.getManufactureDate());
		old.setMedicineName(medicine.getMedicineName());
		old.setPrice(medicine.getPrice());
		old.setType(medicine.getType());

		return medicineRepository.save(old);
	}
	else
	{
		return null;
	}
}

@Override
public MedicineEntity updateUser(MedicineEntity medicines, int medicineId) {
	// TODO Auto-generated method stub
	return null;
}
}