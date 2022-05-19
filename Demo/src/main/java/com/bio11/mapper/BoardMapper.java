package com.bio11.mapper;

import java.util.List;

import com.bio11.domain.BoardVO;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno > 0")
	// @Select 이걸 안쓰려면 BoardMapper.xml 설정 후 사용
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long id);
	
	public int delete(Long id);
	
	public int update(BoardVO board);
}
