package com.thoughtworks.xstream.hibernate.converter;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.hibernate.util.Envers;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

public class EnversCollectionConverter extends CollectionConverter {
	public EnversCollectionConverter(final Mapper mapper) {
		super(mapper);
	}

	public boolean canConvert(final Class type) {
		return type == Envers.ListProxy || type == Envers.SetProxy;
	}

	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {
		throw new ConversionException("Cannot deserialize Envers collection");
	}
}
