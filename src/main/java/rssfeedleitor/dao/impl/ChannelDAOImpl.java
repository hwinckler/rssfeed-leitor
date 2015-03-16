package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.mapper.ChannelMapper;
import rssfeedleitor.model.Channel;


public class ChannelDAOImpl implements ChannelDAO{

	private static final Logger logger = LoggerFactory.getLogger(ChannelDAOImpl.class);
	
	@Inject 
	private SqlSessionFactory sqlSessionFactory;
	
	public void insert(Channel channel) {
		logger.debug("insert...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			channelMapper.insert(channel);
			session.commit();
		}
	}

	@Override
	public List<Channel> findAll() {
		logger.debug("findAll...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			return channelMapper.findAll();
		}
	}

	@Override
	public Channel findById(Integer id) {
		logger.debug("findById...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			return channelMapper.findById(id);
		}
	}

}
