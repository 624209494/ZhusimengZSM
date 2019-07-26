package persneter;

import com.example.zhusimengzsm.bean.Bean1;

import java.util.List;

import model.CallBacks;
import model.ModleImpl;
import view.IView;

public class PersenterImpl implements IPersenter{

    private final ModleImpl modle;
    IView iView;
    public PersenterImpl(IView iView) {
        modle = new ModleImpl();
        this.iView = iView;
    }


    @Override
    public void getdatas() {
        modle.getdata(new CallBacks() {
            @Override
            public void getdataOK(List<Bean1.ResultBean.DataBean> list) {
                iView.getdataOK(list);
            }

            @Override
            public void getdataNo(String error) {
                iView.getdataNO(error);
            }
        });

    }
}
