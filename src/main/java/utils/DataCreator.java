package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class DataCreator {

	public static String getName() {
		String addname = RandomStringUtils.randomAlphabetic(5);
		return ("K" + addname);
	}
	public static String getJob() {
		String addjob = RandomStringUtils.randomAlphabetic(5);
		return ("T" + addjob);
	}

	public static String getemployeename() {
		String ename = RandomStringUtils.randomAlphabetic(4);
		return ("T" + ename);
	}

	public static String getemployeesalary() {
		String esal = RandomStringUtils.randomAlphanumeric(4);
		return esal;
	}

	public static String getemployeeage() {
		String eage = RandomStringUtils.randomAlphanumeric(2);
		return eage;
	}


	
}
