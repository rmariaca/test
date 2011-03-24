/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 Ricardo Mariaca
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

package net.sf.dynamicreports.report.builder.expression;

import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings("ucd")
public class ValueExpression<T> extends AbstractSimpleExpression<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private T value;
	private Class<? super T> valueClass;

	public ValueExpression(T value) {
		this(value, null);		
	}

	@SuppressWarnings("unchecked")
	public ValueExpression(T value, Class<? super T> valueClass) {
		this.value = value;
		if (valueClass == null) {
			this.valueClass = (Class<? super T>) value.getClass();
		}
		else {
			this.valueClass = valueClass;
		}
	}
	
	public T evaluate(ReportParameters reportParameters) {
		return value;
	}
	
	@Override
	public Class<? super T> getValueClass() {
		return valueClass;
	}
}