package com.spring.courses.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@SuppressWarnings("serial")
@Entity
@Table
public class Adobe implements Serializable {

	public Adobe() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	private String courseName;
	private byte[] image;
	private String base64;
	private Integer mId;
	private byte[] file;
	private String filename;
	private String base641;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sId", referencedColumnName = "courseName")
	private List<CourseDetails> details;

	public List<CourseDetails> getDetails() {
		return details;
	}

	public void setDetails(List<CourseDetails> details) {
		this.details = details;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Transient
	public String getBase64() {
		return this.base64 = Base64.encode(this.image);
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	@Transient
	public String getBase641() {
		return this.base641 = Base64.encode(this.file);
	}

	public void setBase641(String base641) {
		this.base641 = base641;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
