package com.thoughtworks.xstream.hibernate.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.hibernate.converter.EnversCollectionConverter;
import com.thoughtworks.xstream.hibernate.converter.EnversMapConverter;
import com.thoughtworks.xstream.hibernate.converter.EnversSortedMapConverter;
import com.thoughtworks.xstream.hibernate.converter.EnversSortedSetConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentCollectionConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentMapConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedMapConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedSetConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernateProxyConverter;
import com.thoughtworks.xstream.hibernate.mapper.EnversMapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class EnversXstream {
	public static XStream create() {
		XStream xstream = new XStream() {
			protected MapperWrapper wrapMapper(final MapperWrapper next) {
				return new EnversMapper(next);
			}
		};

		xstream.registerConverter(new HibernateProxyConverter());

		xstream.registerConverter(new HibernatePersistentCollectionConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedSetConverter(xstream.getMapper()));

		xstream.registerConverter(new EnversCollectionConverter(xstream.getMapper()));
		xstream.registerConverter(new EnversMapConverter(xstream.getMapper()));
		xstream.registerConverter(new EnversSortedSetConverter(xstream.getMapper()));
		xstream.registerConverter(new EnversSortedMapConverter(xstream.getMapper()));
		
		return xstream;
	}
}
