package MainPackage.Controller;


import MainPackage.Beans.UserInfo;
import MainPackage.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/UserInfos")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/getInfoTypes", method = RequestMethod.POST)
    public List<UserInfo> getAll()
    {
        return userInfoService.getAll();
    }
}
