package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;

import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.mapper.ChannelMapper;
import rssfeedleitor.model.Channel;


public class ChannelDAOImpl implements ChannelDAO{

	private static final Logger logger = LogManager.getLogger(ChannelDAOImpl.class);
	
	@Inject 
	@Mapper
	private ChannelMapper channelMapper;
	
	public void insert(Channel channel) {
		logger.debug("insert...");
		channelMapper.insert(channel);
	}

	@Override
	public List<Channel> findAll() {
		logger.debug("findAll...");
		return channelMapper.findAll();
	}

	@Override
	public Channel findById(Integer id) {
		logger.debug("findById...");
		return channelMapper.findById(id);
	}

}
