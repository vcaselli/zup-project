package br.com.victorcaselli.projetozup.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.victorcaselli.projetozup.entities.enums.WeeklyRotation;

public class WeeklyRotationHandler {
	
	
	private static Map<List<Integer>, WeeklyRotation> weeklyRotationList = new HashMap<>(); 
	private static Map<WeeklyRotation, Integer> daysOfWeek = new HashMap<>();
	private static Calendar cal = Calendar.getInstance();
	
	private static void generateWeeklyRotationList() { 
		weeklyRotationList.put(Arrays.asList(0,1), WeeklyRotation.MONDAY);
		weeklyRotationList.put(Arrays.asList(2,3), WeeklyRotation.TUESDAY);
		weeklyRotationList.put(Arrays.asList(4,5), WeeklyRotation.WEDNESDAY);
		weeklyRotationList.put(Arrays.asList(6,7), WeeklyRotation.THURSDAY);
		weeklyRotationList.put(Arrays.asList(8,9), WeeklyRotation.FRIDAY);
	}
	
	private static void generateDaysOfWeek() { 
		daysOfWeek.put(WeeklyRotation.MONDAY, Calendar.MONDAY);
		daysOfWeek.put(WeeklyRotation.TUESDAY, Calendar.TUESDAY);
		daysOfWeek.put(WeeklyRotation.WEDNESDAY, Calendar.WEDNESDAY);
		daysOfWeek.put(WeeklyRotation.THURSDAY, Calendar.THURSDAY);
		daysOfWeek.put(WeeklyRotation.FRIDAY, Calendar.FRIDAY);
	}
	

	
	public static Integer getWeeklyRotationByModelYear(Integer modelYear) { 
		generateWeeklyRotationList();
		Character year = modelYear.toString().charAt(3);
		for(List<Integer> list : weeklyRotationList.keySet()) { 
			if(list.contains(Integer.parseInt(year.toString()))){ 
				return weeklyRotationList.get(list).getCode();
			}
		}
		throw new IllegalArgumentException("AnoModelo inválido");
	}
	
	
	public static Boolean onDayOfWeek(WeeklyRotation wr) { 
		generateDaysOfWeek();
		Integer dayOfWeek = daysOfWeek.get(wr);
		if(dayOfWeek.equals(cal.get(Calendar.DAY_OF_WEEK))) {
			return true; 
		}
		
		return false;
	}
	

}
