package com.application.demo.MedicineList;

import java.util.List;



public interface MedicineService {
	void insertMedicines(MedicineEntity medicines);
	MedicineEntity updateUser(MedicineEntity medicines,int medicineId);
	
	void deleteMedicines(int medicineId);
	MedicineEntity findById(int medicineId);
	List<MedicineEntity>getMedicineDetails();
}
