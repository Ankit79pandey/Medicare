package com.application.demo.MedicineList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/MedicineList")
public class MedicineController {



@Autowired
private MedicineServiceImpl medicineService;

@PostMapping("/medicines")
public MedicineEntity insert(@RequestBody MedicineEntity medicines)
{
	medicineService.insertMedicines(medicines);
	return medicines;
}
@GetMapping("/medicines")
public List<MedicineEntity> getMedicineDetails() 
{
	List<MedicineEntity> medicines = medicineService.getMedicineDetails();
	return medicines;
}

@GetMapping("/medicines/{medicineId}")
public MedicineEntity getMedicineById(@PathVariable("medicineId") int medicineId) {	
	
	MedicineEntity M = medicineService.findById(medicineId);
	return M;
}




@DeleteMapping("/medicines/{medicineId}")
public ResponseEntity<Object> deleteMedicine(@PathVariable("medicineId") int medicineId) {
	medicineService.deleteMedicines(medicineId);
	return new ResponseEntity<>("deleted successsfully", HttpStatus.OK);
	}



@PutMapping("/medicine/{medicineId}")
public ResponseEntity<Object> updateUser(@RequestBody MedicineEntity medicine,@PathVariable int  medicineId){
	MedicineEntity data= medicineService.updateMedicine(medicine, medicineId);
	
	if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	else
		return new ResponseEntity<Object>("User is Not Available",HttpStatus.NOT_FOUND);
}
//@PutMapping("/medicines/{medicineId}")
//public MedicineEntity update(@RequestBody MedicineEntity medicine)
//{
//	medicineService.updateMedicines(medicine);
//	return medicine;
//}
}
