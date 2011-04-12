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

package net.sf.dynamicreports.report.definition.chart.plot;

import java.awt.Color;
import java.io.Serializable;

import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import net.sf.dynamicreports.report.definition.style.DRIFont;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public interface DRIAxisFormat extends Serializable {
	
	public DRISimpleExpression<String> getLabelExpression();

	public DRIFont getLabelFont();

	public Color getLabelColor();

	public DRIFont getTickLabelFont();

	public Color getTickLabelColor();

	public String getTickLabelMask();

	public Double getTickLabelRotation();
	
	public Color getLineColor();

	public DRISimpleExpression<? extends Number> getRangeMinValueExpression();

	public DRISimpleExpression<? extends Number> getRangeMaxValueExpression();
}
