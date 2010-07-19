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
package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignPage;
import net.sf.dynamicreports.report.constant.PageOrientation;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRDesignPage implements DRIDesignPage {
	private int width;
	private int height;
	private PageOrientation orientation;
	private DRDesignMargin margin;
	private int columnsPerPage;
	private int columnSpace;
	private int columnWidth;
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public PageOrientation getOrientation() {
		return orientation;
	}
	
	public void setOrientation(PageOrientation orientation) {
		this.orientation = orientation;
	}
	
	public DRDesignMargin getMargin() {
		return margin;
	}
	
	public void setMargin(DRDesignMargin margin) {
		this.margin = margin;
	}
	
	public int getColumnsPerPage() {
		return columnsPerPage;
	}
	
	public void setColumnsPerPage(int columnsPerPage) {
		this.columnsPerPage = columnsPerPage;
	}
	
	public int getColumnSpace() {
		return columnSpace;
	}
	
	public void setColumnSpace(int columnSpace) {
		this.columnSpace = columnSpace;
	}
	
	public int getColumnWidth() {
		return columnWidth;
	}
	
	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}	
}
