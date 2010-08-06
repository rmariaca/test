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

package net.sf.dynamicreports.test.jasper.subtotal;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.dynamicreports.test.jasper.DataSource;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class SubtotalPosition1Test extends AbstractJasperPositionTest {	
	private AggregationSubtotalBuilder<Integer> subtotal1;
	private AggregationSubtotalBuilder<Double> subtotal2;
	
	@Override
	protected void configureReport(JasperReportBuilder rb) {		
		TextColumnBuilder<Integer> column1;
		
		rb.columns(
					column1 = col.column("Column1", "field1", Integer.class).setWidth(600))
			.subtotalsAtSummary(
				subtotal1 = sbt.sum(column1),
				subtotal2 = sbt.aggregate(column1, Calculation.AVERAGE));
	}

	@Override
	public void test() {
		super.test();
		
		numberOfPagesTest(1);
		//summary
		subtotalPositionTest(subtotal1, 0, 0, 0, 575, 16);
		subtotalIndexPositionTest(subtotal2, 2, 0, 0, 16, 575, 16);
	}
	
	@Override
	protected JRDataSource createDataSource() {
		DataSource dataSource = new DataSource("field1");
		dataSource.add(1);
		return dataSource;
	}
}
