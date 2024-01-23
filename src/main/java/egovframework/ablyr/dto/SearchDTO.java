package egovframework.ablyr.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("srch")
public class SearchDTO extends PaginationInfo {
	
	/**
	 * 검색 조건
	 */
	protected String searchCondition;
	
	/**
	 * 검색 키워드
	 */
	protected String searchKeyword;
	
	/**
	 * 검색 날짜 범위 시작
	 */
	protected String startDate;
	
	/**
	 * 검색 날짜 범위 끝
	 */
	protected String endDate;
	
	/**
	 * Record Count Per Page
	 *
	 * @param pageUnit
	 */
	public void setPageUnit(int pageUnit) {
		super.setRecordCountPerPage(pageUnit);
	}
	
	/**
	 * Size of Page List
	 *
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		super.setPageSize(pageSize);
	}
	
	/**
	 * @return LIMIT ...
	 */
	public int getLimit() {
		return getRecordCountPerPage();
	}
	
	/**
	 * @return OFFSET ...
	 */
	public int getOffset() {
		return getFirstRecordIndex();
	}
	
	public boolean isExistsKwrdCondition() {
		if(searchKeyword == null || searchKeyword.isBlank())
			return false;
		return searchCondition != null && !searchCondition.isBlank();
	}
	
}
