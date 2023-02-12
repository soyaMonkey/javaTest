package net.codejava.javatest;

public class StudentInfo {
	private String dept;
	private String studentId;
	private String studentName;
	private Integer mark;
	private Double passingRate = 0.0;
	
	public StudentInfo(String dept, String studentId, String studentName, Integer mark) {
		this.dept = dept;
		this.studentId = studentId;
		this.studentName = studentName;
		this.mark = mark;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Double getPassingRate() {
		return passingRate;
	}

	public void setPassingRate(Double passingRate) {
		this.passingRate = passingRate;
	}
}
