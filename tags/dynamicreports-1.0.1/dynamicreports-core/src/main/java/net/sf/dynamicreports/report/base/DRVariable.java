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

package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.definition.DRIVariable;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRVariable<T> implements DRIVariable<T> {	
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private String name;
	private DRIExpression<?> expression;
	private Calculation calculation;
	private Evaluation resetType;
	private DRGroup resetGroup;	
	
	public DRVariable(DRIExpression<?> expression, Calculation calculation) {
		this(ReportUtils.generateUniqueName("variable"), expression, calculation);
	}
	
	public DRVariable(String name, DRIExpression<?> expression, Calculation calculation) {
		Validate.notEmpty(name, "name must not be empty");
		Validate.notNull(expression, "expression must not be null");
		Validate.notNull(calculation, "calculation must not be null");
		this.name = name;
		this.expression = expression;
		this.calculation = calculation;
	}
	
	public String getName() {
		return name;
	}
	
	public Calculation getCalculation() {
		return calculation;
	}
	
	public Evaluation getResetType() {
		return resetType;
	}
	
	public void setResetType(Evaluation resetType) {
		this.resetType = resetType;
	}
	
	public DRGroup getResetGroup() {
		return resetGroup;
	}
	
	public void setResetGroup(DRGroup resetGroup) {
		this.resetGroup = resetGroup;
	}	
	
	public DRIExpression<?> getExpression() {
		return expression;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getValueClass() {
		return (Class<T>) ReportUtils.getVariableValueClass(getCalculation(), expression.getValueClass());
	}
}
