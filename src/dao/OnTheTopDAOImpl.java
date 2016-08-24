package dao;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vo.UserVO;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OnTheTopDAOImpl implements OnTheTopDAO {
	private SqlSessionFactory factory  = ConnectionManager.getInstance().getFactory();

	@Override
	public List<UserVO> getTargetUserIdListFromDB() {
		// DB 조회 및 리턴
		SqlSession ss = factory.openSession(true);
		List<UserVO> list = ss.selectList("selectAll");
		ss.close();
		System.out.println("파일 가져오기 끝");
		return list;
	}

	// JSON파일에서 대상 추출
	// DB 연결 후 삭제
	@Override
	public List<UserVO> getTargetUserIdListFromJson() {
		ArrayList list = new ArrayList();

		File jFile = new File("/json/id.json");

		try {
			JsonArray e = Json.createReader(new FileReader(jFile)).readArray();

			for(int i = 0; i < e.size(); ++i) {
				JsonObject tmpJO = e.getJsonObject(i);
				int id = tmpJO.getInt("id");
				String name = tmpJO.getString("name");
				UserVO vo = new UserVO();
				vo.setId(id);
				vo.setName(name);
				list.add(vo);
			}
		} catch (FileNotFoundException var9) {
			System.out.println("no json file : 절대경로로 json 위치 수정해줘야함");
		}
		return list;
	}
}
