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
package net.sf.dynamicreports.design.base.chart;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignChartDataset;
import net.sf.dynamicreports.design.base.chart.plot.AbstractDesignPlot;
import net.sf.dynamicreports.design.base.component.DRDesignHyperlinkComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChart;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRDesignChart extends DRDesignHyperlinkComponent implements DRIDesignChart {		
	private ChartType chartType;
	private DRDesignChartDataset dataset;
	private AbstractDesignPlot plot;
	private DRIChartCustomizer customizer;
	private DRDesignChartTitle title;
	private DRDesignChartSubtitle subtitle;
	private DRDesignChartLegend legend;	
	private EvaluationTime evaluationTime;
	private DRDesignGroup evaluationGroup;
	
	public DRDesignChart() {
		super("chart");
	}
	
	public ChartType getChartType() {
		return chartType;
	}

	public void setChartType(ChartType chartType) {
		this.chartType = chartType;
	}
	
	public DRDesignChartDataset getDataset() {
		return dataset;
	}

	public void setDataset(DRDesignChartDataset dataset) {
		this.dataset = dataset;
	}
	
	public AbstractDesignPlot getPlot() {
		return plot;
	}

	public void setPlot(AbstractDesignPlot plot) {
		this.plot = plot;
	}

	public DRIChartCustomizer getCustomizer() {
		return customizer;
	}
	
	public void setCustomizer(DRIChartCustomizer customizer) {
		this.customizer = customizer;
	}

	public DRDesignChartTitle getTitle() {
		return title;
	}

	public void setTitle(DRDesignChartTitle title) {
		this.title = title;
	}

	public DRDesignChartSubtitle getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(DRDesignChartSubtitle subtitle) {
		this.subtitle = subtitle;
	}

	public DRDesignChartLegend getLegend() {
		return legend;
	}

	public void setLegend(DRDesignChartLegend legend) {
		this.legend = legend;
	}	
	
	public EvaluationTime getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(EvaluationTime evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	public DRDesignGroup getEvaluationGroup() {
		return evaluationGroup;
	}

	public void setEvaluationGroup(DRDesignGroup evaluationGroup) {
		this.evaluationGroup = evaluationGroup;
	}
}
