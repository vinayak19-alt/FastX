package com.hexaware.fastx.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.appender.routing.Routes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.BadRequestMadeException;
import com.hexaware.fastx.customexceptions.ResourceNotAvailableException;
import com.hexaware.fastx.dto.RouteDTO;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.Route;
import com.hexaware.fastx.repositories.BusRepository;
import com.hexaware.fastx.repositories.RouteRepository;
import com.hexaware.fastx.service.IRouteService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class RouteServiceImpl implements IRouteService{
	
	private RouteRepository routeRepository;
	private BusRepository busRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public RouteServiceImpl(RouteRepository routeRepository, BusRepository busRepository) {
		super();
		this.routeRepository = routeRepository;
		this.busRepository = busRepository;
	}

	@Override
	public RouteDTO addRoute(Route route, String busNumber) throws Exception {
		// TODO Auto-generated method stub
		if(busNumber == null || busNumber.isEmpty()) {
			//throw an error
			throw new ResourceNotAvailableException("Bus Number is empty");
		}
		Bus bus = this.busRepository.findByBusNumber(busNumber);
		if(bus == null) {
			throw new ResourceNotAvailableException("Bus with bus number :" + busNumber + " is not available");
		}
		route.setBus(bus);
		Route savedRoute = this.routeRepository.save(route);
		RouteDTO savedRouteDTO = mapper.map(savedRoute, RouteDTO.class);
		return savedRouteDTO;
	}

	@Override
	public List<RouteDTO> getAllRoutes(String departDate, String source, String destination) {
		// TODO Auto-generated method stub
		List<RouteDTO> routeDTOs = new ArrayList<>();
		List<Route> routes = this.routeRepository.findByDepartDateAndSourceAndDestination(departDate, source, destination);
		if(routes.size() == 0) {
			throw new BadRequestMadeException("No routes are available for selected date, source or destination");
		}
		routes.forEach((r) -> {
			routeDTOs.add(mapper.map(r, RouteDTO.class));
		});
		return routeDTOs;
	}

	@Override
	public List<RouteDTO> getEveryRoute() {
		// TODO Auto-generated method stub
		List<RouteDTO> routeDTOs = new ArrayList<>();
		List<Route> routes = this.routeRepository.findAll();
		if(routes.size()==0) {
			throw new BadRequestMadeException("No routes are available in the system");
		}
		routes.forEach((r)->{
			routeDTOs.add(mapper.map(r, RouteDTO.class));
		});
		return routeDTOs;
	}

}
