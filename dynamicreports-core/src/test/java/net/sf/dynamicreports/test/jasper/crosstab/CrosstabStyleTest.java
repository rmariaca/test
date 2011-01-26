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

package net.sf.dynamicreports.test.jasper.crosstab;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabStyleTest;
import net.sf.dynamicreports.test.jasper.DataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class CrosstabStyleTest extends AbstractJasperCrosstabStyleTest {
	private static final long serialVersionUID = 1L;

	private CrosstabRowGroupBuilder<String> rowGroup;
	private CrosstabColumnGroupBuilder<String> columnGroup;
	private CrosstabMeasureBuilder<Integer> measure1;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		FieldBuilder<String> field1 = field("field1", String.class);
		FieldBuilder<String> field2 = field("field2", String.class);

		StyleBuilder titleStyle1 = stl.style().setFontSize(12).bold();
		StyleBuilder titleStyle2 = stl.style(titleStyle1).setBackgroundColor(Color.LIGHT_GRAY);
		StyleBuilder titleStyle3 = stl.style(titleStyle2).setBorder(stl.pen1Point()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder cellStyle = stl.style().bold();

		measure1 = ctab.measure("field3", Integer.class, Calculation.SUM);
		measure1.setStyle(cellStyle);

		CrosstabBuilder crosstab = ctab.crosstab()
			.headerCell(cmp.text("Header").setStyle(titleStyle1))
			.rowGroups(
				rowGroup = ctab.rowGroup(field1).setHeaderStyle(titleStyle2).setTotalHeaderStyle(titleStyle3))
			.columnGroups(
				columnGroup = ctab.columnGroup(field2).setHeaderStyle(titleStyle2).setTotalHeaderStyle(titleStyle3))
			.measures(
				measure1);

		rb.setLocale(Locale.ENGLISH)
			.summary(crosstab);
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		setCrosstabBand("summary");

		crosstabHeaderElementStyleTest("textField1", 0, null, null, "Arial", 12, true, null);

		crosstabGroupHeaderStyleTest(rowGroup, 0, null, Color.LIGHT_GRAY, "Arial", 12, true, null);
		crosstabGroupTotalHeaderStyleTest(rowGroup, 0, null, Color.LIGHT_GRAY, "Arial", 12, true, null);
		crosstabGroupTotalHeaderHorizontalAlignmentTest(rowGroup, 0, HorizontalAlignEnum.CENTER);

		crosstabGroupHeaderStyleTest(columnGroup, 0, null, Color.LIGHT_GRAY, "Arial", 12, true, null);
		crosstabGroupTotalHeaderStyleTest(columnGroup, 0, null, Color.LIGHT_GRAY, "Arial", 12, true, null);
		crosstabGroupTotalHeaderHorizontalAlignmentTest(columnGroup, 0, HorizontalAlignEnum.CENTER);

		crosstabCellStyleTest(measure1, null, null, 0, null, null, "Arial", 10, true, null);
		crosstabCellStyleTest(measure1, rowGroup, null, 0, null, null, "Arial", 10, true, null);
		crosstabCellStyleTest(measure1, null, columnGroup, 0, null, null, "Arial", 10, true, null);
		crosstabCellStyleTest(measure1, rowGroup, columnGroup, 0, null, null, "Arial", 10, true, null);
	}

	@Override
	protected JRDataSource createDataSource() {
		DataSource dataSource = new DataSource("field1", "field2", "field3", "field4", "field5");
		dataSource.add("a", "c", 1);
		dataSource.add("a", "c", 2);
		dataSource.add("a", "d", 3);
		dataSource.add("a", "d", 4);
		dataSource.add("b", "c", 5);
		dataSource.add("b", "c", 6);
		dataSource.add("b", "d", 7);
		dataSource.add("b", "d", 8);
		return dataSource;
	}
}
