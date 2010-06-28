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
package net.sf.dynamicreports.jasper.builder.export;

import java.util.List;

import net.sf.dynamicreports.jasper.base.export.AbstractJasperExcelExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings({"unchecked", "ucd"})
public abstract class AbstractJasperExcelExporterBuilder<T extends AbstractJasperExcelExporterBuilder<T, U>, U extends AbstractJasperExcelExporter> extends AbstractJasperExporterBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	protected AbstractJasperExcelExporterBuilder(U exporter) {
		super(exporter);
	}	
	
	public T setOnePagePerSheet(Boolean onePagePerSheet) {
		this.getObject().setOnePagePerSheet(onePagePerSheet);
		return (T) this;
	}
	
	public T setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
		this.getObject().setRemoveEmptySpaceBetweenRows(removeEmptySpaceBetweenRows);
		return (T) this;
	}
	
	public T setRemoveEmptySpaceBetweenColumns(Boolean removeEmptySpaceBetweenColumns) {
		this.getObject().setRemoveEmptySpaceBetweenColumns(removeEmptySpaceBetweenColumns);
		return (T) this;
	}
	
	public T setWhitePageBackground(Boolean whitePageBackground) {
		this.getObject().setWhitePageBackground(whitePageBackground);
		return (T) this;
	}
	
	public T setDetectCellType(Boolean detectCellType) {
		this.getObject().setDetectCellType(detectCellType);
		return (T) this;
	}
	
	public T setSheetNames(List<String> sheetNames) {
		this.getObject().setSheetNames(sheetNames);
		return (T) this;
	}
	
	public T setFontSizeFixEnabled(Boolean fontSizeFixEnabled) {
		this.getObject().setFontSizeFixEnabled(fontSizeFixEnabled);
		return (T) this;
	}
	
	public T setImageBorderFixEnabled(Boolean imageBorderFixEnabled) {
		this.getObject().setImageBorderFixEnabled(imageBorderFixEnabled);
		return (T) this;
	}
	
	public T setMaxRowsPerSheet(Integer maxRowsPerSheet) {
		this.getObject().setMaxRowsPerSheet(maxRowsPerSheet);
		return (T) this;
	}
	
	public T setIgnoreGraphics(Boolean ignoreGraphics) {
		this.getObject().setIgnoreGraphics(ignoreGraphics);
		return (T) this;
	}
	
	public T setCollapseRowSpan(Boolean collapseRowSpan) {
		this.getObject().setCollapseRowSpan(collapseRowSpan);
		return (T) this;
	}
	
	public T setIgnoreCellBorder(Boolean ignoreCellBorder) {
		this.getObject().setIgnoreCellBorder(ignoreCellBorder);
		return (T) this;
	}
	
	public T setIgnoreCellBackground(Boolean ignoreCellBackground) {
		this.getObject().setIgnoreCellBackground(ignoreCellBackground);
		return (T) this;
	}
	
	public T setPassword(String password) {
		this.getObject().setPassword(password);
		return (T) this;
	}	
}
