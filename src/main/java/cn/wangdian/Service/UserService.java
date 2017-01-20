package cn.wangdian.Service;

import cn.wangdian.Model.ShopKeeper;
import cn.wangdian.Model.User;
import cn.wangdian.Repository.ShopKeeperRepository;
import cn.wangdian.Repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by 25065 on 2016/9/15.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Page<User> findAllByIsDel0(final String username, final String nickname, final Integer status, String orderField, String orderDirection, PageRequest pageRequest) throws Exception{

        //特殊情况查询
        Specification<User> userSpecification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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

        Page<User> shopKeeperPage=null;
        try {
            shopKeeperPage=userRepository.findAll(userSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shopKeeperPage.getTotalElements()>0?shopKeeperPage:null;
    }

    public Integer countAllByIsDel0(final String username, final String nickname, final Integer status) throws Exception{

        //特殊情况查询
        Specification<User> userSpecification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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
            count=userRepository.count(userSpecification);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Long(count).intValue();
    }

    public String checkUsername(String username){
        return userRepository.checkUsername(username);
    }

    public String checkTelePhone(String telephone){
        return userRepository.checkTelePhone(telephone);
    }

    public String checkEmail(String email){
        return userRepository.checkEmail(email);
    }

    public String findUsernameById(Integer id){
        return userRepository.findUsernameById(id);
    }

    public void update(User user){
        userRepository.saveAndFlush(user);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User selectByUsername(String username){
        return userRepository.selectByUsername(username);
    }

    public User selectByEmail(String email){
        return userRepository.selectByEmail(email);
    }

    public String selectPasswordById(Integer id){
        return userRepository.selectPasswordById(id);
    }

    public User selectByTelephone(String telephone){
        return userRepository.selectByTelephone(telephone);
    }

    public String selectPasswordByEmail(String email) throws Exception{
        return new String(new BASE64Decoder().decodeBuffer(userRepository.selectPasswordByEmail(email)));
    }

    @Transactional
    public void updatePasswordByEmail(String email,String password) throws Exception{
        userRepository.updatePasswordByEmail(email,password);
    }

    @Transactional
    public void updatePasswordById(String password,Integer id){
        userRepository.updatePasswordById(password,id);
    }

    @Transactional
    public void updateNicknameById(String nickname,Integer id){
        userRepository.updateNicknameById(nickname,id);
    }

    @Transactional
    public void updateEmailById(String email,Integer id){
        userRepository.updateEmailById(email,id);
    }

    @Transactional
    public void updateTelephoneById(String telephone,Integer id){
        userRepository.updateTelephoneById(telephone,id);
    }

    public User findById(Integer id){
        return userRepository.findById(id);
    }

    @Transactional
    public void suoDingById(Integer id){
        userRepository.suoJieDing(id,1);
    }

    @Transactional
    public void jieDingById(Integer id){
        userRepository.suoJieDing(id,0);
    }

    @Transactional
    public void deleteByPrimaryKey(Integer id){
        userRepository.deleteByPrimaryKey(id);
    }

}
