package dev.domain;

public class Comment {
	//-------------Comment
	private int commentId;
	private String memberId;
	private int boardId;
	private String content;
	private String commentDate;
	// -- 조인문 활용
	private String nickName;
	private String profile;



	//--------생성자
	public Comment() {};
	
	
	public Comment(int commentId, String memberId, int boardId, String content, String commentDate,
			String nickName, String profile) {
		super();
		this.commentId = commentId;
		this.memberId = memberId;
		this.boardId = boardId;
		this.content = content;
		this.commentDate = commentDate;
		this.nickName = nickName;
		this.profile = profile;
	}


	//--------getter setter
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", memberId=" + memberId + ", boardId=" + boardId + ", content="
				+ content + ", commentDate=" + commentDate + ", nickName=" + nickName + "]";
	}
	
}
