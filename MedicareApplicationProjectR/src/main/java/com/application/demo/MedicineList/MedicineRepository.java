package com.application.demo.MedicineList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Integer> {

	/*static Medicines getMedicine(int medicineId) {
		// TODO Auto-generated method stub
		return null;
	}*/
	MedicineEntity findByMedicineId(int MedicineId);

}
