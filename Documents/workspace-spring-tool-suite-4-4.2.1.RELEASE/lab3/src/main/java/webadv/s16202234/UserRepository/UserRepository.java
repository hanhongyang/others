package webadv.s16202234.UserRepository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import webadv.s16202234.entity.User;
@Mapper
public interface UserRepository {
	
	@Results(id="userMap", value={ 
    @Result(property = "account", column = "user_account"),
    @Result(property = "password", column = "user_password")
	})

	@Select("select * from lab3_user1") 
	public List<User> findAll();
	
	@Select("select * from lab3_user1 where user_account=#{account} and user_password=#{password}")
	@ResultMap(value="userMap")
	public User validUser(@Param("account")String account,@Param("password")String password);
	

}
