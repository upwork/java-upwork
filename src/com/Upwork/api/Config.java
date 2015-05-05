/**
 * Copyright 2014 Upwork
 *
 * Licensed under the Upwork's API Terms of Use;
 * you may not use this file except in compliance with the Terms.
 * You may obtain a copy of the Terms at
 *
 *    https://developers.upwork.com/api-tos.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author: Maksym Novozhylov <mnovozhilov@upwork.com>
 */
package com.Upwork.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.Upwork.ClassPreamble;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "5/30/2014",
	currentRevision = 1,
	lastModified = "6/3/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public class Config {
	private final Properties properties;
	
	public Config(Properties properties) {
		if (properties == null) {
			this.properties = new Properties();
		}
		else {
			this.properties = properties;
			return;
		}
		
		InputStream input = null;
		
		try {
			input = new FileInputStream("upwork.properties");
			this.properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Get property by name
	 * @param key Parameter name
	 * */
	public String getProperty(String key) {
		return this.properties.getProperty(key);
	}
}
