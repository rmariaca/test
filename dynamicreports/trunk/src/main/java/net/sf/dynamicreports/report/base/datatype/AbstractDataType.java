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
package net.sf.dynamicreports.report.base.datatype;

import java.util.Locale;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings("ucd")
public abstract class AbstractDataType<U, T extends U> implements DRIDataType<U, T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	public String getPattern() {
		return null;
	}
	
	public DRIValueFormatter<?, ? extends U> getValueFormatter() {
		return null;
	}

	public HorizontalAlignment getHorizontalAlignment() {
		return null;
	}
	
	public String valueToString(U value, Locale locale) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}

	public String valueToString(DRIValue<? extends U> value, ReportParameters reportParameters) {
		return valueToString((U) reportParameters.getValue(value), reportParameters.getLocale());
	}

	@SuppressWarnings("unchecked")
	public String valueToString(String name, ReportParameters reportParameters) {
		return valueToString((U) reportParameters.getValue(name), reportParameters.getLocale());
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getValueClass() {
		return (Class<T>) ReportUtils.getGenericClass(this, 1);
	}
}
