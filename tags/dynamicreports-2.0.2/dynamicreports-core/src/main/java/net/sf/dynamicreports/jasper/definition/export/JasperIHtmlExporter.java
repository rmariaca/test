/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2011 Ricardo Mariaca
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

package net.sf.dynamicreports.jasper.definition.export;

import net.sf.dynamicreports.jasper.constant.SizeUnit;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public interface JasperIHtmlExporter extends JasperIExporter {
	
	public Boolean getOutputImagesToDir();
	
	public String getImagesDirName();
	
	public String getImagesURI();
	
	public String getHtmlHeader();
	
	public String getBetweenPagesHtml();
	
	public String getHtmlFooter();
	
	public Boolean getRemoveEmptySpaceBetweenRows();
	
	public Boolean getWhitePageBackground();
	
	public Boolean getUsingImagesToAlign();
	
	public Boolean getWrapBreakWord();
	
	public SizeUnit getSizeUnit();
	
	public Boolean getFramesAsNestedTables();	
}