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
package com.jwebmp.plugins.jstree;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.jstree.enumerations.JSTreeReferencePool;

import javax.validation.constraints.NotNull;

/**
 * @author GedMarc
 */
@PluginInformation(pluginName = "JS Tree",
		pluginUniqueName = "js-tree",
		pluginDescription = "jsTree functions properly in either box-model (content-box or border-box), can be loaded as an AMD module, and has a built in mobile theme for responsive design, that can easily be customized. It uses jQuery's event system, so binding callbacks on various events in the tree is familiar and easy.",
		pluginVersion = "3.3.5",
		pluginDependancyUniqueIDs = "jquery",
		pluginCategories = "jquery, ui, tree, jstree, framework, web",
		pluginSubtitle = "jsTree is jquery plugin, that provides interactive trees. ",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-JSTreePlugin",
		pluginSourceUrl = "https://github.com/vakata/jstree/",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-JSTreePlugin/wiki",
		pluginOriginalHomepage = "https://www.jstree.com/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/JSTreePlugin.jar/download",
		pluginIconUrl = "bower_components/jstree/icon.jpg",
		pluginIconImageUrl = "bower_components/jstree/example.png",
		pluginLastUpdatedDate = "2018/05/13")
public class JSTreePageConfigurator
		implements IPageConfigurator<JSTreePageConfigurator>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return JSTreePageConfigurator.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		JSTreePageConfigurator.enabled = mustEnable;
	}

	@NotNull
	@Override
	public Page configure(Page page)
	{
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
		if (!page.isConfigured() && enabled())
		{
			page.addJavaScriptReference(JSTreeReferencePool.JSTreeJavascript.getJavaScriptReference());
			page.addCssReference(JSTreeReferencePool.JSTreeJavascript.getCssReference());
		}
		return page;
	}

	@Override
	public boolean enabled()
	{
		return JSTreePageConfigurator.enabled;
	}

}
