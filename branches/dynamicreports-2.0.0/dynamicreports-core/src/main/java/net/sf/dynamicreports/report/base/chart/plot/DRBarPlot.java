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

package net.sf.dynamicreports.report.base.chart.plot;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.plot.DRIBarPlot;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class DRBarPlot extends DRAxisPlot implements DRIBarPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
	
	private Boolean showTickMarks;
	private Boolean showTickLabels;
	private Boolean showLabels;

	public void setShowLabels(Boolean showLabels) {
		this.showLabels = showLabels;
	}

	public Boolean getShowLabels() {
		return showLabels;
	}

	public void setShowTickLabels(Boolean showTickLabels) {
		this.showTickLabels = showTickLabels;
	}

	public Boolean getShowTickLabels() {
		return showTickLabels;
	}

	public void setShowTickMarks(Boolean showTickMarks) {
		this.showTickMarks = showTickMarks;
	}

	public Boolean getShowTickMarks() {
		return showTickMarks;
	}
}
