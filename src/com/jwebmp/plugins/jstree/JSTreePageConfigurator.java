/*
 * Copyright (C) 2017 Marc Magon
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

import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.plugins.PluginInformation;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.plugins.jstree.enumerations.JSTreeReferencePool;

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
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-JSTreePlugin",
		pluginSourceUrl = "https://github.com/vakata/jstree/",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-JSTreePlugin/wiki",
		pluginOriginalHomepage = "https://www.jstree.com/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/JSTreePlugin.jar/download",
		pluginIconUrl = "bower_components/jstree/icon.jpg",
		pluginIconImageUrl = "bower_components/jstree/example.png",
		pluginLastUpdatedDate = "2018/05/13")
public class JSTreePageConfigurator
		extends PageConfigurator
{

	private static final long serialVersionUID = 1L;

	@Override
	public Page configure(Page page)
	{
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
		if (!page.isConfigured())
		{
			page.addJavaScriptReference(JSTreeReferencePool.JSTreeJavascript.getJavaScriptReference());
		}
		return page;
	}

}
