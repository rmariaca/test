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
package net.sf.dynamicreports.test.jasper;

import junit.framework.Assert;
import net.sf.dynamicreports.report.base.DRSubtotal;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.builder.subtotal.BaseSubtotalBuilder;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class JasperTestUtils {
	
	//column detail	
	public static String getColumnDetailName(ColumnBuilder<?, ?> column) {
		return "detail.column_" + column.build().getName() + "1";
	}
	
	//column title	
	public static String getColumnTitleName(ColumnBuilder<?, ?> column) {
		return "columnHeader.column_" + column.build().getName() + ".title1";
	}
	
	//subtotal	
	private static String getSubtotalName(BaseSubtotalBuilder<?, ?> subtotal) {
		String band = null;
		DRSubtotal<?> subtl = subtotal.getSubtotal();
		switch (subtl.getPosition()) {
		case TITLE:	
			band = "title";
			break;
		case PAGE_HEADER:
			band = "pageHeader";
			break;
		case PAGE_FOOTER:
			band = "pageFooter";
			break;
		case COLUMN_HEADER:
			band = "columnHeader";
			break;
		case COLUMN_FOOTER:			
			band = "columnFooter";
			break;			
		case GROUP_HEADER:
		case FIRST_GROUP_HEADER:		
		case LAST_GROUP_HEADER:
			band = "subtotalGroupHeader";
			break;
		case GROUP_FOOTER:
		case FIRST_GROUP_FOOTER:
		case LAST_GROUP_FOOTER:
			band = "subtotalGroupFooter";
			break;
		case LAST_PAGE_FOOTER:	
			band = "lastPageFooter";
			break;
		case SUMMARY:			
			band = "summary";
			break;
		default:
			Assert.fail("Subtotal position " + subtl.getPosition().name() + " not found");
			return null;
		}
		return band + ".column_" + subtl.getShowInColumn().getName() + ".subtotal";
	}
	
	public static String getSubtotalLabelName(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex) {
		return getSubtotalName(subtotal) + ".label" + subtotalIndex;
	}
	
	public static String getSubtotalName(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex) {
		return getSubtotalName(subtotal) + subtotalIndex;
	}

	//group header title	
	public static String getHeaderTitleGroupName(GroupBuilder<?> group) {
		return "groupHeaderTitleAndValue.group_" + group.getGroup().getName() + ".title1";
	}
	
	//group header	
	public static String getHeaderGroupName(GroupBuilder<?> group) {
		return "groupHeaderTitleAndValue.group_" + group.getGroup().getName() + "1";
	}
}