package testDemo.adapters.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testDemo.adapters.XlsxController;


@RequiredArgsConstructor
@RestController(value = "/xlsx")
@RequestMapping(path = "/xlsx")
public class XlsxControllerImpl implements XlsxController {

    @Autowired
    private testDemo.domain.usecase.GetMinFromFileUC getMinFromFileUC;

    @Override
    public Integer getMaxFromFile(String path, Integer bound) {
        return getMinFromFileUC.getMinFromFileUC(path, bound);
    }
}
