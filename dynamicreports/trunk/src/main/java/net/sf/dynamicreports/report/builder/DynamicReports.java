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
package net.sf.dynamicreports.report.builder;

import net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.ExporterBuilders;
import net.sf.dynamicreports.report.builder.barcode.BarcodeBuilders;
import net.sf.dynamicreports.report.builder.chart.ChartBuilders;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilders;
import net.sf.dynamicreports.report.builder.component.ComponentBuilders;
import net.sf.dynamicreports.report.builder.condition.ConditionBuilders;
import net.sf.dynamicreports.report.builder.datatype.DataTypeBuilders;
import net.sf.dynamicreports.report.builder.expression.ExpressionBuilders;
import net.sf.dynamicreports.report.builder.grid.GridBuilders;
import net.sf.dynamicreports.report.builder.group.GroupBuilders;
import net.sf.dynamicreports.report.builder.style.StyleBuilders;
import net.sf.dynamicreports.report.builder.subtotal.SubtotalBuilders;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.QueryLanguage;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

import org.apache.commons.lang.Validate;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings("ucd")
public class DynamicReports {
	public static final ColumnBuilders col = new ColumnBuilders();
	public static final GridBuilders grid = new GridBuilders();
	public static final GroupBuilders grp = new GroupBuilders();
	public static final SubtotalBuilders sbt = new SubtotalBuilders();
	public static final StyleBuilders stl = new StyleBuilders();
	public static final ComponentBuilders cmp = new ComponentBuilders();
	public static final ExpressionBuilders exp = new ExpressionBuilders();
	public static final ConditionBuilders cnd = new ConditionBuilders();
	public static final DataTypeBuilders type = new DataTypeBuilders();
	public static final ChartBuilders cht = new ChartBuilders();
	public static final ExporterBuilders export = new ExporterBuilders();
	public static final BarcodeBuilders bcode = new BarcodeBuilders();
	
	//report
	public static JasperReportBuilder report() {
		return new JasperReportBuilder();
	}	

	public static JasperConcatenatedReportBuilder concatenatedReport() {
		return new JasperConcatenatedReportBuilder();
	}
	
	//field
	public static <T> FieldBuilder<T> field(String name, Class<T> valueClass) {
		return new FieldBuilder<T>(name, valueClass);
	}
	
	//variable
	public static <T> VariableBuilder<T> variable(ColumnBuilder<?, ?> column, Calculation calculation) {
		Validate.notNull(column, "column must not be null");
		return new VariableBuilder<T>(column, calculation);
	}

	public static <T> VariableBuilder<T> variable(String name, ColumnBuilder<?, ?> column, Calculation calculation) {
		Validate.notNull(column, "column must not be null");
		return new VariableBuilder<T>(name, column, calculation);
	}

	public static <T> VariableBuilder<T> variable(FieldBuilder<T> field, Calculation calculation) {
		Validate.notNull(field, "field must not be null");
		return new VariableBuilder<T>(field, calculation);
	}

	public static <T> VariableBuilder<T> variable(String name, FieldBuilder<T> field, Calculation calculation) {
		return new VariableBuilder<T>(name, field, calculation);
	}
	
	public static <T> VariableBuilder<T> variable(String fieldName, Class<?> valueClass, Calculation calculation) {
		return new VariableBuilder<T>(field(fieldName, valueClass), calculation);
	}

	public static <T> VariableBuilder<T> variable(String name, String fieldName, Class<?> valueClass, Calculation calculation) {
		return new VariableBuilder<T>(name, field(fieldName, valueClass), calculation);
	}
	
	public static <T> VariableBuilder<T> variable(DRISimpleExpression<?> expression, Calculation calculation) {
		return new VariableBuilder<T>(expression, calculation);
	}

	public static <T> VariableBuilder<T> variable(String name, DRISimpleExpression<?> expression, Calculation calculation) {
		return new VariableBuilder<T>(name, expression, calculation);
	}
	
	//hyperLink
	public static HyperLinkBuilder hyperLink(String link) {
		return new HyperLinkBuilder(link);
	}
	
	public static HyperLinkBuilder hyperLink(DRISimpleExpression<String> linkExpression) {
		return new HyperLinkBuilder(linkExpression);
	}
	
	//margin
	public static MarginBuilder margin() {
		return new MarginBuilder();
	}
	
	public static MarginBuilder margin(int margin) {
		return new MarginBuilder(margin);
	}
	
	//parameter
	public static <T> ParameterBuilder<T> parameter(String name, T value) {
		return new ParameterBuilder<T>(name, value);
	}

	//query
	public static QueryBuilder query(String text, QueryLanguage language) {
		return new QueryBuilder(text, language);
	}
	
	//units
	public static int cm(Number value) {
		return Units.cm(value);
	}
	
	public static int inch(Number value) {
		return Units.inch(value);
	}
	
	public static int mm(Number value) {
		return Units.mm(value);
	}
	
	//template
	public static ReportTemplateBuilder template() {
		return new ReportTemplateBuilder();
	}
}
