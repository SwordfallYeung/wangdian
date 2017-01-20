package cn.wangdian.Service;

import cn.wangdian.Model.YuMing;
import cn.wangdian.Repository.YuMingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 25065 on 2016/9/18.
 */
@Service
public class YuMingService {

    @Autowired
    private YuMingRepository yuMingRepository;

    public YuMing onlyOne(){
        List<YuMing> yuMingList=yuMingRepository.findAll();
        if (yuMingList==null||yuMingList.size()==0){
            return null;
        }else {
            return yuMingList.get(0);
        }
    }

    public String yuMing(){
        List<YuMing> yuMingList=yuMingRepository.findAll();
        if (yuMingList==null||yuMingList.size()==0){
            return null;
        }else {
            return yuMingList.get(0).getYuming();
        }
    }


    public void save(YuMing yuMing){
        yuMingRepository.save(yuMing);
    }

    public void update(YuMing yuMing){
        yuMingRepository.saveAndFlush(yuMing);
    }
}
