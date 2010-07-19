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
package net.sf.dynamicreports.test.design.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import junit.framework.Assert;
import net.sf.dynamicreports.design.base.DRDesignReport;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.exception.DRException;

import org.junit.Test;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class ExceptionTest {

	@Test
	public void testComponentFixedWidth() {
		@SuppressWarnings("rawtypes")
		ReportBuilder<?> rb1 = new ReportBuilder();		
		rb1.title(cmp.text("").setFixedWidth(600));
		try {
			new DRDesignReport(rb1.getReport());
			Assert.fail("component fixed width exception");
		} catch (DRException e) {
		}
		
		@SuppressWarnings("rawtypes")
		ReportBuilder<?> rb2 = new ReportBuilder();		
		rb2.title(cmp.horizontalList(cmp.text("").setFixedWidth(600)));
		try {
			new DRDesignReport(rb2.getReport());
			Assert.fail("component fixed width exception");
		} catch (DRException e) {
		}
		
		@SuppressWarnings("rawtypes")
		ReportBuilder<?> rb3 = new ReportBuilder();		
		rb3.title(cmp.horizontalFlowList(cmp.text("").setFixedWidth(600)));
		try {
			new DRDesignReport(rb3.getReport());
			Assert.fail("component fixed width exception");
		} catch (DRException e) {
		}
	}
	
	@Test
	public void testComponentMinimumWidth() {
		@SuppressWarnings("rawtypes")
		ReportBuilder<?> rb1 = new ReportBuilder();		
		rb1.title(cmp.text("").setMinWidth(600));
		try {
			new DRDesignReport(rb1.getReport());
			Assert.fail("component minimum width exception");
		} catch (DRException e) {	
		}
		
		@SuppressWarnings("rawtypes")
		ReportBuilder<?> rb2 = new ReportBuilder();		
		rb2.title(cmp.horizontalList(cmp.text("").setMinWidth(600)));
		try {
			new DRDesignReport(rb2.getReport());
			Assert.fail("component fixed width exception");
		} catch (DRException e) {
		}
		
		@SuppressWarnings("rawtypes")
		ReportBuilder<?> rb3 = new ReportBuilder();		
		rb3.title(cmp.horizontalFlowList(cmp.text("").setMinWidth(600)));
		try {
			new DRDesignReport(rb3.getReport());
			Assert.fail("component fixed width exception");
		} catch (DRException e) {
		}
	}
	
	@Test
	public void testVariable() {
		TextColumnBuilder<Object> column = col.column("fieldName", Object.class);
		ColumnGroupBuilder group = grp.group(column);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ReportBuilder<?> rb1 = new ReportBuilder()
			.columns(column)
			.groupBy(group)
			.variables(variable("fieldName", Object.class, Calculation.SUM).setResetGroup(group).setResetType(Evaluation.REPORT));
		try {
			new DRDesignReport(rb1.getReport());
			Assert.fail("variable exception");
		} catch (DRException e) {	
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ReportBuilder<?> rb2 = new ReportBuilder()
			.columns(column)
			.groupBy(group)
			.variables(variable("fieldName", Object.class, Calculation.SUM).setResetType(Evaluation.GROUP));
		try {
			new DRDesignReport(rb2.getReport());
			Assert.fail("variable exception");
		} catch (DRException e) {	
		}
	}
}
