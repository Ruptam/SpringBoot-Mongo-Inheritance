/**
 * 
 */
package org.bapan.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ruptam
 *
 */
@Document
public class Derived extends Base {
	
	private String fieldB;

	/**
	 * @return the fieldB
	 */
	public String getFieldB() {
		return fieldB;
	}

	/**
	 * @param fieldB the fieldB to set
	 */
	public void setFieldB(String fieldB) {
		this.fieldB = fieldB;
	}
	
}
