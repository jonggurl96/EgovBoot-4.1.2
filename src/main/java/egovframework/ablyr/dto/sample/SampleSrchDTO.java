package egovframework.ablyr.dto.sample;


import egovframework.ablyr.dto.SearchDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleSrchDTO extends SearchDTO {
	
	private int num;
	
	public SampleSrchDTO(int num, String searchCondition, int pageSize) {
		super();
		this.num = num;
		super.searchCondition = searchCondition;
		setPageSize(pageSize);
	}
	
}
