package com.thoughtworks.xstream.hibernate.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.thoughtworks.xstream.hibernate.util.Envers;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class EnversMapper extends HibernateMapper{

	final private Map collectionMap = new HashMap();
	
	public EnversMapper(MapperWrapper mapper) {
		super(mapper);
		collectionMap.put(Envers.ListProxy, ArrayList.class);
		collectionMap.put(Envers.MapProxy, HashMap.class);
		collectionMap.put(Envers.SetProxy, HashSet.class);
		collectionMap.put(Envers.SortedMapProxy, TreeMap.class);
		collectionMap.put(Envers.SortedSetProxy, TreeSet.class);
	}

	public Class defaultImplementationOf(final Class clazz) {
		if (collectionMap.containsKey(clazz)) {
			return super.defaultImplementationOf((Class) collectionMap.get(clazz));
		}

		return super.defaultImplementationOf(clazz);
	}

	public String serializedClass(final Class clazz) {
		if (clazz != null) {
			if (collectionMap.containsKey(clazz)) {
				// Pretend this is the underlying collection class and map
				// that instead
				return super.serializedClass((Class) collectionMap.get(clazz));
			}
		}
		return super.serializedClass(clazz);
	}
}
