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
package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.definition.DRIPage;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRPage implements DRIPage {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private Integer width;
	private Integer height;
	private PageOrientation orientation;
	private DRMargin margin;
	private Integer columnsPerPage;
	private Integer columnSpace;
	
	public void setPageFormat(PageType pageType, PageOrientation orientation) {
		Validate.notNull(pageType, "pageType must not be null");
		Validate.notNull(orientation, "orientation must not be null");		
		if (orientation.equals(PageOrientation.PORTRAIT)) {
			setWidth(pageType.getWidth());
			setHeight(pageType.getHeight());
		}
		else {
			setWidth(pageType.getHeight());
			setHeight(pageType.getWidth());
		}
		setOrientation(orientation);
	}
	
  /**
   * Returns the page width.
   *
   * @return the page width >= 1
   */
	public Integer getWidth() {
		return width;
	}

  /**
   * Sets the page width. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param width the page width >= 1
   * @exception IllegalArgumentException if <code>width</code> is < 1
   */
	private void setWidth(Integer width) {
		if (width != null) {
			Validate.isTrue(width >= 1, "width must be >= 1");
		}
		this.width = width;
	}

  /**
   * Returns the page height.
   *
   * @return the page height >= 1
   */
	public Integer getHeight() {
		return height;
	}

  /**
   * Sets the page height. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the page height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	private void setHeight(Integer height) {
		if (height != null) {
			Validate.isTrue(height >= 1, "height must be >= 1");
		}
		this.height = height;
	}

	public PageOrientation getOrientation() {
		return orientation;
	}

	private void setOrientation(PageOrientation orientation) {
		this.orientation = orientation;
	}

	public DRMargin getMargin() {
		return margin;
	}

	public void setMargin(DRMargin margin) {
		this.margin = margin;
	}

	public Integer getColumnsPerPage() {
		return columnsPerPage;
	}

	public void setColumnsPerPage(Integer columnsPerPage) {
		if (columnsPerPage != null) {
			Validate.isTrue(columnsPerPage >= 1, "columnsPerPage must be >= 1");
		}
		this.columnsPerPage = columnsPerPage;
	}

	public Integer getColumnSpace() {
		return columnSpace;
	}

	public void setColumnSpace(Integer columnSpace) {
		if (columnSpace != null) {
			Validate.isTrue(columnSpace >= 0, "columnSpace must be >= 0");
		}
		this.columnSpace = columnSpace;
	}
}