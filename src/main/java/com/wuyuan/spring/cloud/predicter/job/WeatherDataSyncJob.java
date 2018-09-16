
package com.wuyuan.spring.cloud.predicter.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.wuyuan.spring.cloud.predicter.entity.City;
import com.wuyuan.spring.cloud.predicter.service.CityDataService;
import com.wuyuan.spring.cloud.predicter.service.WeatherDataService;

/**
 * @author Mawubin
 *
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	//private final static Logger logger= (Logger) LoggerFactory.getLogger(WeatherDataSyncJob.class);
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Autowired
	CityDataService citydata;
	@Autowired
	WeatherDataService weatherdataservice;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	// TODO Auto-generated method stub
	//	logger.info("weather data job");
		//System.out.println("weatherdatjob");
		List<City> listcity=null;
		try {
			listcity=citydata.listCity();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(City city : listcity)
		{
			String cityID=city.getCityID();
			System.out.println("Weather data sync:"+cityID);
			weatherdataservice.syncDataByCityID(cityID);
		}
		
		System.out.println("sync weather data END");
	}
}
