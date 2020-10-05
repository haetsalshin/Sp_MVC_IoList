package com.biz.iolist.service;

import com.biz.iolist.model.IoListVO;

public interface IoService extends GenericService<IoListVO, Long>  {
	
	public IoListVO findByDate(String io_firstday, String io_lastday);

}
