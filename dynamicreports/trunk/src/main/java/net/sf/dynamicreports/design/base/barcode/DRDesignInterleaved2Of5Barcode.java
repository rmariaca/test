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
package net.sf.dynamicreports.design.base.barcode;

import net.sf.dynamicreports.design.definition.barcode.DRIDesignInterleaved2Of5Barcode;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRDesignInterleaved2Of5Barcode extends DRDesignChecksumBarcode implements DRIDesignInterleaved2Of5Barcode {
	private Boolean displayChecksum;
	private Double wideFactor;
	
	public DRDesignInterleaved2Of5Barcode() {
		super("Interleaved2Of5");
	}

	public Boolean getDisplayChecksum() {
		return displayChecksum;
	}

	public void setDisplayChecksum(Boolean displayChecksum) {
		this.displayChecksum = displayChecksum;
	}

	public Double getWideFactor() {
		return wideFactor;
	}

	public void setWideFactor(Double wideFactor) {
		this.wideFactor = wideFactor;
	}	
}