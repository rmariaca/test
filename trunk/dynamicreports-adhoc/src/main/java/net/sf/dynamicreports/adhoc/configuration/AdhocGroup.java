/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2012 Ricardo Mariaca
 * http://dynamicreports.sourceforge.net
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

package net.sf.dynamicreports.adhoc.configuration;

import java.util.Properties;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class AdhocGroup {
	private String name;
	private Boolean startInNewPage;
	private AdhocGroupHeaderLayout layout;
	private AdhocStyle style;
	private AdhocStyle titleStyle;
	private Properties properties;

	public AdhocGroup() {
		properties = new Properties();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStartInNewPage() {
		return startInNewPage;
	}

	public void setStartInNewPage(Boolean startInNewPage) {
		this.startInNewPage = startInNewPage;
	}

	public AdhocGroupHeaderLayout getLayout() {
		return layout;
	}

	public void setLayout(AdhocGroupHeaderLayout layout) {
		this.layout = layout;
	}

	public AdhocStyle getStyle() {
		return style;
	}

	public void setStyle(AdhocStyle style) {
		this.style = style;
	}

	public AdhocStyle getTitleStyle() {
		return titleStyle;
	}

	public void setTitleStyle(AdhocStyle titleStyle) {
		this.titleStyle = titleStyle;
	}

	public Properties getProperties() {
		return properties;
	}

	public void getProperty(String key) {
		this.properties.getProperty(key);
	}

	public void addProperty(String key, String value) {
		this.properties.setProperty(key, value);
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
