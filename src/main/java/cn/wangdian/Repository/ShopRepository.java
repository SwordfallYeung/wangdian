package cn.wangdian.Repository;

import cn.wangdian.Model.Shop;
import cn.wangdian.Model.User;
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
public interface ShopRepository extends JpaRepository<Shop,String>,JpaSpecificationExecutor<Shop> {

    @Query("select o from Shop o where o.isDel=0 and o.status=0")
    public List<Shop> findAllByIsDel0();

    @Query("select o from Shop o where o.isDel=0 and o.status=0 and lower(o.name) like CONCAT('%',:shopName,'%') ")
    public List<Shop> findAllByIsDel0AndShopName(@Param("shopName") String shopName,Pageable pageable);

    @Query("select o from Shop o where o.isDel=0 and o.status=0 and o.isRecommend=1")
    public List<Shop> findAllByIsDel0AndIsRecommend1Limit20(Pageable pageable);

    @Query("select distinct (o.shopType) from Shop o where o.isDel=0 and o.status=0")
    public List<String> findAllShopTypeByIsDel0();

    @Query("select distinct (o.shopModel) from Shop o where o.isDel=0 and o.status=0 and o.shopType=:shopType")
    public List<String> findAllShopModelByIsDel0AndType(@Param("shopType") String shopType);

    @Query("select o from Shop o where o.isDel=0 and o.status=0 and o.shopType=:shopType and o.shopModel=:shopModel")
    public List<Shop> findAllByIsDel0AndShopTypeAndShopModel(@Param("shopType") String shopType,@Param("shopModel") String shopModel,Pageable pageable);

    @Query("select o.number from Shop o where lower(o.number)=lower(:number)")
    public String checkNumber(@Param("number") String number);

    @Query("select o.number from Shop o where lower(o.id)=lower(:id)")
    public String findNumberById(@Param("id") Integer id);

//    @Query("select o from User o where lower(o.username)=lower(:username) ")
//    public User selectByUsername(@Param("username") String username);

    @Query("select o from Shop o where lower(o.id)=lower(:id) ")
    public Shop findById(@Param("id") Integer id);

    @Modifying
    @Query("update Shop o set o.status=:status where lower(o.id)=lower(:id) ")
    public void shangXiaJia(@Param("id") Integer id, @Param("status") Integer status);

    @Modifying
    @Query("update Shop o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);


}
