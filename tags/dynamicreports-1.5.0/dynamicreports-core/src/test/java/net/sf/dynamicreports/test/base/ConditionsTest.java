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

package net.sf.dynamicreports.test.base;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.sql.Connection;
import java.util.Locale;

import junit.framework.Assert;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

import org.junit.Test;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class ConditionsTest {

	@Test
	public void test() {
		//equal
		FieldBuilder<Integer> value = field("name", Integer.class);
		conditionTrue("equal", cnd.equal(value, 5, 10, 20));
		conditionFalse("equal", cnd.equal(value, 5, 20));

		//unequal
		conditionFalse("unequal", cnd.unEqual(value, 5, 10, 20));
		conditionTrue("unequal", cnd.unEqual(value, 5, 20));

		//smaller
		conditionFalse("smaller", cnd.smaller(value, 5));
		conditionFalse("smaller", cnd.smaller(value, 10));
		conditionTrue("smaller", cnd.smaller(value, 15));

		//smallerOrEquals
		conditionFalse("smallerOrEquals", cnd.smallerOrEquals(value, 5));
		conditionTrue("smallerOrEquals", cnd.smallerOrEquals(value, 10));
		conditionTrue("smallerOrEquals", cnd.smallerOrEquals(value, 15));
		
		//greater
		conditionTrue("greater", cnd.greater(value, 5));
		conditionFalse("greater", cnd.greater(value, 10));
		conditionFalse("greater", cnd.greater(value, 15));
		
		//greaterOrEquals
		conditionTrue("greaterOrEquals", cnd.greaterOrEquals(value, 5));
		conditionTrue("greaterOrEquals", cnd.greaterOrEquals(value, 10));
		conditionFalse("greaterOrEquals", cnd.greaterOrEquals(value, 15));
		
		//between
		conditionTrue("between", cnd.between(value, 5, 15));
		conditionTrue("between", cnd.between(value, 5, 10));
		conditionTrue("between", cnd.between(value, 10, 20));
		conditionFalse("between", cnd.between(value, 5, 9));
		conditionFalse("between", cnd.between(value, 11, 20));
		
		//notBetween
		conditionFalse("notBetween", cnd.notBetween(value, 5, 15));
		conditionFalse("notBetween", cnd.notBetween(value, 5, 10));
		conditionFalse("notBetween", cnd.notBetween(value, 10, 20));
		conditionTrue("notBetween", cnd.notBetween(value, 5, 9));
		conditionTrue("notBetween", cnd.notBetween(value, 11, 20));
	}
	
	private void conditionTrue(String name, DRISimpleExpression<Boolean> condition) {
		Assert.assertTrue(name + " condition", condition.evaluate(new TestReportParameters(10)));
	}

	private void conditionFalse(String name, DRISimpleExpression<Boolean> condition) {
		Assert.assertFalse(name + " condition", condition.evaluate(new TestReportParameters(10)));
	}
	
	private class TestReportParameters implements ReportParameters {
		private Number value;
		
		public TestReportParameters(Number value) {
			this.value = value;
		}
		
		public Integer getColumnNumber() {
			return null;
		}

		public Integer getColumnRowNumber() {
			return null;
		}

		public Connection getConnection() {
			return null;
		}

		public Integer getGroupCount(String groupName) {
			return null;
		}

		public Locale getLocale() {
			return null;
		}

		public String getMessage(String key) {
			return null;
		}

		public Integer getPageNumber() {
			return null;
		}

		public Integer getPageRowNumber() {
			return null;
		}

		public Integer getReportRowNumber() {
			return null;
		}

		public DRIScriptlet getScriptlet(String name) {
			return null;
		}

		public <T> T getValue(String name) {
			return null;
		}

		@SuppressWarnings("unchecked")
		public <T> T getValue(DRIValue<T> value) {
			return (T) this.value;
		}

		public ReportParameters getMasterParameters() {
			return null;
		}
		
	}
}