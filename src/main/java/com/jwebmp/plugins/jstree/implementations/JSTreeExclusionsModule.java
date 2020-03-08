package com.jwebmp.plugins.jstree.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class JSTreeExclusionsModule
		implements IGuiceScanModuleExclusions<JSTreeExclusionsModule>
{

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.jstree");
		return strings;
	}
}
