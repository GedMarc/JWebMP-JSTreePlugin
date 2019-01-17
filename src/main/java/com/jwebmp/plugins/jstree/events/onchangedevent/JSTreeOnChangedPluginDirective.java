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
package com.jwebmp.plugins.jstree.events.onchangedevent;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.base.angular.directives.AngularDirectiveBase;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.plugins.jstree.JSTreePageConfigurator;

/**
 * Maps to the angular function of right click
 *
 * @author GedMarc
 * @since 25 Jun 2016
 */
@ComponentInformation(name = "JS Tree On Changed Plugin",
		description = "This plugin adds additional information about selection changes. Once included in the plugins config option, each changed.jstree event data will contain a new property named changed, which will give information about selected and deselected nodes since the last changed.jstree event",
		url = "https://www.jstree.com/plugins/")
public class JSTreeOnChangedPluginDirective
		extends AngularDirectiveBase<JSTreeOnChangedPluginDirective>
{
	/**
	 * Constructs a new right click directive based on the angular object passed in
	 */
	public JSTreeOnChangedPluginDirective()
	{
		super("ngJstreeOnchanged");
	}

	/**
	 * Renders the right click directive from the JavaScript file
	 *
	 * @return
	 */
	@Override
	public String renderFunction()
	{
		return FileTemplates.getFileTemplate(JSTreeOnChangedPluginDirective.class, "JSTreeOnChangedPlugin", "JSTreeOnChangedPlugin.min.js")
		                    .toString();
	}

	@Override
	public boolean enabled()
	{
		return JSTreePageConfigurator.isEnabled();
	}
}
