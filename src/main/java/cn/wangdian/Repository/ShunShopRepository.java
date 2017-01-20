package cn.wangdian.Repository;

import cn.wangdian.Model.Shop;
import cn.wangdian.Model.ShunShop;
import cn.wangdian.Model.UserAddress;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 25065 on 2016/9/15.
 */
public interface ShunShopRepository extends JpaRepository<ShunShop,String>,JpaSpecificationExecutor<ShunShop> {

    @Query("select o from ShunShop o where o.isDel=0 and o.status=0 ")
    public List<ShunShop> findAllByIsDel0Limit20(Pageable pageable);

    @Query("select o.number from ShunShop o where lower(o.number)=lower(:number)")
    public String checkNumber(@Param("number") String number);

    @Query("select o.number from ShunShop o where lower(o.id)=lower(:id)")
    public String findNumberById(@Param("id") Integer id);

//    @Query("select o from User o where lower(o.username)=lower(:username) ")
//    public User selectByUsername(@Param("username") String username);

    @Query("select o from ShunShop o where lower(o.id)=lower(:id) ")
    public ShunShop findById(@Param("id") Integer id);

    @Modifying
    @Query("update ShunShop o set o.status=:status where lower(o.id)=lower(:id) ")
    public void shangXiaJia(@Param("id") Integer id, @Param("status") Integer status);

    @Modifying
    @Query("update ShunShop o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);
}
