package com.example.ex02.controller;

import com.example.ex02.domain.vo.Ex06VO;
import com.example.ex02.domain.vo.ExampleVO;
import com.example.ex02.domain.vo.UserVO;
import com.example.ex02.domain.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {
    // value에 정보를 작성하고 method에 호출할 서블릿 메소드를 설정한다.
    @RequestMapping(value = "/example", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex01(){
        log.info("ex01..............");
    }

    @GetMapping("")
    public void ex02(){
        log.info("ex02.....................");
    }

    @GetMapping("/ex03")
    public String ex03(ExampleVO exampleVO){
        log.info("----------------------");
        log.info(exampleVO.toString());
        log.info("----------------------");
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(TaskVO taskVO){
        log.info("----------------------");
        log.info(taskVO.toString());
        log.info("----------------------");
        return "ex04";
    }

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/login")
    public String login(UserVO userVO){
        return userVO.getUserId().equals("admin") ? "admin" : "user";
    }

    @GetMapping("/ex06")
    public void ex06() {
    }

    @PostMapping("/ex061")
    public String ex061(Ex06VO ex06VO) throws ParseException {
        return ex06VO.getNow().before(ex06VO.getStartTime())?"/getToWork":"/late";
    }

    @PostMapping("/ex062")
    public String ex062(Ex06VO ex06VO) throws ParseException {
        return ex06VO.getNow().after(ex06VO.getEndTime())?"/leaveWork":"/work";
    }

    @GetMapping("/upgrade")
    public String upgrade(){
        return "upgrade/form";
    }

    @PostMapping("/upgrade")
    public String upgrade(int choice, Model model){
        log.info("******************************** choice :::" + choice);
        int[] arr = new int[10]; // 확률 단위 10%
        // choice값만큼 확률 설정
        for(int i=0; i<choice; i++){
            arr[i] = 1;
        }
        Random random = new Random();
        boolean result = arr[random.nextInt(10)] == 1; // 성공 여부

        // 대성공 확률 설정 10%
        for(int i=0; i<1; i++){
            arr[i] = 1;
        }
        boolean result2 = arr[random.nextInt(10)] == 1; // 대성공 여부

        if(result){
            if(result2){
                return "greatSuccess";
            }
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/product")
    public String product(){return "product/market";}

    // 사용자가 입력한 바코드 번호에 알맞는 상품을 반환한다.
    @PostMapping("/check")
    public String check(String barcode, Model model) {

        String product = "";
        switch (barcode) {
            case "4383927":
                product = "오징어 땅콩";
                break;
            case "0832147":
                product = "초코 우유";
                break;
            case "9841631":
                product = "벌꿀 피자";
                break;
            case "5587578":
                product = "샌드위치";
                break;
            default: product="해당 상품은 존재하지 않습니다."; break;
        }

        model.addAttribute("product", product);
        return "product/cashier";
    }

    // 아이디 : apple
    // 비밀번호 : banana
    // 로그인 성공시 apple님 환영합니다
    // 로그인 실패시 로그인 실패
    @GetMapping("/userlogin")
    public String gotoLogin(){return "login/login";}

    @PostMapping("/userlogin")
    public  String userlogin(String id, String pw){
        boolean idCheck = id=="apple";
        boolean pwCheck = pw=="banana";

        if(idCheck & pwCheck){
            return "login/success";
        }
        return "login";
    }

    // 노래방 기계
    // 사용자의 점수에 따른 알맞은 메세지 출력
    @GetMapping("/singScroe")
    public String gotoSingScroe(){return "singScore";}

    @PostMapping("/singScroe")
    public  String SingScroe(int score, Model model){
        String resultStr = "";
        if(score>=80){
            resultStr="우수";
        }else if(score>=60){
            resultStr="평범";
        }else{
            resultStr="아쉽";
        }

        model.addAttribute("resultStr", resultStr);
        return "singResult";
    }
}
