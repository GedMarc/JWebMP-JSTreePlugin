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
package za.co.mmagon.jwebswing.plugins.jstree;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 *
 * @author GedMarc
 */
@PluginInformation(pluginName = "JS Tree",
                   pluginUniqueName = "js-tree",
                   pluginDescription = "jsTree functions properly in either box-model (content-box or border-box), can be loaded as an AMD module, and has a built in mobile theme for responsive design, that can easily be customized. It uses jQuery's event system, so binding callbacks on various events in the tree is familiar and easy.",
                   pluginVersion = "1.12.0",
                   pluginDependancyUniqueIDs = "",
                   pluginCategories = "jquery, ui, jqwidgets, jqxwidgets, framework, web",
                   pluginSubtitle = "jsTree is jquery plugin, that provides interactive trees. ",
                   pluginGitUrl = "https://github.com/GedMarc/JWebSwing-JSTreePlugin",
                   pluginSourceUrl = "https://github.com/vakata/jstree/",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-JSTreePlugin/wiki",
                   pluginOriginalHomepage = "https://www.jstree.com/",
                   pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/JSTreePlugin.jar/download",
                   pluginIconUrl = "bower_components/jstree/icon.jpg",
                   pluginIconImageUrl = "bower_components/jstree/example.png",
                   pluginLastUpdatedDate = "2017/03/04"
)
public class JSTreePageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;

    @Override
    public Page configure(Page page)
    {
        return page;
    }

}
