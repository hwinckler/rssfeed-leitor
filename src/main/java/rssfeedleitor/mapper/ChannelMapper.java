package rssfeedleitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import rssfeedleitor.model.Channel;

public interface ChannelMapper {

	@Insert("INSERT INTO channel(title, link, lastSynchronize, synchronize) VALUES(#{title}, #{link}, #{lastSynchronize}, #{synchronize})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Channel channel);
	
	@Select("SELECT * FROM channel ORDER BY id DESC")
	public List<Channel> findAll();

	@Select("SELECT * FROM channel WHERE id = #{id}")
	public Channel findById(Integer id);
}
