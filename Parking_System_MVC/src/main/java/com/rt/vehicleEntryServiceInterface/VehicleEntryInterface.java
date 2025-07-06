package com.rt.vehicleEntryServiceInterface;

import com.rt.vehicleEntryDTO.add.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.add.RespAddVehicleDto;
import com.rt.vehicleEntryDTO.select.RespFetchVehicleInfo;

public interface VehicleEntryInterface {
	
	RespAddVehicleDto addVehicleInfo(ReqAddVehicleDto reqAddVehicleDto);
	
	RespFetchVehicleInfo fetchVehicleData(int id);

}
