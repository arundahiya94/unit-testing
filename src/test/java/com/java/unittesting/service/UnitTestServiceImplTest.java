package com.java.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.unittesting.dao.UnitTestDao;

@ExtendWith(MockitoExtension.class)
public class UnitTestServiceImplTest {

	@InjectMocks
	UnitTestServiceImpl serviceImpl = new UnitTestServiceImpl();

	@Mock
	UnitTestDao unitTestDao = mock(UnitTestDao.class);

	/** Not needed if we use @InjectMock annotation **/
//	@BeforeEach
//	public void before() {
//		serviceImpl.setUnitTestDao(unitTestDao);
//	}

	@Test
	public void testGetSumOfRecords() {
		when(unitTestDao.getAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, serviceImpl.getSumOfRecords());
	}
	
	@Test
	public void testGetSumOfZeroRecords() {
		when(unitTestDao.getAllData()).thenReturn(new int[] {});
		assertEquals(0, serviceImpl.getSumOfRecords());
	}
	
	@Test
	public void testGetSumOfOneRecord() {
		when(unitTestDao.getAllData()).thenReturn(new int[] {5});
		assertEquals(5, serviceImpl.getSumOfRecords());
	}
}
