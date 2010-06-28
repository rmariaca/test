/* Dynamic reports - Free Java reporting library for creating reports dynamically
 *
 * (C) Copyright 2010 Ricardo Mariaca
 *
 * http://dynamicreports.sourceforge.net
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 3 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, 
 * USA. 
 */
package net.sf.dynamicreports.report.builder.grid;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class Grids {
	
	//horizontal
	public static HorizontalColumnGridListBuilder horizontalColumnGridList() {
		return new HorizontalColumnGridListBuilder();
	}

	public static HorizontalColumnGridListBuilder horizontalColumnGridList(ColumnGridComponentBuilder ...components) {
		return new HorizontalColumnGridListBuilder().add(components);
	}

	public static HorizontalColumnGridListBuilder horizontalColumnGridList(HorizontalColumnGridListCellBuilder ...cells) {
		return new HorizontalColumnGridListBuilder().add(cells);
	}
	
	public static HorizontalColumnGridListCellBuilder hColumnGridListCell(ColumnGridComponentBuilder component) {
		Validate.notNull(component, "component must not be null");
		return new HorizontalColumnGridListCellBuilder(component);
	}
	
	//horizontal flow
	public static HorizontalColumnGridListBuilder horizontalFlowColumnGridList() {
		return new HorizontalFlowColumnGridListBuilder();
	}

	public static HorizontalColumnGridListBuilder horizontalFlowColumnGridList(ColumnGridComponentBuilder ...components) {
		return new HorizontalFlowColumnGridListBuilder().add(components);
	}

	public static HorizontalColumnGridListBuilder horizontalFlowColumnGridList(HorizontalColumnGridListCellBuilder ...cells) {
		return new HorizontalFlowColumnGridListBuilder().add(cells);
	}
	
	//vertical	
	public static VerticalColumnGridListBuilder verticalColumnGridList() {
		return new VerticalColumnGridListBuilder();
	}

	public static VerticalColumnGridListBuilder verticalColumnGridList(ColumnGridComponentBuilder ...components) {
		return new VerticalColumnGridListBuilder().add(components);
	}

	public static VerticalColumnGridListBuilder verticalColumnGridList(VerticalColumnGridListCellBuilder ...cells) {
		return new VerticalColumnGridListBuilder().add(cells);
	}
	
	public static VerticalColumnGridListCellBuilder vColumnGridListCell(ColumnGridComponentBuilder component) {
		Validate.notNull(component, "component must not be null");
		return new VerticalColumnGridListCellBuilder(component);
	}
}
