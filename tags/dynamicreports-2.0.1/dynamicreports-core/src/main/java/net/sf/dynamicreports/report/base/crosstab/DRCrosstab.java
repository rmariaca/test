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

package net.sf.dynamicreports.report.base.crosstab;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.base.style.DRSimpleStyle;
import net.sf.dynamicreports.report.base.style.DRStyle;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstab;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRCrosstab extends DRDimensionComponent implements DRICrosstab {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean repeatColumnHeaders;
	private Boolean repeatRowHeaders;
	private Integer columnBreakOffset;
	private Boolean ignoreWidth;
	private RunDirection runDirection;
	private Integer cellWidth;
	private Integer cellHeight;
	private Boolean highlightOddRows;
	private DRSimpleStyle oddRowStyle;
	private Boolean highlightEvenRows;
	private DRSimpleStyle evenRowStyle;
	private DRStyle groupStyle;
	private DRStyle groupTotalStyle;
	private DRStyle grandTotalStyle;
	private DRStyle cellStyle;
	private DRStyle measureTitleStyle;
	private DRCrosstabCellContent whenNoDataCell;
	private DRCrosstabCellContent headerCell;
	private List<DRICrosstabColumnGroup<?>> columnGroups;
	private List<DRICrosstabRowGroup<?>> rowGroups;
	private List<DRICrosstabVariable<?>> variables;
	private List<DRICrosstabMeasure<?>> measures;

	@Override
	protected void init() {
		super.init();
		columnGroups = new ArrayList<DRICrosstabColumnGroup<?>>();
		rowGroups = new ArrayList<DRICrosstabRowGroup<?>>();
		variables = new ArrayList<DRICrosstabVariable<?>>();
		measures = new ArrayList<DRICrosstabMeasure<?>>();

		whenNoDataCell = new DRCrosstabCellContent();
		headerCell = new DRCrosstabCellContent();
	}

	public Boolean isRepeatColumnHeaders() {
		return repeatColumnHeaders;
	}

	public void setRepeatColumnHeaders(Boolean repeatColumnHeaders) {
		this.repeatColumnHeaders = repeatColumnHeaders;
	}

	public Boolean isRepeatRowHeaders() {
		return repeatRowHeaders;
	}

	public void setRepeatRowHeaders(Boolean repeatRowHeaders) {
		this.repeatRowHeaders = repeatRowHeaders;
	}

	public Integer getColumnBreakOffset() {
		return columnBreakOffset;
	}

	public void setColumnBreakOffset(Integer columnBreakOffset) {
		this.columnBreakOffset = columnBreakOffset;
	}

	public Boolean getIgnoreWidth() {
		return ignoreWidth;
	}

	public void setIgnoreWidth(Boolean ignoreWidth) {
		this.ignoreWidth = ignoreWidth;
	}

	public RunDirection getRunDirection() {
		return runDirection;
	}

	public void setRunDirection(RunDirection runDirection) {
		this.runDirection = runDirection;
	}

	public DRCrosstabCellContent getWhenNoDataCell() {
		return whenNoDataCell;
	}

	public DRCrosstabCellContent getHeaderCell() {
		return headerCell;
	}

	public List<DRICrosstabColumnGroup<?>> getColumnGroups() {
		return columnGroups;
	}

	public Integer getCellWidth() {
		return cellWidth;
	}

	public void setCellWidth(Integer cellWidth) {
		this.cellWidth = cellWidth;
	}

	public Integer getCellHeight() {
		return cellHeight;
	}

	public void setCellHeight(Integer cellHeight) {
		this.cellHeight = cellHeight;
	}

	public Boolean getHighlightOddRows() {
		return highlightOddRows;
	}

	public void setHighlightOddRows(Boolean highlightOddRows) {
		this.highlightOddRows = highlightOddRows;
	}

	public DRSimpleStyle getOddRowStyle() {
		return oddRowStyle;
	}

	public void setOddRowStyle(DRSimpleStyle oddRowStyle) {
		this.oddRowStyle = oddRowStyle;
	}

	public Boolean getHighlightEvenRows() {
		return highlightEvenRows;
	}

	public void setHighlightEvenRows(Boolean highlightEvenRows) {
		this.highlightEvenRows = highlightEvenRows;
	}

	public DRSimpleStyle getEvenRowStyle() {
		return evenRowStyle;
	}

	public void setEvenRowStyle(DRSimpleStyle evenRowStyle) {
		this.evenRowStyle = evenRowStyle;
	}

	public DRStyle getGroupStyle() {
		return groupStyle;
	}

	public void setGroupStyle(DRStyle groupStyle) {
		this.groupStyle = groupStyle;
	}

	public DRStyle getGroupTotalStyle() {
		return groupTotalStyle;
	}

	public void setGroupTotalStyle(DRStyle groupTotalStyle) {
		this.groupTotalStyle = groupTotalStyle;
	}

	public DRStyle getGrandTotalStyle() {
		return grandTotalStyle;
	}

	public void setGrandTotalStyle(DRStyle grandTotalStyle) {
		this.grandTotalStyle = grandTotalStyle;
	}

	public DRStyle getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(DRStyle cellStyle) {
		this.cellStyle = cellStyle;
	}

	public DRStyle getMeasureTitleStyle() {
		return measureTitleStyle;
	}

	public void setMeasureTitleStyle(DRStyle measureTitleStyle) {
		this.measureTitleStyle = measureTitleStyle;
	}

	public void addColumnGroup(DRICrosstabColumnGroup<?> columnGroup) {
		Validate.notNull(columnGroup, "columnGroup must not be null");
		this.columnGroups.add(columnGroup);
	}

	public List<DRICrosstabRowGroup<?>> getRowGroups() {
		return rowGroups;
	}

	public void addRowGroup(DRICrosstabRowGroup<?> rowGroup) {
		Validate.notNull(rowGroup, "rowGroup must not be null");
		this.rowGroups.add(rowGroup);
	}

	public List<DRICrosstabVariable<?>> getVariables() {
		return variables;
	}

	public void addVariable(DRICrosstabVariable<?> variable) {
		Validate.notNull(variable, "variable must not be null");
		this.variables.add(variable);
	}

	public List<DRICrosstabMeasure<?>> getMeasures() {
		return measures;
	}

	public void addMeasure(DRICrosstabMeasure<?> measure) {
		Validate.notNull(measure, "measure must not be null");
		this.measures.add(measure);
	}
}