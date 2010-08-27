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

package net.sf.dynamicreports.test.jasper.component;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.dynamicreports.test.jasper.DataSource;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class ComponentTest extends AbstractJasperValueTest {
	
	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.setLocale(Locale.ENGLISH)
			.columns(
					col.column("Column1", "field1", Integer.class))
			.pageFooter(
					cmp.pageXofY(), 
					cmp.pageXslashY(), 
					cmp.currentDate().setPattern("dd.MM.yyyy"), 
					cmp.totalPages(), 
					cmp.pageNumber());
	}

	@Override
	public void test() {
		super.test();
		
		numberOfPagesTest(3);
		elementCountTest("pageFooter.textField1", 3);
		elementValueTest("pageFooter.textField1", "1 of 3", "2 of 3", "3 of 3");
		
		elementCountTest("pageFooter.textField2", 3);
		elementValueTest("pageFooter.textField2", "1/3", "2/3", "3/3");
		
		elementCountTest("pageFooter.textField3", 3);
		String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
		elementValueTest("pageFooter.textField3", date, date, date);
		
		elementCountTest("pageFooter.textField4", 3);
		elementValueTest("pageFooter.textField4", "3", "3", "3");
		
		elementCountTest("pageFooter.textField5", 3);
		elementValueTest("pageFooter.textField5", "1", "2", "3");
	}
	
	@Override
	protected JRDataSource createDataSource() {
		DataSource dataSource = new DataSource("field1");
		for (int i = 0; i < 100; i++) {
			dataSource.add(i);
		}		
		return dataSource;
	}
}