package com.forum;

import java.util.List;

public class Pagination {

	public static int[] pagination(List list, int page, int rowsPerPage) {

		int[] paging = new int[2];
		int totalPages; // 總頁數
		if (list.size() % rowsPerPage != 0) {
			totalPages = list.size() / rowsPerPage + 1;
		} else {
			totalPages = list.size() / rowsPerPage;
		} // 總頁數=總筆數除以每頁筆數，若總筆數與每頁筆數不整除，則再+1頁

		int[] pageIndexArray = new int[totalPages]; // 頁數索引陣列，長度為總頁數
		for (int i = 1; i <= pageIndexArray.length; i++) {
			pageIndexArray[i - 1] = (i - 1) * rowsPerPage;
		} // 陣列[0] = 0，陣列[1] = 10，陣列[2] = 20... 以此類推

		int pageStart = pageIndexArray[page - 1]; // 起始頁數

		paging[0] = pageStart;
		paging[1] = totalPages;

		return paging;
	}
}
