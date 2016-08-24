package dao;

import vo.UserVO;

import java.util.List;

public interface OnTheTopDAO {

	/**
	 * 검색 대상 UserId List 반환 (DB)
	 * @return TargetUserIdList
	 */
	List<UserVO> getTargetUserIdListFromDB();

	/**
	 * 검색 대상 UserId List 반환 (JSON File)
	 * @return TargetUserIdList
	 */
	List<UserVO> getTargetUserIdListFromJson();
}
