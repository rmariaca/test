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
package net.sf.dynamicreports.jasper.transformation;

import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignGroup;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class GroupTransform {
	private JasperTransformAccessor accessor;
	
	public GroupTransform(JasperTransformAccessor accessor) {
		this.accessor = accessor;
	}
	
	public void transform() {
		for (DRIDesignGroup group : accessor.getReport().getGroups()) {
			addGroup(group);
		}		
	}
	
	private void addGroup(DRIDesignGroup group) {
		try {
			JRDesignGroup jrGroup = group(group);
			accessor.getDesign().addGroup(jrGroup);	
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for group \"" + group.getName() + "\"", e);
		}
	}
	
	private JRDesignGroup group(DRIDesignGroup group) {
		JRDesignGroup jrGroup = new JRDesignGroup();
		jrGroup.setName(group.getName());		
		jrGroup.setReprintHeaderOnEachPage(group.isReprintHeaderOnEachPage());
		jrGroup.setStartNewColumn(group.isStartInNewColumn());
		jrGroup.setStartNewPage(group.isStartInNewPage());	
		return jrGroup;
	}
	
	public void transformExpressions() {
		for (DRIDesignGroup group : accessor.getReport().getGroups()) {
			getGroup(group).setExpression(accessor.getExpressionTransform().getExpression(group.getGroupExpression()));
		}		
	}
	
	protected JRDesignGroup getGroup(DRIDesignGroup group) {
		JRDesignGroup jrGroup = (JRDesignGroup) accessor.getDesign().getGroupsMap().get(group.getName());
		if (jrGroup == null)
			throw new JasperDesignException("Group " + group.getName() + " is not registered");
		return jrGroup;
	}	
}
