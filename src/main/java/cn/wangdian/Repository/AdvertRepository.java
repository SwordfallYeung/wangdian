package cn.wangdian.Repository;

import cn.wangdian.Model.Admin;
import cn.wangdian.Model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 25065 on 2016/9/19.
 */
public interface AdvertRepository extends JpaRepository<Advert,String>,JpaSpecificationExecutor<Advert> {

    @Query("select o from Advert o where lower(o.id)=lower(:id) ")
    public Advert findById(@Param("id")Integer id);

    @Modifying
    @Query("update Advert o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);
}
