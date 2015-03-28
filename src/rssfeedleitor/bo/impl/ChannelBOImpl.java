package rssfeedleitor.bo.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.dao.ChannelDAO;

public class ChannelBOImpl implements ChannelBO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryBOImp.class);

	@Inject
	private ChannelDAO channelDAO;

	public void updateToDefaultCategory(Integer id, Integer defaultCategoryId) {
		logger.debug("updateToDefaultCategory()...");
		
		channelDAO.updateToDefaultCategory(id, defaultCategoryId);

	}

}
