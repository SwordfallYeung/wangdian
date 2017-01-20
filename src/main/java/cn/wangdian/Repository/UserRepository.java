package cn.wangdian.Repository;

import cn.wangdian.Model.ShopKeeper;
import cn.wangdian.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 25065 on 2016/9/15.
 */
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {

    @Query("select o.username from User o where lower(o.username)=lower(:username)")
    public String checkUsername(@Param("username") String username);

    @Query("select distinct (o.telephone) from User o where lower(o.telephone)=lower(:telephone)")
    public String checkTelePhone(@Param("telephone") String telephone);

    @Query("select distinct (o.email) from User o where lower(o.email)=lower(:email)")
    public String checkEmail(@Param("email") String email);

    @Query("select o.username from User o where lower(o.id)=lower(:id)")
    public String findUsernameById(@Param("id") Integer id);

    @Query("select o from User o where lower(o.username)=lower(:username) ")
    public User selectByUsername(@Param("username") String username);

    @Query("select o from User o where lower(o.email)=lower(:email) ")
    public User selectByEmail(@Param("email") String email);

    @Query("select o from User o where lower(o.telephone)=lower(:telephone) ")
    public User selectByTelephone(@Param("telephone") String telephone);

    @Query("select o.password from User o where lower(o.email)=lower(:email) ")
    public String selectPasswordByEmail(@Param("email") String email);

    @Query("select o from User o where lower(o.id)=lower(:id) ")
    public User findById(@Param("id") Integer id);

    @Query("select o.password from User o where lower(o.id)=lower(:id) ")
    public String selectPasswordById(@Param("id") Integer id);

    @Modifying
    @Query("update User o set o.password=:password where lower(o.email)=lower(:email) ")
    public void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query("update User o set o.password=:password where lower(o.id)=lower(:id) ")
    public void updatePasswordById(@Param("password") String password, @Param("id") Integer id);

    @Modifying
    @Query("update User o set o.nickname=:nickname where lower(o.id)=lower(:id) ")
    public void updateNicknameById(@Param("nickname") String nickname, @Param("id") Integer id);

    @Modifying
    @Query("update User o set o.email=:email where lower(o.id)=lower(:id) ")
    public void updateEmailById(@Param("email") String email, @Param("id") Integer id);

    @Modifying
    @Query("update User o set o.telephone=:telephone where lower(o.id)=lower(:id) ")
    public void updateTelephoneById(@Param("telephone") String telephone, @Param("id") Integer id);

    @Modifying
    @Query("update User o set o.status=:status where lower(o.id)=lower(:id) ")
    public void suoJieDing(@Param("id") Integer id, @Param("status") Integer status);

    @Modifying
    @Query("update User o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);
}
