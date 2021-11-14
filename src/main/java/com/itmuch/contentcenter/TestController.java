package com.itmuch.contentcenter;


import com.itmuch.contentcenter.dao.content.ShareMapper;
import com.itmuch.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ShareMapper shareMapper;

    @GetMapping("/test")
    public List<Share> testnsert(){

        Share share = new Share();
        share.setCreateTime(new Date());
        share.setAuthor("TW");
        share.setUpdateTime(new Date());
        share.setBuyCount(1);
        share.setCover("xxx");
        share.setTitle("xxx");
        this.shareMapper.insertSelective(share);
        List<Share> shares = this.shareMapper.selectAll();
        return shares;
    }
}
