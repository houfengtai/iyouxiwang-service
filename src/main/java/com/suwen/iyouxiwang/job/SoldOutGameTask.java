package com.suwen.iyouxiwang.job;

import com.suwen.iyouxiwang.dao.GamesMapper;
import com.suwen.iyouxiwang.domain.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SoldOutGameTask {
    @Autowired
    private GamesMapper gamesMapper;

    //每天半夜12点半执行
    @Scheduled(cron = "0 0 0 * * *")
    public void soldOutGames () {
        Long date = System.currentTimeMillis();
        List<Games> list = gamesMapper.selectByStatusAndType(0,1);
        list.forEach(it->{
            if(it.getEndDate().getTime() <= date){
                Games g = new Games();
                g.setId(it.getId());
                g.setStatus(1);
                gamesMapper.updateByPrimaryKeySelective(g);
            }
        });
    }
}
