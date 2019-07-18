package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.dao.MemoDao;
import com.biz.memo.model.MemoVO;

@Service
public class MemoService {
	@Autowired
	SqlSession sqlSession;

	public int insert(MemoVO memoVO) {
		// TODO Auto-generated method stub
		MemoDao mDao = sqlSession.getMapper(MemoDao.class);

		List<MemoVO> mList = mDao.selectAll();

		int ret = mDao.insert(memoVO);

		return ret;
	}

	public List<MemoVO> selectAll() {
		// TODO Auto-generated method stub
		MemoDao mDao = sqlSession.getMapper(MemoDao.class);
		List<MemoVO> memoList = mDao.selectAll();

		return memoList;
	}

	public MemoVO findBySeq(long mo_seq) {
		// TODO Auto-generated method stub
		MemoDao mDao = sqlSession.getMapper(MemoDao.class);
		MemoVO memoVO = mDao.findBySeq(mo_seq);
		return memoVO;
	}

	public int write(MemoVO memoVO) {
		
		MemoDao mDao = sqlSession.getMapper(MemoDao.class);
		
		/*
		 * 만약 메모를 새로 작성하는 경우는 form에서 mo_seq 에
		 * default 값으로 0을 세팅할 것이고
		 * 수적으로 작성하는 경우는 controller에서 보낸 memoVO의 mo_seq 값이 세팅되어 있을것이다.
		 * 
		 * 즉
		 * 매개변수로 받은 memoVO의 mo_seq값이 0보다 크면
		 * 기존 데이터를 수정하는 상태일 것이고
		 * 아니면 새로 작성한 상태일 것이므로
		 * 
		 * 이 값을 검사하여 update, insert를 수행
		 */
		
		long mo_seq = memoVO.getMo_seq();
		if (mo_seq > 0)
			mDao.update(memoVO);
		else
			mDao.insert(memoVO);

		return 0;
	}

	public int delete(long mo_seq) {
		// TODO Auto-generated method stub
		MemoDao mDao = sqlSession.getMapper(MemoDao.class);
		mDao.delete(mo_seq);
		return 0;
	}

}
