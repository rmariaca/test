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
package net.sf.dynamicreports.test.jasper.style;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;
import java.io.Serializable;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.dynamicreports.test.jasper.DataSource;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class Style3Test extends AbstractJasperStyleTest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private TextColumnBuilder<String> column1;
	private TextColumnBuilder<String> column2;
	private TextColumnBuilder<String> column3;
	private TextColumnBuilder<String> column4;
	private ColumnGroupBuilder group1;
	
	@Override
	protected void configureReport(JasperReportBuilder rb) {
		StyleBuilder titleStyle = stl.style().setForegroudColor(Color.RED);
		StyleBuilder columnStyle = stl.style().setForegroudColor(Color.BLUE);
		
		rb.setColumnTitleStyle(titleStyle)
			.setColumnStyle(columnStyle)
			.columns(
					column1 = col.column("Column1", "field1", type.stringType()).setStyle(stl.style().italic()).setTitleStyle(stl.style().bold()),
					column2 = col.column("Column2", "field2", type.stringType()),
					column3 = col.column("Column3", "field3", type.stringType()).setStyle(stl.style().bold()),
					column4 = col.column("Column4", "field4", type.stringType()).setStyle(stl.style(columnStyle).bold()).setTitleStyle(stl.style().italic()))
			.groupBy(group1 = grp.group(column1).setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE));
	}

	@Override
	public void test() {
		super.test();
		
		numberOfPagesTest(1);
		
		//column2		
		columnTitleStyleTest(column2, 0, Color.RED, null, "Arial", 10, null, null);
		columnDetailStyleTest(column2, 0, Color.BLUE, null, "Arial", 10, null, null);

		//column3		
		columnTitleStyleTest(column3, 0, Color.RED, null, "Arial", 10, null, null);
		columnDetailStyleTest(column3, 0, null, null, "Arial", 10, true, null);

		//column4		
		columnTitleStyleTest(column4, 0, null, null, "Arial", 10, null, true);
		columnDetailStyleTest(column4, 0, Color.BLUE, null, "Arial", 10, true, null);
		
		//group1
		groupHeaderTitleStyleTest(group1, 0, null, null, "Arial", 10, true, null);
		groupHeaderStyleTest(group1, 0, null, null, "Arial", 10, null, true);
	}
	
	@Override
	protected JRDataSource createDataSource() {
		DataSource dataSource = new DataSource("field1", "field2", "field3");
		dataSource.add("1", "1", "1");
		return dataSource;
	}
}
