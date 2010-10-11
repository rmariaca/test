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
package net.sf.dynamicreports.design.base.style;

import net.sf.dynamicreports.design.definition.style.DRIDesignBorder;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRDesignBorder implements DRIDesignBorder {	
	private DRDesignPen topPen;
	private DRDesignPen leftPen;
	private DRDesignPen bottomPen;
	private DRDesignPen rightPen;

	public DRDesignPen getTopPen() {
		return topPen;
	}

	public void setTopPen(DRDesignPen topPen) {
		this.topPen = topPen;
	}

	public DRDesignPen getLeftPen() {
		return leftPen;
	}

	public void setLeftPen(DRDesignPen leftPen) {
		this.leftPen = leftPen;
	}

	public DRDesignPen getBottomPen() {
		return bottomPen;
	}

	public void setBottomPen(DRDesignPen bottomPen) {
		this.bottomPen = bottomPen;
	}

	public DRDesignPen getRightPen() {
		return rightPen;
	}

	public void setRightPen(DRDesignPen rightPen) {
		this.rightPen = rightPen;
	}
}