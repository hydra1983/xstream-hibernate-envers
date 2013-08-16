package com.thoughtworks.xstream.hibernate.converter;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
import com.thoughtworks.xstream.hibernate.util.Envers;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

public class EnversSortedSetConverter extends TreeSetConverter {
	public EnversSortedSetConverter(final Mapper mapper) {
		super(mapper);
	}

	public boolean canConvert(final Class type) {
		return type == Envers.SortedSetProxy;
	}

	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {
		throw new ConversionException("Cannot deserialize Envers collection");
	}
}
