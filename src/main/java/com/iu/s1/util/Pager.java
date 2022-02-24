package com.iu.s1.util;

public class Pager {
	
	//페이지당 보여줄 row의 갯수
	private Long perPage;
	
	//페이지 번호
	private Long page;
	
	//시작번호
	private Long startRow;
	
	//끝번호
	private Long lastRow;
	
	//-----JSP 변수 사용
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public void makeRow() {
		this.startRow = (this.page-1)*this.perPage+1;
		this.lastRow = this.page*this.perPage;
		
	}
	
	public void makeNum() {
		//1. 전체 row의 갯수 구하기
		Long totalCount=412L;
		
		//2. 전체 page의 갯수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPage() !=0) {
			totalPage++;
		}
		
		//3. 블럭당 갯수
		Long perBlock=10L;
		
		//4. 전체 Block의 갯수 구하기
		Long totalBlock=totalPage/perBlock;
		if(totalPage%totalBlock !=0) {
			totalBlock++;
		}
		//5. page 번호로 몇번째 
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		
		//6. curBlock로 startNum, lastNum 구하기
		
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		//7. 이전, 다음 브럭 유무
		
		this.pre=false;
		if(curBlock>1) {
			//현재 block이 2,3,4...
			this.pre=true;
			
		}
		
		this.next=true;
		if(totalBlock > curBlock) {
			this.next=false;	
		
		}
		
		//현재 블럭이 마지막 블럭번호와 같다면
	}
	
		
	public Long getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if(this.page==null || this.perPage<1) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
}
