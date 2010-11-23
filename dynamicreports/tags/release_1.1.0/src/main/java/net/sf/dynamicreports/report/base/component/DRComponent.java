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
package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.base.style.DRStyle;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public abstract class DRComponent implements DRIComponent {	
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRStyle style;
	private DRISimpleExpression<Boolean> printWhenExpression;

	public DRComponent() {
		init();
	}
	
	protected void init() {		
	}
	
	public DRStyle getStyle() {
		return style;
	}
	
	public void setStyle(DRStyle style) {
		this.style = style;
	}
	
	public DRISimpleExpression<Boolean> getPrintWhenExpression() {
		return printWhenExpression;
	}
	
	public void setPrintWhenExpression(DRISimpleExpression<Boolean> printWhenExpression) {
		this.printWhenExpression = printWhenExpression;
	}	
}