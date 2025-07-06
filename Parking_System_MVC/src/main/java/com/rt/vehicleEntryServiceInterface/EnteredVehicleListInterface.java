package com.rt.vehicleEntryServiceInterface;

import java.util.Map;


public interface EnteredVehicleListInterface {

	Map<String, Object> getVehicleListByType(int page, int size, String vehicleType);
	

}
