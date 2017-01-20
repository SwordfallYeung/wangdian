package cn.wangdian.Repository;

import cn.wangdian.Model.YuMing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 25065 on 2016/9/18.
 */
public interface YuMingRepository extends JpaRepository<YuMing,String>,JpaSpecificationExecutor<YuMing> {


}
