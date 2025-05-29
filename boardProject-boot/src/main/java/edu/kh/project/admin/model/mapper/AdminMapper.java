package edu.kh.project.admin.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	/** 관리자 로그인
	 * @param memberEmail
	 * @return
	 */
	Member login(String memberEmail);

	/** 게시글
	 * @return
	 */
	Board maxReadCount();

	/** 좋아요
	 * @return
	 */
	Board maxLikeCount();

	/** 댓글
	 * @return
	 */
	Board maxCommentCount();

}
