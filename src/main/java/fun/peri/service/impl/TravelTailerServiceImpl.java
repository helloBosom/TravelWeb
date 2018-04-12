package fun.peri.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.peri.dao.TravelTailerDao;
import fun.peri.model.TravelTailer;
import fun.peri.service.ITravelTailerService;

@Service(value="travelTailerServiceImpl")
public class TravelTailerServiceImpl implements ITravelTailerService {
	@Autowired
	private TravelTailerDao travelTailerdao;
	@Override
	public void addTravelTailer(TravelTailer traveltailer) {
		
		travelTailerdao.save(traveltailer);
	}

}
