package com.java.unittesting.service;

import com.java.unittesting.dao.UnitTestDao;

public class UnitTestServiceImpl implements UnitTestService {

	private UnitTestDao unitTestDao;

	@Override
	public int getSumOfRecords() {
		int sum = 0;
		int[] arr = getUnitTestDao().getAllData();
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	public UnitTestDao getUnitTestDao() {
		return unitTestDao;
	}

	public void setUnitTestDao(UnitTestDao unitTestDao) {
		this.unitTestDao = unitTestDao;
	}

}
