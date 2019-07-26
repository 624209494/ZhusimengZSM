package view;

import com.example.zhusimengzsm.bean.Bean1;

import java.util.List;

public interface IView {

    void getdataOK(List<Bean1.ResultBean.DataBean> list);
    void getdataNO(String error);
}
