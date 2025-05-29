package edu.kh.project.admin.model.service;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	/**
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);

	/** 최대 게시물
	 * @return
	 */
	Board maxReadCount();

	/** 최대 좋아요 수
	 * @return
	 */
	Board maxLikeCount();

	/** 최대 댓글 수
	 * @return
	 */
	Board maxCommentCount();
	
	

}
