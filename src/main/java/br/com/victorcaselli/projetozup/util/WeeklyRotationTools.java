package br.com.victorcaselli.projetozup.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.victorcaselli.projetozup.entities.enums.WeeklyRotation;

public class WeeklyRotationTools {
	
	
	private static Map<List<Integer>, WeeklyRotation> weeklyRotationList = new HashMap<>(); 
	
	
	private static void generateWeeklyRotationList() { 
		weeklyRotationList.put(Arrays.asList(0,1), WeeklyRotation.MONDAY);
		weeklyRotationList.put(Arrays.asList(2,3), WeeklyRotation.TUESDAY);
		weeklyRotationList.put(Arrays.asList(4,5), WeeklyRotation.WEDNESDAY);
		weeklyRotationList.put(Arrays.asList(6,7), WeeklyRotation.THURSDAY);
		weeklyRotationList.put(Arrays.asList(8,9), WeeklyRotation.FRIDAY);
	}
	
	public static Integer getWeeklyRotationByModelYear(Integer modelYear) { 
		WeeklyRotationTools.generateWeeklyRotationList();
		Character year = modelYear.toString().charAt(3);
		for(List<Integer> list : weeklyRotationList.keySet()) { 
			if(list.contains(Integer.parseInt(year.toString()))){ 
				return weeklyRotationList.get(list).getCode();
			}
		}
		throw new IllegalArgumentException("AnoModelo inválido");
	}

}
