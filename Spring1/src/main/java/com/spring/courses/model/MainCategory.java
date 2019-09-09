package com.spring.courses.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@SuppressWarnings("serial")
@Entity
@Table
public class MainCategory implements Serializable {

	@Id
	private Integer mId;

	private String courseName;

	private byte[] image;
	private String base64;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid", referencedColumnName = "courseName")
	private List<Adobe> subCategory;

	public List<Adobe> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Adobe> subCategory) {
		this.subCategory = subCategory;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	@Transient
	public String getBase64() {
		return this.base64 = Base64.encode(this.image);
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	@Override
	public String toString() {
		return "MainCategory [mId=" + mId + ", courseName=" + courseName + ", image=" + Arrays.toString(image)
				+ ", base64=" + base64 + ", subCategory=" + subCategory + "]";
	}

}
