package model;

import com.example.zhusimengzsm.bean.Bean1;

import java.util.List;

public interface CallBacks {
    void  getdataOK(List<Bean1.ResultBean.DataBean> list );
    void  getdataNo(String error);
}
