package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.BusOperatorDTO;
import com.hexaware.fastx.dto.RouteDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.serviceimpl.AdminService;
import com.hexaware.fastx.serviceimpl.BusOperatorServiceImpl;
import com.hexaware.fastx.serviceimpl.RouteServiceImpl;
import com.hexaware.fastx.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/api/admin/v1/")
@CrossOrigin("http://localhost:3000")
public class AdminController {

	private AdminService adminService;
	private RouteServiceImpl routeServiceImpl;
	private UserServiceImpl userServiceImpl;
	private BusOperatorServiceImpl busOperatorServiceImpl;

	@Autowired
	public AdminController(AdminService adminService, RouteServiceImpl routeServiceImpl, UserServiceImpl userServiceImpl,
			BusOperatorServiceImpl busOperatorServiceImpl) {
		super();
		this.adminService = adminService;
		this.routeServiceImpl = routeServiceImpl;
		this.userServiceImpl = userServiceImpl;
		this.busOperatorServiceImpl=busOperatorServiceImpl;
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(this.adminService.getAllUsers());
	}
	@GetMapping("/getRoutes/{departDate}/{source}/{destination}")
	public ResponseEntity<List<RouteDTO>> getAllRoutes(@PathVariable("departDate") String departDate,
														@PathVariable("source") String source,
														@PathVariable("destination") String destination){
		return ResponseEntity.ok(this.routeServiceImpl.getAllRoutes(departDate, source, destination));
	}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		this.userServiceImpl.deleteUser(id);
		return ResponseEntity.ok("User has been deleted Successfully");
	}
	@DeleteMapping("/deleteOperator/{id}")
	public ResponseEntity<String> deleteOperator(@PathVariable("id") Long id){
		this.busOperatorServiceImpl.deleteOperator(id);
		return ResponseEntity.ok("Operator has been deleted successfully");
	}
	@GetMapping("/getOperators")
	public ResponseEntity<List<BusOperatorDTO>> getAllOperators(){
		return ResponseEntity.ok(this.busOperatorServiceImpl.getAllOperators());
	}
	@PutMapping("/updateOperator/{id}")
	public ResponseEntity<BusOperatorDTO> updateOperator(@PathVariable("id")Long id, @RequestBody BusOperator operator) throws Exception{
		return ResponseEntity.ok(this.busOperatorServiceImpl.updateBusOperator(id, operator));
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<BusOperatorDTO> getBusOperator(@PathVariable("id")Long id){
		return ResponseEntity.ok(this.busOperatorServiceImpl.findById(id));
	}
	@GetMapping("/getAllRoutes")
	public ResponseEntity<List<RouteDTO>> getEveryRoute(){
		return ResponseEntity.ok(this.routeServiceImpl.getEveryRoute());
	}
	
}
