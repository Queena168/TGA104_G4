package com.tibame.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

	public <T> List<T> objToList(Object obj, Class<T> cla) throws Exception{
		List<T> list = new ArrayList<T>();
    	if (obj instanceof ArrayList<?>) {
	        for (Object o : (List<?>) obj) {
	            list.add(cla.cast(o));
	        }
	        return list;
        }
        return null;
	}

}
