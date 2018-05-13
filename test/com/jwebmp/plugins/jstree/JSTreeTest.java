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
import com.jwebmp.plugins.jstree.options.JSTreeNodeJS;
import com.jwebmp.plugins.jstree.themes.JSTreeDefaultDarkTheme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class JSTreeTest

{

	public JSTreeTest()
	{
	}

	@Test
	public void testPreConfigure()
	{
		Page<?> p = new Page();
		JSTree tree = new JSTree();
		tree.setID("id");
		p.getBody()
		 .add(tree);
		System.out.println(p.toString(true));
	}

	@Test
	public void testJS()
	{
		Page<?> p = new Page();
		JSTree tree = new JSTree();
		tree.setID("id");
		p.getBody()
		 .add(tree);
		System.out.println("\n" + p.renderJavascript());
	}

	@Test
	public void testList()
	{
		Page<?> p = new Page();
		JSTree tree = new JSTree();
		tree.setID("id");
		p.getBody()
		 .add(tree);
		JSTreeListItem<?> root = new JSTreeListItem<>("Root");
		root.getOptions()
		    .setSelected(true)
		    .setDisabled(false)
		    .setIcon("fa fa-check")
		    .setOpened(true);

		JSTreeList<?> list = tree.addRoot(root);
		list.addItem("Item 1", null)
		    .setID("node_id_1");
		list.addItem("Item 2", null);
		list.addItem("Item 3", null);


		System.out.println(p.toString(true));
	}


	@Test
	public void testGetData()
	{

		Page<?> p = new Page();
		JSTree tree = new JSTree();
		tree.setID("id");
		JSTreeData data = new JSTreeData()
		{
			@Override
			public StringBuilder renderData()
			{
				return null;
			}

			@Override
			public StringBuilder renderMassLoad()
			{
				return null;
			}
		};
		JSTreeNodeJS node = new JSTreeNodeJS("id", "text");
		data.getNodes()
		    .add(node);

		Assertions.assertEquals("[{\n" + "  \"id\" : \"id\",\n" + "  \"text\" : \"text\",\n" + "  \"children\" : false\n" + "}]", data.toString());
		System.out.println(data);
		System.out.println(tree.renderJavascript());
	}

	@Test
	public void testSetTheme()
	{
		Page<?> p = new Page();
		JSTree tree = new JSTree();
		tree.setID("id");
		tree.setTheme(new JSTreeDefaultDarkTheme());
		p.getBody()
		 .add(tree);
		System.out.println(p.toString(true));
	}

}
