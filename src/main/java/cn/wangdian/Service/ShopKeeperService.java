package cn.wangdian.Service;

import cn.wangdian.Model.Admin;
import cn.wangdian.Model.ShopKeeper;
import cn.wangdian.Repository.ShopKeeperRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by 25065 on 2016/9/15.
 */
@Service
public class ShopKeeperService {

    @Autowired
    private ShopKeeperRepository shopKeeperRepository;


    public Page<ShopKeeper> findAllByIsDel0(final String username, final String nickname, final Integer status, String orderField, String orderDirection, PageRequest pageRequest) throws Exception{

        //特殊情况查询
        Specification<ShopKeeper> shopKeeperSpecification=new Specification<ShopKeeper>() {
            @Override
            public Predicate toPredicate(Root<ShopKeeper> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //匹配属性和属性对应的值
                predicate=criteriaBuilder.equal(root.get("isDel"),0);

                //添加
                predicateList.add(criteriaBuilder.and(predicate));

                if (username!=null&&!username.equals("")){
                    Path<String> stringPath=root.get("username");
                    predicate=criteriaBuilder.like(stringPath,"%"+username+"%");
                    predicateList.add(criteriaBuilder.and(predicate));
                }

                if (nickname!=null&&!nickname.equals("")){
                    Path<String> stringPath=root.get("nickname");
                    predicate=criteriaBuilder.like(stringPath,"%"+nickname+"%");
                    predicateList.add(criteriaBuilder.and(predicate));
                }

                if (status!=null&&!status.equals("")){
                    predicate=criteriaBuilder.equal(root.get("status"),status);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort;
        if (orderDirection!=null&&!orderDirection.equals("")&&orderField!=null&&!orderField.equals("")){
            sort=new Sort(Sort.Direction.fromString(orderDirection),orderField);
        }else {
            sort=new Sort(Sort.Direction.ASC,"id");
        }
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);

        Page<ShopKeeper> shopKeeperPage=null;
        try {
            shopKeeperPage=shopKeeperRepository.findAll(shopKeeperSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shopKeeperPage.getTotalElements()>0?shopKeeperPage:null;
    }

    public Integer countAllByIsDel0(final String username, final String nickname, final Integer status) throws Exception{

        //特殊情况查询
        Specification<ShopKeeper> shopKeeperSpecification=new Specification<ShopKeeper>() {
            @Override
            public Predicate toPredicate(Root<ShopKeeper> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //匹配属性和属性对应的值
                predicate=criteriaBuilder.equal(root.get("isDel"),0);

                //添加
                predicateList.add(criteriaBuilder.and(predicate));

                if (username!=null&&!username.equals("")){
                    Path<String> stringPath=root.get("username");
                    predicate=criteriaBuilder.like(stringPath,"%"+username+"%");
                    predicateList.add(criteriaBuilder.and(predicate));
                }

                if (nickname!=null&&!nickname.equals("")){
                    Path<String> stringPath=root.get("nickname");
                    predicate=criteriaBuilder.like(stringPath,"%"+nickname+"%");
                    predicateList.add(criteriaBuilder.and(predicate));
                }

                if (status!=null&&!status.equals("")){
                    predicate=criteriaBuilder.equal(root.get("status"),status);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        long count=0;
        try {
            count=shopKeeperRepository.count(shopKeeperSpecification);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Long(count).intValue();
    }


    public String checkUsername(String username){
        return shopKeeperRepository.checkUsername(username);
    }

    public String findUsernameById(Integer id){
        return shopKeeperRepository.findUsernameById(id);
    }

    public void update(ShopKeeper shopKeeper){
        shopKeeperRepository.saveAndFlush(shopKeeper);
    }

    @Transactional
    public void updateAllProfitById(float allProfit,Integer id){
        shopKeeperRepository.updateAllProfitById(allProfit,id);
    }

    public void save(ShopKeeper shopKeeper){
        shopKeeperRepository.save(shopKeeper);
    }

    public ShopKeeper selectByUsername(String username){
        return shopKeeperRepository.selectByUsername(username);
    }

    public ShopKeeper findById(Integer id){
        return shopKeeperRepository.findById(id);
    }

    public String findWebUrlBySecondDomain(String secondDomain){
        return shopKeeperRepository.findWebUrlBySecondDomain(secondDomain);
    }

    @Transactional
    public void suoDingById(Integer id){
        shopKeeperRepository.suoJieDing(id,1);
    }

    @Transactional
    public void jieDingById(Integer id){
        shopKeeperRepository.suoJieDing(id,0);
    }

    @Transactional
    public void deleteByPrimaryKey(Integer id){
        shopKeeperRepository.deleteByPrimaryKey(id);
    }

    @Transactional
    public void updateMessageByPrimaryKey(String message,Integer id){
        shopKeeperRepository.updateMessageByPrimaryKey(message,id);
    }

    @Transactional
    public void updateMessageAndYiTiXianById(String message,float money,Integer id){
        shopKeeperRepository.updateMessageAndYiTiXianById(message,money,id);
    }

    @Transactional
    public void updateMessageById(String message,Integer id){
        shopKeeperRepository.updateMessageById(message,id);
    }
}
