/* 
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.  
 */
package de.jwi.jspwiki.plugins;

import java.util.List;
import java.util.Map;

import org.apache.wiki.WikiContext;
import org.apache.wiki.api.exceptions.PluginException;
import org.apache.wiki.api.plugin.WikiPlugin;
import org.zeroturnaround.exec.ProcessExecutor;

import edu.rice.cs.util.ArgumentTokenizer;

/**
 * exec a system command
 * 
 * <p>
 * Parameters :
 * </p>
 * commandline
 */
public class OSExecPlugin implements WikiPlugin {
	public String execute(WikiContext context, Map<String, String> params) throws PluginException {
		try {
			String commandline = params.get("commandline");
			String systemproperty = params.get("systemproperty");

			if (commandline != null) {
				List<String> args = ArgumentTokenizer.tokenize(commandline);

				String output = new ProcessExecutor().command(args).readOutput(true).execute().outputUTF8();

				return output;
			}

			if (systemproperty != null) {
				String output = System.getProperty(systemproperty);
				
				return output;
			}
			
			return "";
		} catch (Exception e) {
			throw new PluginException(e.getMessage(), e);
		}

	}
}
