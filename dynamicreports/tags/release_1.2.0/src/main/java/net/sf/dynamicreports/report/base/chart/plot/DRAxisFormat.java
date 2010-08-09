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
package net.sf.dynamicreports.report.base.chart.plot;

import java.awt.Color;

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisFormat;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRAxisFormat implements DRIAxisFormat {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private DRISimpleExpression<String> labelExpression;
	private DRFont labelFont;
	private Color labelColor;
	private DRFont tickLabelFont;
	private Color tickLabelColor;
	private String tickLabelMask;
	private Double tickLabelRotation;
	private Color lineColor;
	private DRISimpleExpression<? extends Number> rangeMinValueExpression;
	private DRISimpleExpression<? extends Number> rangeMaxValueExpression;
	
	public DRISimpleExpression<String> getLabelExpression() {
		return labelExpression;
	}

	public void setLabelExpression(DRISimpleExpression<String> labelExpression) {
		this.labelExpression = labelExpression;
	}

	public DRFont getLabelFont() {
		return labelFont;
	}

	public void setLabelFont(DRFont labelFont) {
		this.labelFont = labelFont;
	}

	public Color getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(Color labelColor) {
		this.labelColor = labelColor;
	}

	public DRFont getTickLabelFont() {
		return tickLabelFont;
	}

	public void setTickLabelFont(DRFont tickLabelFont) {
		this.tickLabelFont = tickLabelFont;
	}

	public Color getTickLabelColor() {
		return tickLabelColor;
	}

	public void setTickLabelColor(Color tickLabelColor) {
		this.tickLabelColor = tickLabelColor;
	}

	public String getTickLabelMask() {
		return tickLabelMask;
	}

	public void setTickLabelMask(String tickLabelMask) {
		this.tickLabelMask = tickLabelMask;
	}

	public Double getTickLabelRotation() {
		return tickLabelRotation;
	}
	
	public void setTickLabelRotation(Double tickLabelRotation) {
		this.tickLabelRotation = tickLabelRotation;
	}
	
	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public void setRangeMinValueExpression(DRISimpleExpression<? extends Number> rangeMinValueExpression) {
		this.rangeMinValueExpression = rangeMinValueExpression;
	}

	public DRISimpleExpression<? extends Number> getRangeMinValueExpression() {
		return rangeMinValueExpression;
	}

	public void setRangeMaxValueExpression(DRISimpleExpression<? extends Number> rangeMaxValueExpression) {
		this.rangeMaxValueExpression = rangeMaxValueExpression;
	}

	public DRISimpleExpression<? extends Number> getRangeMaxValueExpression() {
		return rangeMaxValueExpression;
	}
}