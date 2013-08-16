package com.thoughtworks.xstream.hibernate.converter;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.TreeMapConverter;
import com.thoughtworks.xstream.hibernate.util.Envers;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

public class EnversSortedMapConverter extends TreeMapConverter {
	public EnversSortedMapConverter(final Mapper mapper) {
		super(mapper);
	}

	public boolean canConvert(final Class type) {
		return type == Envers.SortedMapProxy;
	}

	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {
		throw new ConversionException("Cannot deserialize Envers collection");
	}
}
