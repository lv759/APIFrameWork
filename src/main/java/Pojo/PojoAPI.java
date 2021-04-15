package Pojo;

public class PojoAPI {
	
private int id;
private String name;
private String job;
private int subjectid;

public PojoAPI(int id, String name, String job, int subjectid) {
	this.id = id;
	this.name = name;
	this.job = job;
	this.subjectid = subjectid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public int getSubjectid() {
	return subjectid;
}
public void setSubjectid(int subjectid) {
	this.subjectid = subjectid;
}
@Override
public String toString() {
	return "PojoAPI [id=" + this.id + ", name=" + this.name + ", job=" + this.job + ", subjectid=" + this.subjectid + "]";
}


}
