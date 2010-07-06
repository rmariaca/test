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
package net.sf.dynamicreports.report.base.barcode;

import org.apache.commons.lang.Validate;

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.barcode.DRIBarcode;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public abstract class DRBarcode extends DRDimensionComponent implements DRIBarcode {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private DRISimpleExpression<String> codeExpression;
	private DRISimpleExpression<String> patternExpression;
	private Double moduleWidth;
	private BarcodeOrientation orientation;
	private BarcodeTextPosition textPosition;
	private Double quietZone;
	private Double verticalQuietZone;

	public DRISimpleExpression<String> getCodeExpression() {
		return codeExpression;
	}

	public void setCodeExpression(DRISimpleExpression<String> codeExpression) {
		Validate.notNull(codeExpression, "codeExpression must not be null");
		this.codeExpression = codeExpression;
	}

	public DRISimpleExpression<String> getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(DRISimpleExpression<String> patternExpression) {
		this.patternExpression = patternExpression;
	}

	public Double getModuleWidth() {
		return moduleWidth;
	}

	public void setModuleWidth(Double moduleWidth) {
		this.moduleWidth = moduleWidth;
	}

	public BarcodeOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(BarcodeOrientation orientation) {
		this.orientation = orientation;
	}

	public BarcodeTextPosition getTextPosition() {
		return textPosition;
	}

	public void setTextPosition(BarcodeTextPosition textPosition) {
		this.textPosition = textPosition;
	}

	public Double getQuietZone() {
		return quietZone;
	}

	public void setQuietZone(Double quietZone) {
		this.quietZone = quietZone;
	}

	public Double getVerticalQuietZone() {
		return verticalQuietZone;
	}

	public void setVerticalQuietZone(Double verticalQuietZone) {
		this.verticalQuietZone = verticalQuietZone;
	}	
}
