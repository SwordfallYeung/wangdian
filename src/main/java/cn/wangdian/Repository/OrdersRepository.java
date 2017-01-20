package cn.wangdian.Repository;

import cn.wangdian.Model.Orders;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by 25065 on 2016/9/15.
 */
public interface OrdersRepository extends JpaRepository<Orders,String>,JpaSpecificationExecutor<Orders> {

//    @Query("select distinct(o.shopType) from Orders o ")
//    public List<String> countShopType(Specification<Orders> ordersSpecification);
//
//    @Query("select o.number from Orders o where lower(o.id)=lower(:id)")
//    public String findNumberById(@Param("id") Integer id);

//    @Query("select o from User o where lower(o.username)=lower(:username) ")
//    public User selectByUsername(@Param("username") String username);

    @Query("select o from Orders o where lower(o.id)=lower(:id) ")
    public Orders findById(@Param("id") Integer id);

    @Query("select o from Orders o where lower(o.shopOrderId)=lower(:shopOrderId) ")
    public Orders findByShopOrderId(@Param("shopOrderId") String shopOrderId);

    @Query("select o.status from Orders o where lower(o.shopOrderId)=lower(:shopOrderId) ")
    public int findStatusByByShopOrderId(@Param("shopOrderId") String shopOrderId);

    @Modifying
    @Query("update Orders o set o.status=:status where lower(o.shopOrderId)=lower(:shopOrderId) ")
    public void updateStatusByShopOrderId(@Param("status") Integer status,@Param("shopOrderId") String shopOrderId);

    @Modifying
    @Query("update Orders o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);

    @Modifying
    @Query("update Orders o set o.isDelFromUser=1 where lower(o.id)=lower(:id) ")
    public void deleteIsDelFromUser1ByPrimaryKey(@Param("id") Integer id);

    @Query("select o from Orders o where o.isDel=0 and o.isDelFromUser=0 and o.shopOrderMan=:username order by o.shopOrderTime desc ")
    public List<Orders> findAllByIsDel0AndIsDelFromUser0AndUsername(@Param("username") String username);

    @Query("select o.profits from Orders o where o.shopKeeper=:shopKeeper and o.status=3")
    public List<Float> findAllByShopKeeperAndStatus3(@Param("shopKeeper") String shopKeeper);
}
