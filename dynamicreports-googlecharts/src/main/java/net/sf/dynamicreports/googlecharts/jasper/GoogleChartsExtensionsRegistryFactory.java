/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2016 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.googlecharts.jasper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapCompiler;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapComponent;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapElementHtmlHandler;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapFillFactory;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapPrintElement;
import net.sf.dynamicreports.googlecharts.report.geomap.GeoMapTransform;
import net.sf.dynamicreports.report.component.CustomComponentTransform;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.component.ComponentManager;
import net.sf.jasperreports.engine.component.ComponentsBundle;
import net.sf.jasperreports.engine.component.DefaultComponentManager;
import net.sf.jasperreports.engine.component.DefaultComponentXmlParser;
import net.sf.jasperreports.engine.component.DefaultComponentsBundle;
import net.sf.jasperreports.engine.export.GenericElementHandlerBundle;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GoogleChartsExtensionsRegistryFactory implements ExtensionsRegistryFactory {
	public static final String NAMESPACE = "http://www.dynamicreports.org/googlecharts";
	public static final String XSD_LOCATION = "http://www.dynamicreports.org/xsd/googlecharts.xsd";
	public static final String XSD_RESOURCE = "net/sf/dynamicreports/googlecharts/jasper/googlecharts.xsd";

	private static final ExtensionsRegistry REGISTRY;

	static {
		final DefaultComponentsBundle bundle = new DefaultComponentsBundle();
		final GoogleChartsHandler handler = new GoogleChartsHandler();
		final List<CustomComponentTransform<?, ?>> transforms = new ArrayList<CustomComponentTransform<?, ?>>();

		GoogleChartsDesignConverter designConverter = new GoogleChartsDesignConverter();

		DefaultComponentXmlParser parser = new DefaultComponentXmlParser();
		parser.setNamespace(NAMESPACE);
		parser.setPublicSchemaLocation(XSD_LOCATION);
		parser.setInternalSchemaResource(XSD_RESOURCE);
		parser.setDigesterConfigurer(handler);
		bundle.setXmlParser(parser);

		HashMap<String, ComponentManager> componentManagers = new HashMap<String, ComponentManager>();
		bundle.setComponentManagers(componentManagers);

		REGISTRY = new ExtensionsRegistry() {
			@Override
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public List getExtensions(Class extensionType) {
				if (ComponentsBundle.class.equals(extensionType)) {
					return Collections.singletonList(bundle);
				}
				if (GenericElementHandlerBundle.class.equals(extensionType)) {
					return Collections.singletonList(handler);
				}
				if (CustomComponentTransform.class.equals(extensionType)) {
					return transforms;
				}
				return null;
			}
		};

		//geoMap
		handler.add(GeoMapPrintElement.GEOMAP_ELEMENT_NAME, GeoMapComponent.class, new GeoMapElementHtmlHandler());
		DefaultComponentManager geoMapManager = new DefaultComponentManager();
		geoMapManager.setDesignConverter(designConverter);
		geoMapManager.setComponentCompiler(new GeoMapCompiler());
		geoMapManager.setComponentXmlWriter(handler);
		geoMapManager.setComponentFillFactory(new GeoMapFillFactory());
		componentManagers.put(GeoMapPrintElement.GEOMAP_ELEMENT_NAME, geoMapManager);
		transforms.add(new GeoMapTransform());
	}

	@Override
	public ExtensionsRegistry createRegistry(String registryId, JRPropertiesMap properties) {
		return REGISTRY;
	}
}