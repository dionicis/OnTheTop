package service;

import dao.OnTheTopDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.OnTheTopUtil;
import vo.UserVO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.List;

@Service
public class OnTheTopServiceImpl implements OnTheTopService {
	@Autowired
	private OnTheTopDAO onTheTopDAO;

	/*
	* db로 부터 목록을 가져옴
	* */
	private List<UserVO> getUserIdList() {
		List<UserVO> targetUserIdList = onTheTopDAO.getTargetUserIdListFromDB();
		//		List<UserVO> targetUserIdList = onTheTopDAO.getTargetUserIdListFromDB();
		return targetUserIdList;
	}

	/*
	*
	* db로부터 가져온 내용을 tier, division, lp 기준으로 분류
	* */
	@Override
	public List<UserVO> getLolRankingInfo() {
		List<UserVO> userIdList = getUserIdList();
		userIdList.sort(new Comparator<UserVO>() {
			@Override
			public int compare(UserVO o1, UserVO o2) {
				OnTheTopUtil util = OnTheTopUtil.getInstance();
				int tier = util.tierOrDivToNum(o1.getTier(), util.getTierArr());
				int compTier = util.tierOrDivToNum(o2.getTier(), util.getTierArr());

				if (tier > compTier)
					return -1;
				else if (tier < compTier)
					return 1;
				else {
					int div = util.tierOrDivToNum(o1.getDivision(), util.getDivArr());
					int compDiv = util.tierOrDivToNum(o2.getDivision(), util.getDivArr());
					if (div > compDiv)
						return -1;
					else if (div < compDiv)
						return 1;
					else {
						int point = o1.getLeaguePoints();
						int compPoint = o2.getLeaguePoints();
						if (point > compPoint)
							return -1;
						else if (point < compPoint)
							return 1;
						else
							return 0;
					}
				}
			}
		});
		System.out.println("서비스 끝");
		return userIdList;
	}
}
