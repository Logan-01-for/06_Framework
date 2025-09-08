package edu.kh.project.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	/** 회원 탈퇴 취소 리스트 조회
	 * 
	 */
	List<Member> selectWithdrawnMemberList = null;
	
	/** 삭제된 게시글 리스트 조회
	 * 
	 */
	List<Board> selectDeleteBoardList = null;
	
	
	/** 삭제된 회원 조회
	 * 
	 */
	int restoreMember = 0;
	
	/** 삭제된 게시글 조회
	 * 
	 */
	int restoreBoard = 0;

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

	/**  관리자 이메일 중복 여부 검사
	 * @param memberEmail
	 * @return
	 */
	int checkEmail(String memberEmail);

	/** 관리자 계정 발급
	 * @param member
	 * @return
	 */
	int createAdminAccount(Member member);

}
