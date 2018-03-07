package com.cissst.software.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.TravelTailerDao;
import com.cissst.software.model.TravelTailer;
import com.cissst.software.service.ITravelTailerService;

@Service(value="travelTailerServiceImpl")
public class TravelTailerServiceImpl implements ITravelTailerService {
	@Autowired
	private TravelTailerDao travelTailerdao;
	@Override
	public void addTravelTailer(TravelTailer traveltailer) {
		
		travelTailerdao.save(traveltailer);
	}

}
