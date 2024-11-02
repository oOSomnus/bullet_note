package han.z.gateway.mapper;

import han.z.gateway.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT username, password, roles FROM users WHERE username = #{username}")
    User findByUsername(String username);
}