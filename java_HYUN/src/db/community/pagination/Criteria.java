package db.community.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// 현재 페이지 정보를 나타내는 클래스
public class Criteria {

	protected int page = 1;
	protected int perPageNum = 5; // 현재 페이지의 최대 컨텐츠 수
	
	protected String search = "";
	
	public Criteria(int page, String search) {
		this.page = page;
		this.search = search;
	}
	
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}
