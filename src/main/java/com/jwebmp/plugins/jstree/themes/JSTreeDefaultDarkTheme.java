/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jstree.themes;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.htmlbuilder.css.themes.Theme;

/**
 * @author GedMarc
 * @version 1.0
 * @since Aug 27, 2016
 */
public class JSTreeDefaultDarkTheme
		extends Theme
		implements JSTreeTheme
{


	public JSTreeDefaultDarkTheme()
	{
		super("default-dark", "jstreetheme");
		getCssReferences().add(new CSSReference("JSTreeDefaultDarkTheme", 3.32, "bower_components/jstree/dist/themes/default-dark/style.css"));
	}
}
