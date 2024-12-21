package com.hexaware.fastx.service;

import java.util.List;

import com.hexaware.fastx.dto.RouteDTO;
import com.hexaware.fastx.model.Route;

public interface IRouteService {
	
	public RouteDTO addRoute(Route route, String busNumber) throws Exception;
	public List<RouteDTO> getAllRoutes(String departDate, String source, String destination);
	public List<RouteDTO> getEveryRoute();
}
