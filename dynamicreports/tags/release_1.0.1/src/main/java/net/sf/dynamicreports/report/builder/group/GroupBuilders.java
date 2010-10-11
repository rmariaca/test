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
package net.sf.dynamicreports.report.builder.group;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
@SuppressWarnings("ucd")
public class GroupBuilders {

	//column
	public ColumnGroupBuilder group(ColumnBuilder<?, ?> groupColumn) {
		return Groups.group(groupColumn);	
	}

	public ColumnGroupBuilder group(String name, ColumnBuilder<?, ?> groupColumn) {
		return Groups.group(name, groupColumn);	
	}
	
	//custom
	public CustomGroupBuilder group(String fieldName, Class<?> valueClass) {
		return Groups.group(fieldName, valueClass);
	}

	public CustomGroupBuilder group(String name, String fieldName, Class<?> valueClass) {
		return Groups.group(name, fieldName, valueClass);
	}
	
	public CustomGroupBuilder group(FieldBuilder<?> field) {
		return Groups.group(field);
	}

	public CustomGroupBuilder group(String name, FieldBuilder<?> field) {
		return Groups.group(name, field);
	}
	
	public CustomGroupBuilder group(DRISimpleExpression<?> expression) {
		return Groups.group(expression);
	}
	
	public CustomGroupBuilder group(String name, DRISimpleExpression<?> expression) {
		return Groups.group(name, expression);
	}
}