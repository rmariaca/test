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
package net.sf.dynamicreports.design.transformation;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

import net.sf.dynamicreports.design.base.style.DRDesignStyle;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
class StyleResolver {
	private static FontRenderContext context = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics().getFontRenderContext();
	
	protected static int getFontWidth(DRDesignStyle style, int columns) {
		double width = getFont(style).getStringBounds("m", context).getWidth();
		return (int) Math.ceil(width * columns) + getHorizontalPadding(style);
	}
	
	protected static int getFontHeight(DRDesignStyle style, int rows) {
		double height = getFont(style).getMaxCharBounds(context).getHeight();
		return (int) Math.ceil(height * rows) + getVerticalPadding(style);
	}

	private static Font getFont(DRDesignStyle style) {
		String fontName = getFontName(style);	
		Integer fontSize = getFontSize(style);
		Boolean bold = getFontBold(style);
		if (bold == null) {
			bold = false;
		}
		Boolean italic = getFontItalic(style);
		if (italic == null) {
			italic = false;
		}
		
		int fontStyle;
		if (bold && italic) {
			fontStyle = Font.BOLD | Font.ITALIC;
		}
		else if (bold) {
			fontStyle = Font.BOLD;
		}
		else if (italic) {
			fontStyle = Font.ITALIC;
		}
		else {
			fontStyle = Font.PLAIN;
		}
		
		return new Font(fontName, fontStyle, fontSize);
	}
	
	protected static String getFontName(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getFontName() != null) {
			return style.getFont().getFontName();
		}
		if (style.getParentStyle() != null) {
			return getFontName(style.getParentStyle());
		}
		return null;
	}
	
	protected static Integer getFontSize(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getFontSize() != null) {
			return style.getFont().getFontSize();
		}
		if (style.getParentStyle() != null) {
			return getFontSize(style.getParentStyle());
		}
		return null;
	}
	
	private static Boolean getFontBold(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getBold() != null) {
			return style.getFont().getBold();
		}
		if (style.getParentStyle() != null) {
			return getFontBold(style.getParentStyle());
		}
		return null;
	}
	
	private static Boolean getFontItalic(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getItalic() != null) {
			return style.getFont().getItalic();
		}
		if (style.getParentStyle() != null) {
			return getFontItalic(style.getParentStyle());
		}
		return null;
	}
	
	protected static String getPdfFontName(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getPdfFontName() != null) {
			return style.getFont().getPdfFontName();
		}
		if (style.getParentStyle() != null) {
			return getPdfFontName(style.getParentStyle());
		}
		return null;
	}
	
	protected static String getPdfEncoding(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getPdfEncoding() != null) {
			return style.getFont().getPdfEncoding();
		}
		if (style.getParentStyle() != null) {
			return getPdfEncoding(style.getParentStyle());
		}
		return null;
	}
	
	protected static Boolean getPdfEmbedded(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getFont().getPdfEmbedded() != null) {
			return style.getFont().getPdfEmbedded();
		}
		if (style.getParentStyle() != null) {
			return getPdfEmbedded(style.getParentStyle());
		}
		return null;
	}
	
	protected static int getHorizontalPadding(DRDesignStyle style) {
		return getLeftPadding(style) + getRightPadding(style); 
	}

	protected static int getVerticalPadding(DRDesignStyle style) {
		return getTopPadding(style) + getBottomPadding(style); 
	}
	
	private static Integer getTopPadding(DRDesignStyle style) {
		if (style == null) {
			return 0;
		}
		if (style.getPadding() != null && style.getPadding().getTop() != null) {
			return style.getPadding().getTop();
		}
		if (style.getParentStyle() != null) {
			return getTopPadding(style.getParentStyle());
		}
		return 0;
	}
	
	private static Integer getBottomPadding(DRDesignStyle style) {
		if (style == null) {
			return 0;
		}
		if (style.getPadding() != null && style.getPadding().getBottom() != null) {
			return style.getPadding().getBottom();
		}
		if (style.getParentStyle() != null) {
			return getBottomPadding(style.getParentStyle());
		}
		return 0;
	}
	
	private static Integer getLeftPadding(DRDesignStyle style) {
		if (style == null) {
			return 0;
		}
		if (style.getPadding() != null && style.getPadding().getLeft() != null) {
			return style.getPadding().getLeft();
		}
		if (style.getParentStyle() != null) {
			return getLeftPadding(style.getParentStyle());
		}
		return 0;
	}
	
	private static Integer getRightPadding(DRDesignStyle style) {
		if (style == null) {
			return 0;
		}
		if (style.getPadding() != null && style.getPadding().getRight() != null) {
			return style.getPadding().getRight();
		}
		if (style.getParentStyle() != null) {
			return getRightPadding(style.getParentStyle());
		}
		return 0;
	}

	/*public static String getPattern(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getPattern() != null) {
			return style.getPattern();
		}
		if (style.getParentStyle() != null) {
			return getPattern(style.getParentStyle());
		}
		return null;
	}
	
	public static HorizontalAlignment getHorizontalAlignment(DRDesignStyle style) {
		if (style == null) {
			return null;
		}
		if (style.getHorizontalAlignment() != null) {
			return style.getHorizontalAlignment();
		}
		if (style.getParentStyle() != null) {
			return getHorizontalAlignment(style.getParentStyle());
		}
		return null;
	}*/
}
