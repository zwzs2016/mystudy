package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.Vo.VideoVo;
import cn.tedu.cppfoto.entity.Video;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoService {
    PageInfo<Video> select(int categoryId,int pageNum,int pageSize);

    Video select(int id);

    List<VideoVo> selectVideoVos(Integer userId,String type);
}
