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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.dataset.DRChartDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRPiePlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings({"unchecked", "ucd"})
public abstract class AbstractPieChartBuilder<T extends AbstractPieChartBuilder<T, U>, U extends DRPiePlot> extends AbstractChartBuilder<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	protected AbstractPieChartBuilder(ChartType chartType) {
		super(chartType);
	}

	//dataset
	public T setKey(ColumnBuilder<?, String> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setValueExpression(column.getColumn());
		return (T) this;
	}

	public T setKey(String fieldName, Class<String> valueClass) {
		return setKey(DynamicReports.field(fieldName, valueClass));
	}
	
	public T setKey(FieldBuilder<String> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setValueExpression(field.build());
		return (T) this;
	}
	
	public T setKey(DRISimpleExpression<String> expression) {
		getDataset().setValueExpression(expression);
		return (T) this;
	}

	public T series(ChartSerieBuilder ...chartSeries) {
		return addSerie(chartSeries);
	}

	public T addSerie(ChartSerieBuilder ...chartSeries) {
		Validate.notNull(chartSeries, "chartSeries must not be null");
		Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
		for (ChartSerieBuilder chartSerie : chartSeries) {
			getDataset().addSerie(chartSerie.build());
		}		
		return (T) this;
	}
	
	//plot
	public T setCircular(Boolean circular) {
		getPlot().setCircular(circular);
		return (T) this;
	}

	public T setLabelFormat(String labelFormat) {
		getPlot().setLabelFormat(labelFormat);
		return (T) this;
	}

	public T setLegendLabelFormat(String legendLabelFormat) {
		getPlot().setLegendLabelFormat(legendLabelFormat);
		return (T) this;
	}
	
	private DRChartDataset getDataset() {
		return getObject().getDataset();
	}
	
	protected U getPlot() {
		return (U) getObject().getPlot();
	}
}
