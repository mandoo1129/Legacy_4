package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;
@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.total(pager));
		
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception{
		// QnaDTO.num		: 부모글의 번호
		// QnaDTO.title		: 폼에서 입력한 제목
		// QnaDTO.writer	: 폼에서 입력한 작성자
		// QnaDTO.contents	: 폼에서 입력한 내용
		// QnaDTO.regDate	: null
		// QnaDTO.hit		: null
		// QnaDTO.ref		: null
		// QnaDTO.step		: null
		// QnaDTO.depth		: null
		//1. 부모글 조회(ref, step, depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		//2. 답글의 ref는 부모의 ref값
		qnaDTO.setRef(parent.getRef());
		
		//3. 답글의 step은 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		//4. 답글의 depth는 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//5. step update
		int result = qnaDAO.stepUpdate(parent);
		
		//6. 답글 insert
		result = qnaDAO.reply(qnaDTO);

		
		return result;
	}

}