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
package net.sf.dynamicreports.report.builder.column;

import net.sf.dynamicreports.report.base.DRColumn;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIComplexExpression;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings({"unchecked", "ucd"})
public abstract class ColumnBuilder<T extends ColumnBuilder<T, U>, U> extends AbstractBuilder<T, DRColumn<U>> implements ColumnGridComponentBuilder {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	protected ColumnBuilder() {
		super(new DRColumn<U>(new DRTextField<U>()));
	}
	
	protected void setValueExpression(DRIExpression<U> valueExpression) {
		getObject().getValueField().setValueExpression(valueExpression);
	}
	
	public T setPrintRepeatedDetailValues(Boolean printRepeatedDetailValues) {
		getObject().setPrintRepeatedDetailValues(printRepeatedDetailValues);
		return (T) this;
	}
	
	public T setTitle(DRISimpleExpression<?> titleExpression) {
		getObject().setTitleExpression(titleExpression);
		return (T) this;
	}

	public T setTitle(DRIComplexExpression<?> titleExpression) {
		getObject().setTitleExpression(titleExpression);
		return (T) this;
	}
	
	public T setTitle(String title) {
		getObject().setTitleExpression(Expressions.text(title));
		return (T) this;
	}
	
	public T setTitleStyle(StyleBuilder titleStyle) {
		if (titleStyle != null) {
			getObject().setTitleStyle(titleStyle.getStyle());
		}
		else {
			getObject().setTitleStyle(null);
		}
		return (T) this;
	}
	
	public T setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		getObject().getValueField().setHorizontalAlignment(horizontalAlignment);
		return (T) this;
	}
	
	public T setPattern(String pattern) {
		getObject().getValueField().setPattern(pattern);
		return (T) this;
	}
	
	public T setValueFormatter(DRIValueFormatter<?, ? super U> valueFormatter) {
		getObject().getValueField().setValueFormatter(valueFormatter);
		return (T) this;
	}
	
	public T setDataType(DRIDataType<? super U, U> dataType) {
		getObject().getValueField().setDataType(dataType);
		return (T) this;
	}	
	
  /**
   * This method is used to define the preferred width of a column.
   * The width is set to the <code>columns</code> multiplied by width of the
   * character <em>m</em> for the font used
   * 
   * @param columns the number of preferred columns >= 1
   * @exception IllegalArgumentException if <code>columns</code> is < 1
   */
	public T setColumns(Integer columns) {
		getObject().getValueField().setColumns(columns);
		return (T) this;
	}
	
  /**
   * This method is used to define the fixed width of a column.
   * The width is set to the <code>columns</code> multiplied by width of the
   * character <em>m</em> for the font used
   * 
   * @param columns the number of fixed columns >= 1
   * @exception IllegalArgumentException if <code>columns</code> is < 1
   */
	public T setFixedColumns(Integer columns) {
		getObject().getValueField().setColumns(columns);
		getObject().getValueField().setWidthType(ComponentDimensionType.FIXED);
		return (T) this;
	}

  /**
   * This method is used to define the minimum width of a column.
   * The width is set to the <code>columns</code> multiplied by width of the
   * character <em>m</em> for the font used
   * 
   * @param columns the number of minimum columns >= 1
   * @exception IllegalArgumentException if <code>columns</code> is < 1
   */
	public T setMinColumns(Integer columns) {
		getObject().getValueField().setColumns(columns);
		getObject().getValueField().setWidthType(ComponentDimensionType.EXPAND);
		return (T) this;
	}
	
  /**
   * This method is used to define the preferred height of a column.
   * The height is set to the <code>rows</code> multiplied by height of the font
   * 
   * @param rows the number of preferred rows >= 1
   * @exception IllegalArgumentException if <code>rows</code> is < 1
   */
	public T setRows(Integer rows) {
		getObject().getValueField().setRows(rows);
		return (T) this;
	}	
	
  /**
   * This method is used to define the fixed height of a column.
   * The height is set to the <code>rows</code> multiplied by height of the font
   * 
   * @param rows the number of fixed rows >= 1
   * @exception IllegalArgumentException if <code>rows</code> is < 1
   */
	public T setFixedRows(Integer rows) {
		getObject().getValueField().setRows(rows);
		getObject().getValueField().setHeightType(ComponentDimensionType.FIXED);
		return (T) this;
	}
		
  /**
   * This method is used to define the minimum height of a column.
   * The height is set to the <code>rows</code> multiplied by height of the font
   * 
   * @param rows the number of minimum rows >= 1
   * @exception IllegalArgumentException if <code>rows</code> is < 1
   */
	public T setMinRows(Integer rows) {
		getObject().getValueField().setRows(rows);
		getObject().getValueField().setHeightType(ComponentDimensionType.EXPAND);
		return (T) this;
	}
	
	public T setHyperLink(HyperLinkBuilder hyperLink) {
		if (hyperLink != null) {
			getObject().getValueField().setHyperLink(hyperLink.getHyperLink());
		}
		else {
			getObject().getValueField().setHyperLink(null);	
		}
		return (T) this;
	}	
	
  /**
   * Sets the preferred width of a column. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param width the column preferred width >= 1
   * @exception IllegalArgumentException if <code>width</code> is < 1
   */
	public T setWidth(Integer width) {
		getObject().getValueField().setWidth(width);
		return (T) this;
	}
	
  /**
   * Sets the fixed width of a column. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param width the column fixed width >= 1
   * @exception IllegalArgumentException if <code>width</code> is < 1
   */
	public T setFixedWidth(Integer width) {
		getObject().getValueField().setWidth(width);
		getObject().getValueField().setWidthType(ComponentDimensionType.FIXED);
		return (T) this;
	}

  /**
   * Sets the minimum width of a column. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param width the column minimum width >= 1
   * @exception IllegalArgumentException if <code>width</code> is < 1
   */
	public T setMinWidth(Integer width) {
		getObject().getValueField().setWidth(width);
		getObject().getValueField().setWidthType(ComponentDimensionType.EXPAND);
		return (T) this;
	}
	
  /**
   * Sets the preferred height of a column. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the column preferred height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	public T setHeight(Integer height) {
		getObject().getValueField().setHeight(height);
		return (T) this;
	}
		
  /**
   * Sets the fixed height of a column. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the column fixed height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	public T setFixedHeight(Integer height) {
		getObject().getValueField().setHeight(height);
		getObject().getValueField().setHeightType(ComponentDimensionType.FIXED);
		return (T) this;
	}
		
  /**
   * Sets the minimum height of a column. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the column minimum height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	public T setMinHeight(Integer height) {
		getObject().getValueField().setHeight(height);
		getObject().getValueField().setHeightType(ComponentDimensionType.EXPAND);
		return (T) this;
	}
	
	public T setStyle(StyleBuilder style) {
		if (style != null) {
			getObject().getValueField().setStyle(style.getStyle());
		}
		else {
			getObject().getValueField().setStyle(null);
		}
		return (T) this;
	}
	
	public T setPrintWhenExpression(DRISimpleExpression<Boolean> printWhenExpression) {
		getObject().getValueField().setPrintWhenExpression(printWhenExpression);
		return (T) this;
	}
	
  /**
   * This method is used to define the preferred height of a column title.
   * The height is set to the <code>rows</code> multiplied by height of the font
   * 
   * @param rows the number of preferred rows >= 1
   * @exception IllegalArgumentException if <code>rows</code> is < 1
   */
	public T setTitleRows(Integer rows) {
		getObject().setTitleRows(rows);
		return (T) this;
	}
	
  /**
   * This method is used to define the fixed height of a column title.
   * The height is set to the <code>rows</code> multiplied by height of the font
   * 
   * @param rows the number of fixed rows >= 1
   * @exception IllegalArgumentException if <code>rows</code> is < 1
   */
	public T setTitleFixedRows(Integer rows) {
		getObject().setTitleRows(rows);
		getObject().setTitleHeightType(ComponentDimensionType.FIXED);
		return (T) this;
	}
		
  /**
   * This method is used to define the minimum height of a column title.
   * The height is set to the <code>rows</code> multiplied by height of the font
   * 
   * @param rows the number of minimum rows >= 1
   * @exception IllegalArgumentException if <code>rows</code> is < 1
   */
	public T setTitleMinRows(Integer rows) {
		getObject().setTitleRows(rows);
		getObject().setTitleHeightType(ComponentDimensionType.EXPAND);
		return (T) this;
	}
	
  /**
   * Sets the preferred height of a column title. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the column title preferred height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	public T setTitleHeight(Integer height) {
		getObject().setTitleHeight(height);
		return (T) this;
	}
	
  /**
   * Sets the fixed height of a column title. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the column title fixed height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	public T setTitleFixedHeight(Integer height) {
		getObject().setTitleHeight(height);
		getObject().setTitleHeightType(ComponentDimensionType.FIXED);
		return (T) this;
	}
		
  /**
   * Sets the minimum height of a column title. 
   * @see net.sf.dynamicreports.report.builder.Units
   * 
   * @param height the column title minimum height >= 1
   * @exception IllegalArgumentException if <code>height</code> is < 1
   */
	public T setTitleMinHeight(Integer height) {
		getObject().setTitleHeight(height);
		getObject().setTitleHeightType(ComponentDimensionType.EXPAND);
		return (T) this;
	}
	
	public DRColumn<U> getColumn() {
		return build();
	}
}