package cn.wangdian.Repository;

import cn.wangdian.Model.Admin;
import cn.wangdian.Model.ShopKeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 25065 on 2016/9/15.
 */
public interface ShopKeeperRepository extends JpaRepository<ShopKeeper,String>,JpaSpecificationExecutor<ShopKeeper> {

    @Query("select o.username from ShopKeeper o where lower(o.username)=lower(:username)")
    public String checkUsername(@Param("username")String username);

    @Query("select o.username from ShopKeeper o where lower(o.id)=lower(:id)")
    public String findUsernameById(@Param("id")Integer id);

    @Query("select o from ShopKeeper o where lower(o.username)=lower(:username) ")
    public ShopKeeper selectByUsername(@Param("username")String username);

    @Query("select o from ShopKeeper o where lower(o.id)=lower(:id) ")
    public ShopKeeper findById(@Param("id")Integer id);

    @Query("select o.webUrl from ShopKeeper o where lower(o.webUrl)=lower(:secondDomain) ")
    public String findWebUrlBySecondDomain(@Param("secondDomain")String secondDomain);

    @Modifying
    @Query("update ShopKeeper o set o.status=:status where lower(o.id)=lower(:id) ")
    public void suoJieDing(@Param("id")Integer id,@Param("status")Integer status);

    @Modifying
    @Query("update ShopKeeper o set o.allProfit=:allProfit where lower(o.id)=lower(:id) ")
    public void updateAllProfitById(@Param("allProfit")float allProfit,@Param("id")Integer id);

    @Modifying
    @Query("update ShopKeeper o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id")Integer id);


    @Modifying
    @Query("update ShopKeeper o set o.message=:message where lower(o.id)=lower(:id) ")
    public void updateMessageByPrimaryKey(@Param("message")String message,@Param("id")Integer id);

    @Modifying
    @Query("update ShopKeeper o set o.message=:message,o.yiTiXian=:money where lower(o.id)=lower(:id) ")
    public void updateMessageAndYiTiXianById(@Param("message")String message,@Param("money")float money,@Param("id")Integer id);

    @Modifying
    @Query("update ShopKeeper o set o.message=:message where lower(o.id)=lower(:id) ")
    public void updateMessageById(@Param("message")String message,@Param("id")Integer id);
}
