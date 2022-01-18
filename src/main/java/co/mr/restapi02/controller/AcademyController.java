package co.mr.restapi02.controller;

import co.mr.restapi02.mapper.AcademyMapper;
import co.mr.restapi02.model.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academy")
public class AcademyController {

    @Autowired
    private AcademyMapper academyMapper;

    @PostMapping("")
    // 파라미터를 requestBody로 전달하도록 설정
    public int post(@RequestBody Academy academy) {
        return academyMapper.insert(academy);
    }
}
