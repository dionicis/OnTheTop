package service;

import vo.UserVO;

import java.util.List;

public interface OnTheTopService {
	/**
	 * 라이엇 API 를 통해 유저정보를 가져온다
	 * @return 유저리스트
	 */
	List<UserVO> getLolRankingInfo();
}
