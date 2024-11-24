package com.hexaware.fastx.controller;

import java.nio.MappedByteBuffer;
import java.util.List;
import java.util.Map;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.BusDTO;
import com.hexaware.fastx.dto.BusOperatorDTO;
import com.hexaware.fastx.dto.RouteDTO;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.Route;
import com.hexaware.fastx.serviceimpl.BusOperatorServiceImpl;
import com.hexaware.fastx.serviceimpl.BusServiceImpl;
import com.hexaware.fastx.serviceimpl.RouteServiceImpl;

@RestController
@RequestMapping("/busoperator/v1")
public class BusOperatorController {

	private BusOperatorServiceImpl busOperatorServiceImpl;
	private BusServiceImpl busServiceImpl;
	private RouteServiceImpl routeServiceImpl;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	public BusOperatorController(BusOperatorServiceImpl busOperatorServiceImpl, BusServiceImpl busServiceImpl, RouteServiceImpl routeServiceImpl) {
		super();
		this.busOperatorServiceImpl = busOperatorServiceImpl;
		this.busServiceImpl = busServiceImpl;
		this.routeServiceImpl = routeServiceImpl;
	}
	
	@PostMapping("/addBusOperator")
	public ResponseEntity<BusOperatorDTO> addBusOperator(@RequestBody BusOperator busOperator){
		return ResponseEntity.ok(this.busOperatorServiceImpl.addBusOperator(busOperator));
	}
	
	@PostMapping("/addBus")
	public ResponseEntity<BusDTO> addBus(@RequestBody Bus bus, @RequestParam String username) throws Exception{
		BusDTO savedBusDTO = busServiceImpl.addBus(bus, username);
	    return ResponseEntity.ok(savedBusDTO);
	}
	//we can use this if want to assign bus by providing the username to the call
//	@PostMapping("/addBus")
//	public ResponseEntity<BusDTO> addBus(@RequestBody Map<String, Object> request) throws Exception{
//		String username = (String) request.get("username");
//		Bus bus = mapper.map(request, Bus.class);
//		BusDTO savedBusDTO = busServiceImpl.addBus(bus, username);
//	    return ResponseEntity.ok(savedBusDTO);
//	}
	
	@PostMapping("/addRoute")
	public ResponseEntity<RouteDTO> addRoute(@RequestBody Map<String, Object> request) throws Exception{
		String busNumber =(String) request.get("busNumber");
		Route route = mapper.map(request, Route.class);
		RouteDTO savedRoute = routeServiceImpl.addRoute(route, busNumber);
		return ResponseEntity.ok(savedRoute);
	}
	@GetMapping("/getRoutes/{departDate}/{source}/{destination}")
	public ResponseEntity<List<RouteDTO>> getAllRoutes(@PathVariable("departDate") String departDate,
														@PathVariable("source") String source,
														@PathVariable("destination") String destination){
		return ResponseEntity.ok(this.routeServiceImpl.getAllRoutes(departDate, source, destination));
	}
}