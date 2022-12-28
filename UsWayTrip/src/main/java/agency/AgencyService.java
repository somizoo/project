package agency;

import java.util.List;

public class AgencyService {
	public AgencyDAO agencyDao;
	
	public void setAgencyDao(AgencyDAO agencyDao) {
		this.agencyDao = agencyDao;
	}
	
	public List<AgencyVO> selectList() {
		List<AgencyVO> agencyList = agencyDao.selectList();
		
		if(agencyList.isEmpty()) {
			agencyList = null;
		}
		return agencyList;
	}
	
	public int insert(AgencyVO vo) {
		int check = agencyDao.insert(vo);
		
		return check;
	}
	
	public AgencyVO selectOne(int agency_no) {
		return agencyDao.selectOne(agency_no);
	}
	
	public int update(AgencyVO vo) {
		return agencyDao.update(vo);
	}
	
	public int delete(int agency_no) {
		return agencyDao.delete(agency_no);
	}
}
