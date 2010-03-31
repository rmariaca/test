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
package net.sf.dynamicreports.report.base.grid;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridList;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRColumnGridList implements DRIColumnGridList {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private List<DRColumnGridListCell> listCells;
	private ListType type;	
	private int gap;

	public DRColumnGridList() {
		this(ListType.HORIZONTAL);
	}

	public DRColumnGridList(ListType type) {
		setType(type);
		this.listCells = new ArrayList<DRColumnGridListCell>();
	}
	
	public List<DRColumnGridListCell> getListCells() {
		return listCells;
	}
	
	public void addComponent(DRIColumnGridComponent component) {
		listCells.add(new DRColumnGridListCell(component));
	}
		
	public void addCell(DRColumnGridListCell cell) {
		Validate.notNull(cell, "cell must not be null");
		listCells.add(cell);
	}

	@SuppressWarnings("ucd")
	public void addComponent(HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment, DRIColumnGridComponent component) {
		listCells.add(new DRColumnGridListCell(horizontalAlignment, verticalAlignment, component));
	}
	
	public void setType(ListType type) {
		Validate.notNull(type, "type must not be null");
		this.type = type;
	}
	
	public ListType getType() {
		return type;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		Validate.notNull(gap < 0, "gap must be >= 0");
		this.gap = gap;
	}	
}
