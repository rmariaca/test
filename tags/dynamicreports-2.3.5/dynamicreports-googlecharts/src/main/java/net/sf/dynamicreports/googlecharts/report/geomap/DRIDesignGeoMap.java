/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2012 Ricardo Mariaca
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

package net.sf.dynamicreports.googlecharts.report.geomap;

import java.awt.Color;
import java.util.List;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.component.DRIDesignCustomComponent;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public interface DRIDesignGeoMap extends DRIDesignCustomComponent {

	public EvaluationTime getEvaluationTime();

	public DRIDesignGroup getEvaluationGroup();

	public Boolean getShowLegend();

	public GeoMapDataMode getDataMode();

	public DRIDesignExpression getRegionExpression();

	public DRIDesignExpression getValueLabelExpression();

	public List<Color> getColors();

	public DRIDesignGeoMapDataset getDataset();
}