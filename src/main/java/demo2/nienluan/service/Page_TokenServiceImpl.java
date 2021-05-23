package demo2.nienluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo2.nienluan.dao.Page_TokenDAO;
import demo2.nienluan.model.Page_Token;

@Service
@Transactional
public class Page_TokenServiceImpl implements Page_TokenService{
	@Autowired
	private Page_TokenDAO ptd;
	
	
	@Override
	public Page_Token getAll() {
		return ptd.getAll();
	}

	@Override
	public void edit(Page_Token ptk) {
		ptd.edit(ptk);
		
	}

	@Override
	public Page_Token getById(Integer id) {
		return ptd.getById(id);
	}

	@Override
	public void resetPageToken() {
		Page_Token temp = ptd.getById(1);
		temp.setId_page(null);
		temp.setToken(null);
		temp.setLink_page(null);
		temp.setName_page(null);
		ptd.edit(temp);	
	}

	

}
