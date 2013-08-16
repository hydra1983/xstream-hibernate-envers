package com.thoughtworks.xstream.hibernate.util;

import org.hibernate.envers.entities.mapper.relation.lazy.proxy.CollectionProxy;

public class Envers {
	public final static Class ListProxy = loadEnversType("org.hibernate.envers.entities.mapper.relation.lazy.proxy.ListProxy");
	public final static Class SetProxy = loadEnversType("org.hibernate.envers.entities.mapper.relation.lazy.proxy.SetProxy");
	public final static Class MapProxy = loadEnversType("org.hibernate.envers.entities.mapper.relation.lazy.proxy.MapProxy");
	public final static Class SortedMapProxy = loadEnversType("org.hibernate.envers.entities.mapper.relation.lazy.proxy.SortedMapProxy");
	public final static Class SortedSetProxy = loadEnversType("org.hibernate.envers.entities.mapper.relation.lazy.proxy.SortedSetProxy");

	private static Class loadEnversType(String name) {
		Class type = null;
		try {
			try {
				type = CollectionProxy.class.getClassLoader().loadClass(name);
			} catch (ClassNotFoundException e) {
				type = CollectionProxy.class.getClassLoader().loadClass(name.replaceFirst("\\.internal\\.", "."));
			}
		} catch (ClassNotFoundException e) {
			// not available
		}
		return type;
	}
}
